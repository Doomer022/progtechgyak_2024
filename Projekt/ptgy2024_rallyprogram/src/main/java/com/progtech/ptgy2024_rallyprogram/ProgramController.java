package com.progtech.ptgy2024_rallyprogram;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProgramController {

    public ImageView countryButton;
    public ImageView stageButton;
    public ImageView driverButton;
    public ImageView carButton;

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
            imgView.setStyle("-fx-effect: innershadow(gaussian, green, 7, 1, 1, 1)");
        } else {
            imgView.setStyle("");
        }
    }
}