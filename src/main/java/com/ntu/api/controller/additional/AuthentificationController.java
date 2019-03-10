package com.ntu.api.controller.additional;

import com.ntu.api.domain.database.entity.User;
import com.ntu.api.domain.database.service.serviceInterface.UserServiceInt;
import com.ntu.api.model.Message;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class AuthentificationController {
    @FXML
    private AnchorPane dlgAuthentification;
    @FXML
    TextField fldLogin;
    @FXML
    PasswordField fldPassword;

    @FXML
    public void authentificationOnClick() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/ntu/api/spring/database/config.xml");
        UserServiceInt userService = context.getBean(UserServiceInt.class);
        if (fldLogin.getText().equals("") || fldPassword.getText().equals("")) {
            Message.errorCatch(dlgAuthentification, "Error", "Заповнені не всі поля. Заповніть будь-ласка всі поля");
        }
        else {
            if (fldLogin.getText().equals("Admin") || fldPassword.getText().equals("isBigBoss")) {
                closeOnClick();
                Stage adminInput = new Stage();
                adminInput.setTitle("Admin Mode");
                adminInput.setResizable(false);
                AnchorPane correct = null;
                try {
                    correct = FXMLLoader.load(getClass().getResource("/com/ntu/api/javafx/model/additional/admin/input.fxml"));

                } catch (IOException e) {
                    Message.errorCatch(dlgAuthentification,"Error","StartError");
                }

                adminInput.initOwner(dlgAuthentification.getScene().getWindow());
                adminInput.initModality(Modality.WINDOW_MODAL);
                adminInput.setScene(new Scene(correct));
                adminInput.show();
            }
            else{
                if (!userService.authentUser(new User(fldLogin.getText(), fldPassword.getText()))) {
                    Message.errorCatch(dlgAuthentification, "Error", "Ви ввели невірний логін або пароль.");
                } else {
                    okOnClick();
                    Stage dlgStart = new Stage();
                    dlgStart.setTitle("NTU TimeTable 1.2.0");
                    dlgStart.setResizable(false);

                    AnchorPane start = null;
                    try {
                        start = FXMLLoader.load(getClass().getResource("/com/ntu/api/javafx/model/main/start.fxml"));
                    } catch (IOException e) {
                        Message.errorCatch(dlgAuthentification, "Error", "Start Error");
                    }

                    dlgStart.initOwner(dlgAuthentification.getScene().getWindow());
                    dlgStart.initModality(Modality.WINDOW_MODAL);
                    dlgStart.setScene(new Scene(start));
                    dlgStart.show();
                }
                cleanField();
            }
        }
    }

    @FXML
    public void closeOnClick(){
        Stage dlg = (Stage) dlgAuthentification.getScene().getWindow();
        dlg.close();
    }

    public void okOnClick(){
        Stage dlg = (Stage) dlgAuthentification.getScene().getWindow();
        dlg.close();
    }


    private void cleanField(){
        fldPassword.clear();
        fldLogin.clear();
    }

}
