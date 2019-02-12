package com.ntu.api;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TimeTableNtuApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("NTU TimeTable 1.2.0");
        primaryStage.setResizable(false);

        Parent main = FXMLLoader.load(getClass().getResource("/com/ntu/api/javafx/model/main.fxml"));

        primaryStage.setScene(new Scene(main));
        primaryStage.show();
    }
}
