package com.progtech.ptgy2024_rallyprogram;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ListItem {

    public ImageView itemBackground;

    public int itemID;
    public int categoryID;
    public ImageView item_icon;
    public Label item_label;

    @FXML
    public void initialize() { itemBackground.setImage(new Image(getClass().getResourceAsStream("img/listitem_bg.png"))); }

    public void SetID(int id) { itemID = id; }

    public void SetIcon(String route) {
        item_icon.setImage(new Image(getClass().getResourceAsStream(route)));
    }

    public void SetLabel(String label) {
        item_label.setText(label);
    }

    public void SetIconStyle(String style) {
        item_icon.setStyle(style);
    }

    @FXML
    public void onButtonEnter(MouseEvent e) { ButtonHover(itemBackground, true); }

    @FXML
    public void onButtonExit(MouseEvent e) { ButtonHover(itemBackground, false); }

    @FXML
    public void onButtonClicked(MouseEvent e) throws Exception {
        ProgramApplication.getInstance().GenerateInfoWindow("Test", new String[] { "1.", "2.", "3." }, new String[] { "Első", "Második", "Harmadik" });
    }

    void ButtonHover(ImageView imgView, boolean hover) {
        if (hover) {
            imgView.setStyle("-fx-effect: innershadow(gaussian, gray, 100, 1, 1, 1)");
        } else {
            imgView.setStyle("");
        }
    }

}
