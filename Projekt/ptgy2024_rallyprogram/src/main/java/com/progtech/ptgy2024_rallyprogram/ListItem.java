package com.progtech.ptgy2024_rallyprogram;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import program.database.CommandWithResult;
import program.database.ListCarDataCommand;
import program.database.ListRacerDataCommand;
import program.database.ListStageDataCommand;
import program.database.exceptions.CommandNotExecutedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class ListItem {

    public ImageView itemBackground;

    public int itemID;
    public int categoryID;
    public ImageView item_icon;
    public Label item_label;

    @FXML
    public void initialize() { itemBackground.setImage(new Image(getClass().getResourceAsStream("img/listitem_bg.png"))); }

    public void SetID(int id) { itemID = id; }

    public void SetCategoryID(int id) { categoryID = id; }

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

        CommandWithResult<ArrayList<String>> command;

        switch(categoryID)
        {
            case 1:
                command = new ListStageDataCommand(itemID);
                command.execute();
                ProgramApplication.getInstance().GenerateInfoWindow("Info", command.getResult());
                break;
            case 2:
                command = new ListRacerDataCommand(itemID);
                command.execute();
                ProgramApplication.getInstance().GenerateInfoWindow("Info", command.getResult());
                break;
            case 3:
                command = new ListCarDataCommand(itemID);
                command.execute();
                ProgramApplication.getInstance().GenerateInfoWindow("Info", command.getResult());
                break;
        }
    }

    void ButtonHover(ImageView imgView, boolean hover) {
        if (hover) {
            imgView.setStyle("-fx-effect: innershadow(gaussian, gray, 100, 1, 1, 1)");
        } else {
            imgView.setStyle("");
        }
    }
}
