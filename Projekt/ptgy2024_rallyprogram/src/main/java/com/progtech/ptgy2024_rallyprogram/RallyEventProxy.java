package com.progtech.ptgy2024_rallyprogram;

import program.database.CheckIfEventExistsCommand;
import program.database.GetEventDateCommand;
import program.database.GetEventNameCommand;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RallyEventProxy implements IBaseNotification {

    public List<String> subscribedEvents;

    public RallyEventProxy() {
        subscribedEvents = ProgramApplication.getInstance().fileManager.getSubbedEvents();
        CheckEvents();
    }

    public void CheckEvents()
    {
        if(subscribedEvents == null) { return; }

        for(String event : subscribedEvents)
        {
            CheckIfEventExistsCommand exists = new CheckIfEventExistsCommand(event);
            exists.execute();
            if(!exists.getResult()) { continue; }

            GetEventDateCommand dateCommand = new GetEventDateCommand(event);
            dateCommand.execute();

            GetEventNameCommand nameCommand = new GetEventNameCommand(event);
            nameCommand.execute();

            Timestamp timestamp = dateCommand.getResult();

            LocalDateTime start = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp.getTime()), ZoneId.systemDefault()).truncatedTo(ChronoUnit.DAYS);
            LocalDateTime end = LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault()).truncatedTo(ChronoUnit.DAYS);
            Duration duration = Duration.between(end, start);

            long dayDifference = duration.toDays();
            String eventName = nameCommand.getResult();

            if(dayDifference <= 7 && dayDifference >= 0) {
                sendNotify("A következő esemény " + dayDifference + " nap múlva kerül megrendezésre: " + eventName);
            }
        }
    }

    @Override
    public void sendNotify(String message) {
        RallyEventNotification newNotification = new RallyEventNotification();
        newNotification.sendNotify(message);
    }
}
