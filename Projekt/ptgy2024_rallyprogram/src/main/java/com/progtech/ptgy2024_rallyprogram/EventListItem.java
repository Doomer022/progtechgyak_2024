package com.progtech.ptgy2024_rallyprogram;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

public class EventListItem extends ListItem {

    public String eventID;

    public void SetEventID(String _eventID) { eventID = _eventID; }

    @FXML
    public void onEventButtonClicked(MouseEvent e) {
        if(ProgramApplication.getInstance().fileManager.containsSubbedEvent(eventID)) {
            askForRemoval();
        } else { askForAddition(); }
    }

    void askForAddition() {
        Alert popup = new Alert(Alert.AlertType.CONFIRMATION);
        popup.setTitle("Esemény feliratkozás!");
        popup.setContentText("Szeretne emlékeztetőt helyezni erre az eseményre?");
        popup.showAndWait();

        ButtonType okButton = new ButtonType("Igen");
        ButtonType cancelButton = new ButtonType("Nem");

        popup.getButtonTypes().setAll(okButton, cancelButton);

        Optional<ButtonType> result = popup.showAndWait();
        if(result.get() == okButton) { ProgramApplication.getInstance().fileManager.addSubbedEvent(eventID); }
        if(result.get() == cancelButton) { popup.close(); }
    }

    void askForRemoval() {
        Alert popup = new Alert(Alert.AlertType.CONFIRMATION);
        popup.setTitle("Esemény leiratkozás!");
        popup.setContentText("Szeretné az emlékeztetőt törölni erről az eseményről?");
        popup.showAndWait();

        ButtonType okButton = new ButtonType("Igen");
        ButtonType cancelButton = new ButtonType("Nem");

        popup.getButtonTypes().setAll(okButton, cancelButton);

        Optional<ButtonType> result = popup.showAndWait();
        if(result.get() == okButton) { ProgramApplication.getInstance().fileManager.removeSubbedEvent(eventID); }
        if(result.get() == cancelButton) { popup.close(); }
    }
}
