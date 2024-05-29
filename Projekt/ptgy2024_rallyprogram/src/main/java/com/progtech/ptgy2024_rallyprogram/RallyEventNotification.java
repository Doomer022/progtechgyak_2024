package com.progtech.ptgy2024_rallyprogram;

import javafx.scene.control.Alert;

public class RallyEventNotification implements IBaseNotification {

    @Override
    public void sendNotify(String message) {
        Alert popup = new Alert(Alert.AlertType.INFORMATION);
        popup.setTitle("Esemény értesítés!");
        popup.setContentText(message);
        popup.showAndWait();
    }
}
