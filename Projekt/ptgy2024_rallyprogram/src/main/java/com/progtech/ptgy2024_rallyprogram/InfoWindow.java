package com.progtech.ptgy2024_rallyprogram;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class InfoWindow {

    public VBox itemBox;

    public void GenerateList(ArrayList<String> content) throws Exception {
        for(int i = 0; i < content.size(); i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("items/info-window-item.fxml"));
            Parent root = loader.load();
            InfoWindowItem infoWindowItem = loader.getController();
            String[] labelText = content.get(i).split(";");
            infoWindowItem.SetLabel(labelText[0] + " " + labelText[1]);
            itemBox.getChildren().add(root);
        }
    }
    
    public void onWindowClose() { itemBox.getChildren().clear(); }
}
