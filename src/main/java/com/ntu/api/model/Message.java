package com.ntu.api.model;

import com.ntu.api.controller.additional.AboutController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Message {
    private static String message;

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        Message.message = message;
    }

    public static void errorCatch(AnchorPane pane, String name, String message){
        setMessage(message);
        Stage error = new Stage();
        error.setTitle(name);
        error.setResizable(false);

        AnchorPane errorDlg = null;

        try {
            errorDlg = FXMLLoader.load(Message.class.getResource("/com/ntu/api/javafx/model/additional/error.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        error.initOwner(pane.getScene().getWindow());
        error.initModality(Modality.WINDOW_MODAL);
        error.setScene(new Scene(errorDlg));
        error.show();
    }

    public static void helpOnClick(AnchorPane pane, String name, String message){
        Stage help = new Stage();
        help.setTitle(name);
        help.setResizable(false);
        AboutController.setMessage(message);

        AnchorPane helpDlg = null;
        try {
            helpDlg = FXMLLoader.load(Message.class.getResource("/com/ntu/api/javafx/model/additional/about.fxml"));
        } catch (IOException e) {
            Message.errorCatch(pane, "name", name + "Error");
        }

        help.initOwner(pane.getScene().getWindow());
        help.initModality(Modality.WINDOW_MODAL);
        help.setScene(new Scene(helpDlg));
        help.show();
    }
}
