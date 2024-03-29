package com.ntu.api.controller.additional.admin.add;

import com.ntu.api.domain.Lists;
import com.ntu.api.domain.database.entity.Faculty;
import com.ntu.api.domain.database.entity.Lesson;
import com.ntu.api.domain.database.entity.Speciality;
import com.ntu.api.domain.database.entity.enums.LessonType;
import com.ntu.api.domain.database.service.serviceInterface.LessonServiceInt;
import com.ntu.api.domain.database.service.serviceInterface.SpecialityServiceInt;
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

public class addLessonSpecialityController {
    @FXML AnchorPane addLessonSpeciality;
    @FXML Label label1;
    @FXML Label label2;
    @FXML Label label3;
    @FXML Label label4;
    @FXML TextField text1;
    @FXML TextField text2;
    @FXML ComboBox<String> box1;
    @FXML ComboBox<String> box2;
    @FXML Button button1;
    @FXML Button button2;
    private static boolean bool;
    private static ObservableList<String> lessonTypeList;
    private static ObservableList<String> subjectList;
    private static ObservableList<String> curriculumList;
    private static ObservableList<String> departmentList;

    public static void setBool(boolean bool) {
        addLessonSpecialityController.bool = bool;
    }

    @FXML public void initialize(){
        if(bool){
            label1.setText("Назва заняття");
            label1.setText("Опис заняття");
            label1.setText("Тип заняття");
            label1.setText("Дисципліна");
            button1.textProperty().set("Додати заняття");

            lessonTypeList = FXCollections.observableArrayList();
            subjectList = FXCollections.observableArrayList();

            lessonTypeList.addAll(Lists.getLessonTypeList());
            subjectList.addAll(Lists.getSubjectList());

            box1.setEditable(false);
            box2.setEditable(false);

            box1.getItems().setAll(lessonTypeList);
            box2.getItems().setAll(subjectList);
        }
        else{
            label1.setText("Назва спеціальності");
            label1.setText("Опис спеціальності");
            label1.setText("Освітня програма");
            label1.setText("Кафедра");
            button1.textProperty().set("Додати спеціальність");

            curriculumList = FXCollections.observableArrayList();
            departmentList = FXCollections.observableArrayList();

            curriculumList.addAll(Lists.getCurriculumList());
            departmentList.addAll(Lists.getDepartmentList());

            box1.setEditable(false);
            box2.setEditable(false);

            box1.getItems().setAll(lessonTypeList);
            box2.getItems().setAll(subjectList);
        }

    }

    @FXML public void okOnClick(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "com/ntu/api/spring/database/config.xml");
        if(bool == true) {
            LessonServiceInt lessonService = context.getBean(LessonServiceInt.class);
            lessonService.addLesson(new Lesson(text1.getText(), text2.getText(),
                    LessonType.valueOf(box1.getSelectionModel().getSelectedItem()),
                    Lists.getSubjectService().getSubjectList().get(box2.getSelectionModel().getSelectedIndex())));
        }
        else{
            SpecialityServiceInt specialityService = context.getBean(SpecialityServiceInt.class);
            specialityService.addSpeciality(new Speciality(text1.getText(), text2.getText(),
                    Lists.getCurriculumService().getCurriculums().get(box1.getSelectionModel().getSelectedIndex()),
                    Lists.getDepartmentService().getDepartments().get(box2.getSelectionModel().getSelectedIndex())));
        }
        cancelOnClick();
    }

    @FXML public void cancelOnClick(){
        Stage dlg = (Stage)(addLessonSpeciality.getScene().getWindow());
        dlg.close();
    }
}
