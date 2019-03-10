package com.ntu.api.controller.additional.admin;

import com.ntu.api.controller.additional.admin.add.addBuildingFacultyController;
import com.ntu.api.controller.additional.admin.add.addCurriculumDepartmentGroupController;
import com.ntu.api.controller.additional.admin.add.addLessonSpecialityController;
import com.ntu.api.model.Message;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class inputController {
    @FXML private AnchorPane adminDlgInput;

    @FXML public void okOnClick(){

    }

    @FXML public void addBuilding(){
        add("Додавання корпусу", "/com/ntu/api/javafx/model/additional/admin/add/addBuildingFaculty.fxml", "Помилка додавання корпусу");
        addBuildingFacultyController.setBool(true);
    }
    @FXML public void addClassroom(){
        add("Додавання аудиторії", "/com/ntu/api/javafx/model/additional/admin/add/addClassRoom.fxml", "Помилка додавання аудиторії");
    }
    @FXML public void addCourse(){
        add("Додати курс", "com/ntu/api/javafx/model/additional/admin/add/addCourse.fxml", "Помилка додавання курсу");
    }
    @FXML public void addCurriculum(){
        add("Додавання освітньої програми", "/com/ntu/api/javafx/model/additional/admin/add/addCurriculumDepartmentGroup.fxml", "Помилка додавання освітньої програми");
        addCurriculumDepartmentGroupController.setCounter(1);
    }
    @FXML public void addDepartment(){
        add("Додавання кафедри", "/com/ntu/api/javafx/model/additional/admin/add/addCurriculumDepartmentGroup.fxml", "Помилка додавання кафедри");
        addCurriculumDepartmentGroupController.setCounter(2);
    }
    @FXML public void addGroup(){
        add("Додавання групи", "/com/ntu/api/javafx/model/additional/admin/add/addCurriculumDepartmentGroup.fxml", "Помилка додавання групи");
        addCurriculumDepartmentGroupController.setCounter(3);
    }
    @FXML public void addLesson(){
        add("Додавання заняття", "/com/ntu/api/javafx/model/additional/admin/add/addLessonSpeciality.fxml", "Помилка додавання заняття");
        addLessonSpecialityController.setBool(true);
    }
    @FXML public void addTeacher(){}
    @FXML public void addSpesiality(){
        add("Додавання заняття", "/com/ntu/api/javafx/model/additional/admin/add/addLessonSpeciality.fxml", "Помилка додавання заняття");
        addLessonSpecialityController.setBool(false);
    }
    @FXML public void addSubject(){}
    @FXML public void addFaculty(){
        add("Додати факультет", "/com/ntu/api/javafx/model/additional/admin/add/addBuildingFaculty.fxml", "Помилка додавання факультету");
        addBuildingFacultyController.setBool(false);
    }

    private void add(String title, String resource, String messsage){
        Stage add = new Stage();
        add.setTitle(title);
        add.setResizable(false);

        AnchorPane addPane = null;
        try {
            addPane = FXMLLoader.load(getClass().getResource(resource));
        } catch (IOException e) {
            Message.errorCatch(adminDlgInput, "Error", messsage);
        }
        add.initOwner(adminDlgInput.getScene().getWindow());
        add.initModality(Modality.WINDOW_MODAL);
        add.setScene(new Scene(addPane));
        add.show();
    }

    @FXML public void editBuilding(){}
    @FXML public void editClassroom(){}
    @FXML public void editCourse(){}
    @FXML public void editCurriculum(){}
    @FXML public void editDepartment(){}
    @FXML public void editGroup(){}
    @FXML public void editLesson(){}
    @FXML public void editTeacher(){}
    @FXML public void editSpesiality(){}
    @FXML public void editSubject(){}
    @FXML public void editFaculty(){}

    @FXML public void deleteBuilding(){}
    @FXML public void deleteClassroom(){}
    @FXML public void deleteCourse(){}
    @FXML public void deleteCurriculum(){}
    @FXML public void deleteDepartment(){}
    @FXML public void deleteGroup(){}
    @FXML public void deleteLesson(){}
    @FXML public void deleteTeacher(){}
    @FXML public void deleteSpesiality(){}
    @FXML public void deleteSubject(){}
    @FXML public void deleteFaculty(){}


}
