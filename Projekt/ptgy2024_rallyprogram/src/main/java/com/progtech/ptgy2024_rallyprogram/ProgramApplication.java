package com.progtech.ptgy2024_rallyprogram;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProgramApplication extends Application {

    private static ProgramApplication instance;
    Scene lastDataScene;

    private String[] categoryImageURL = new String[] { "img/hungary.png", "img/road.png", "img/helmet.png", "img/car.png" };

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProgramApplication.class.getResource("windows/base-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Rally Program");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        instance = new ProgramApplication();
    }

    public static ProgramApplication getInstance() { return instance; }

    public static void main(String[] args) {
        launch();
    }

    public void GenerateInfoWindow(String title, String[] header, String[] content) throws Exception {
        if(lastDataScene != null) { return; }
        if(header.length != content.length) { return; }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("windows/info-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
        lastDataScene = scene;
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

        InfoWindow infoWindow = fxmlLoader.getController();
        infoWindow.GenerateList(header, content);

        stage.setOnCloseRequest(event -> { ClearLastScene(); });
    }

    public String GetCategoryImageURL(int category) { return categoryImageURL[category]; }

    public void ClearLastScene() { lastDataScene = null; }
}