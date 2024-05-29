package com.progtech.ptgy2024_rallyprogram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import program.database.ListAllRacerNamesCommand;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final Logger log = LogManager.getLogger(FileManager.class);
    private List<String> subbedEvents;

    public FileManager() {
        subbedEvents = new ArrayList<>();
        LoadFromFile();
    }

    public List<String> getSubbedEvents() { return subbedEvents; }

    public void addSubbedEvent(String eventID) {
        if(subbedEvents.contains(eventID)) { return; }
        subbedEvents.add(eventID);
        log.info("Feliratkozott esemény hozzáadva!");
    }

    public void removeSubbedEvent(String eventID) {
        if(!subbedEvents.contains(eventID)) { return; }
        subbedEvents.remove(eventID);
        log.info("Feliratkozott esemény törölve!");
    }

    public boolean containsSubbedEvent(String eventID)  { return subbedEvents.contains(eventID); }

    public void SaveToFile() {
        if(subbedEvents.isEmpty()) { return; }
        try {
            FileWriter fw = new FileWriter("subbedevent.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);

            for(String event : subbedEvents) {
                bw.write(event); bw.newLine();
            }

            bw.close();
            fw.close();
            log.info("Fájl elmentve!");
        } catch(Exception e) { e.printStackTrace(); }
    }

    public void LoadFromFile() {
        try {
            if(!new File("subbedevent.txt").exists()) { return; }
            FileReader fr = new FileReader("subbedevent.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null)  {
                subbedEvents.add(line);
            }

            br.close();
            fr.close();
            log.info("Fájl betöltve!");
        } catch(Exception e) { e.printStackTrace(); }
    }
}
