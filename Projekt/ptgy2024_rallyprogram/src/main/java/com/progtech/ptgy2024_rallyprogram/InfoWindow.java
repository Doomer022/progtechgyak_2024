package com.progtech.ptgy2024_rallyprogram;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class InfoWindow {

    public VBox itemBox;

    public void GenerateList(String[] header, String[] content) throws Exception {
        for(int i = 0; i < content.length; i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("items/info-window-item.fxml"));
            Parent root = loader.load();
            InfoWindowItem infoWindowItem = loader.getController();
            infoWindowItem.SetLabel(header[i] + " " + content[i]);
            itemBox.getChildren().add(root);
        }
    }
    
    public void onWindowClose() { itemBox.getChildren().clear(); }
}
