package com.progtech.ptgy2024_rallyprogram;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RallyEventProxy implements IBaseNotification {

    public List<String> subscribedEvents = new ArrayList<String>();

    public RallyEventProxy()  {
        try {
            if(!new File("subbedevent.txt").exists()) { return; }
            FileReader fr = new FileReader("subbedevent.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null)  {
                subscribedEvents.add(line);
            }

            br.close();
            fr.close();
        } catch(Exception e) { e.printStackTrace(); }

        CheckEvents();
    }

    public void CheckEvents()
    {
        for(String event : subscribedEvents)
        {
            //FIND IF EVENT WITH IDENTIFIER EXISTS
            //GET TIMESTAMP FROM DATABASE
            //GET EVENT NAME FROM DATABASE

            Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //PLACEHOLDER FOR EVENT TIMESTAMP
            int dayDifference = (int)TimeUnit.DAYS.convert(timestamp.getTime() - System.currentTimeMillis(), TimeUnit.DAYS);
            String eventName = "Eger Rally"; //PLACEHOLDER FOR EVENT NAME

            if(dayDifference <= 7) {
                sendNotify("A következő event " + dayDifference + " nap múlva kerül megrendezésre: " + eventName);
            }
        }
    }

    @Override
    public void sendNotify(String message) {
        RallyEventNotification newNotification = new RallyEventNotification();
        newNotification.sendNotify(message);
    }

    void WriteToFile() {
        try {
            FileWriter fw = new FileWriter("subbedevent.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);

            for(String event : subscribedEvents) {
                bw.write(event); bw.newLine();
            }

            bw.close();
            fw.close();
        } catch(Exception e) { e.printStackTrace(); }
    }
}
