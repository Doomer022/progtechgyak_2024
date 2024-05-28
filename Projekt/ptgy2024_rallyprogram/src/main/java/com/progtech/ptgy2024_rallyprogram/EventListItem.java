package com.progtech.ptgy2024_rallyprogram;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class EventListItem extends ListItem {

    public int eventID;

    public void SetEventID(int _eventID) { eventID = _eventID; }

    @FXML
    public void onEventButtonClicked(MouseEvent e)
    {
        
    }
}
