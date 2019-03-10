package com.ntu.api.controller.additional.admin.add;

import com.ntu.api.domain.Lists;
import com.ntu.api.domain.database.entity.Course;
import com.ntu.api.domain.database.service.serviceInterface.CourseServiceInt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class addCourseController {
    @FXML AnchorPane addCourse;
    @FXML Label label1;
    @FXML Label label2;
    @FXML Label label3;
    @FXML TextField text1;
    @FXML TextField text2;
    @FXML ComboBox box1;
    @FXML Button button1;
    @FXML Button button2;
    private static ObservableList<String> specialityList;

    @FXML public void initialize(){
        label1.setText("Назва курсу");
        label2.setText("Опис курсу");
        label2.setText("Спеціальність");
        button1.textProperty().set("Додати курс");
        specialityList = FXCollections.observableArrayList();
        specialityList.addAll(Lists.getSpecialityList());
        box1.setEditable(false);
        box1.getItems().setAll(specialityList);
    }

    @FXML public void okOnClick(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/ntu/api/spring/database/config.xml");
        CourseServiceInt courseService = context.getBean(CourseServiceInt.class);
        courseService.addCourse(new Course(text1.getText(), text2.getText(),
                Lists.getSpecialityService().getSpecialities().get(box1.getSelectionModel().getSelectedIndex())));
        cancelOnClick();
    }

    @FXML public void cancelOnClick(){
        Stage dlg = (Stage)(addCourse.getScene().getWindow());
        dlg.close();
    }
}
