package com.ntu.api.controller.additional.admin.add;

import com.ntu.api.domain.database.entity.Building;
import com.ntu.api.domain.database.entity.Faculty;
import com.ntu.api.domain.database.service.serviceImplementation.FacultyService;
import com.ntu.api.domain.database.service.serviceInterface.BuildingServiceInt;
import com.ntu.api.domain.database.service.serviceInterface.FacultyServiceInt;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class addBuildingFacultyController {
    @FXML AnchorPane addBuildingFaculty;
    @FXML Label label1;
    @FXML Label label2;
    @FXML Label label3;
    @FXML TextField text1;
    @FXML TextField text2;
    @FXML TextArea text3;
    @FXML Button button1;
    @FXML Button button2;
    private static boolean bool;

    public static void setBool(boolean bool) {
        addBuildingFacultyController.bool = bool;
    }

    @FXML public void initialize(){
        label1.setText("Назва");
        label2.setText("Опис");
        label3.setText("Адреса");
    }
    @FXML public void cancelOnClick(){
        Stage dlg = (Stage)(addBuildingFaculty.getScene().getWindow());
        dlg.close();
    }

    @FXML public void okOnClick(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/ntu/api/spring/database/config.xml");
        if(bool == true) {
            BuildingServiceInt buildingService = context.getBean(BuildingServiceInt.class);
            buildingService.addBuilding(new Building(text1.getText(), text2.getText(),text3.getText()));
        }
        else{
            FacultyServiceInt facultyService = context.getBean(FacultyServiceInt.class);
            facultyService.addFaculty(new Faculty(text1.getText(), text2.getText(),text3.getText()));
        }
        cancelOnClick();
    }
}
