package com.progtech.ptgy2024_rallyprogram;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ProgramController {

    /*FXML SPECIFIC*/
    public ImageView countryButton;
    public ImageView stageButton;
    public ImageView driverButton;
    public ImageView carButton;

    public VBox itemListBox;

    @FXML
    public void initialize()
    {
        TestScrollPane(10);
    }

    @FXML
    public void onCountryButtonMouseEnter(MouseEvent e) { ButtonHover(countryButton, true); }

    @FXML
    public void onCountryButtonMouseExit(MouseEvent e) { ButtonHover(countryButton, false); }

    @FXML
    public void onStageButtonMouseEnter(MouseEvent e) { ButtonHover(stageButton, true); }

    @FXML
    public void onStageButtonMouseExit(MouseEvent e) { ButtonHover(stageButton, false); }

    @FXML
    public void onDriverButtonMouseEnter(MouseEvent e) { ButtonHover(driverButton, true); }

    @FXML
    public void onDriverButtonMouseExit(MouseEvent e) { ButtonHover(driverButton, false); }

    @FXML
    public void onCarButtonMouseEnter(MouseEvent e) { ButtonHover(carButton, true); }

    @FXML
    public void onCarButtonMouseExit(MouseEvent e) { ButtonHover(carButton, false); }


    void ButtonHover(ImageView imgView, boolean hover) {
        if (hover) {
            imgView.setStyle("-fx-effect: innershadow(gaussian, green, 20, 1, 1, 1)");
        } else {
            imgView.setStyle("");
        }
    }

    void TestScrollPane(int listSize)
    {
        for(int i = 0; i < listSize; i++)
        {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("list-item.fxml"));
                Parent root = (Parent)loader.load();
                ListItem itemControl = loader.getController();
                itemControl.item_label.setText("Rally Program Teszt");
                itemControl.item_icon.setImage(new Image(getClass().getResourceAsStream("img/hungary.png")));
                itemListBox.getChildren().add(root);
            }
            catch (Exception ex) { ex.printStackTrace(); }
        }
    }
}