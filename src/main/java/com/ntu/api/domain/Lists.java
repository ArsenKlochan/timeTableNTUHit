package com.ntu.api.domain;

import com.ntu.api.domain.database.entity.*;
import com.ntu.api.domain.database.entity.enums.ClassRoomTypes;
import com.ntu.api.domain.database.entity.enums.ExamType;
import com.ntu.api.domain.database.entity.enums.LessonType;
import com.ntu.api.domain.database.service.serviceInterface.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class Lists {
    private static ArrayList<String> buildingList;
    private static ArrayList<String> classRoomList;
    private static ArrayList<String> courseList;
    private static ArrayList<String> curriculumList;
    private static ArrayList<String> departmentList;
    private static ArrayList<String> facultyList;
    private static ArrayList<String> groupeList;
    private static ArrayList<String> lessonList;
    private static ArrayList<String> specialityList;
    private static ArrayList<String> subjectList;
    private static ArrayList<String> teacherList;
    private static ArrayList<String> classRoomTypeList;
    private static ArrayList<String> examList;
    private static ArrayList<String> lessonTypeList;

    private static ApplicationContext context = new ClassPathXmlApplicationContext("com/ntu/api/spring/database/config.xml");
    private static BuildingServiceInt buildingService = context.getBean(BuildingServiceInt.class);
    private static ClassRoomServiceInt classRoomService = context.getBean(ClassRoomServiceInt.class);
    private static CourseServiceInt courseService = context.getBean(CourseServiceInt.class);
    private static CurriculumServiceInt curriculumService = context.getBean(CurriculumServiceInt.class);
    private static DepartmentServiceInt departmentService = context.getBean(DepartmentServiceInt.class);
    private static FacultyServiceInt facultyService = context.getBean(FacultyServiceInt.class);
    private static GroupServiceInt groupService = context.getBean(GroupServiceInt.class);
    private static LessonServiceInt lessonService = context.getBean(LessonServiceInt.class);
    private static SpecialityServiceInt specialityService = context.getBean(SpecialityServiceInt.class);
    private static SubjectServiceInt subjectService = context.getBean(SubjectServiceInt.class);
    private static TeacherServiceInt teacherService = context.getBean(TeacherServiceInt.class);

    public static BuildingServiceInt getBuildingService() {
        return buildingService;
    }
    public static ClassRoomServiceInt getClassRoomService() {
        return classRoomService;
    }
    public static CourseServiceInt getCourseService() {
        return courseService;
    }
    public static CurriculumServiceInt getCurriculumService() {
        return curriculumService;
    }
    public static DepartmentServiceInt getDepartmentService() {
        return departmentService;
    }
    public static FacultyServiceInt getFacultyService() {
        return facultyService;
    }
    public static GroupServiceInt getGroupService() {
        return groupService;
    }
    public static LessonServiceInt getLessonService() {
        return lessonService;
    }
    public static SpecialityServiceInt getSpecialityService() {
        return specialityService;
    }
    public static SubjectServiceInt getSubjectService() {
        return subjectService;
    }
    public static TeacherServiceInt getTeacherService() {
        return teacherService;
    }

    public static ArrayList<String> getBuildingList() {
        ArrayList<String> tempList = new ArrayList<>();
        for(Building building:buildingService.getBuildingList()){
            tempList.add(building.getBuildingName());
        }
        return tempList;
    }
    public static ArrayList<String> getClassRoomList() {
        ArrayList<String> tempList = new ArrayList<>();
        for(ClassRoom classRoom:classRoomService.getClassRoomList()){
            tempList.add(classRoom.getClassRoomName());
        }
        return tempList;
    }
    public static ArrayList<String> getCourseList() {
        ArrayList<String> tempList = new ArrayList<>();
        for(Course course:courseService.getCourses()){
            tempList.add(course.getCourseName());
        }
        return tempList;
    }
    public static ArrayList<String> getCurriculumList() {
        ArrayList<String> tempList = new ArrayList<>();
        for(Curriculum curriculum:curriculumService.getCurriculums()){
            tempList.add(curriculum.getCurriculumName());
        }
        return tempList;
    }
    public static ArrayList<String> getDepartmentList() {
        ArrayList<String> tempList = new ArrayList<>();
        for(Department department:departmentService.getDepartments()){
            tempList.add(department.getDepartmentName());
        }
        return tempList;
    }
    public static ArrayList<String> getFacultyList() {
        ArrayList<String> tempList = new ArrayList<>();
        for(Faculty faculty:facultyService.getFaculties()){
            tempList.add(faculty.getFacultyName());
        }
        return tempList;
    }
    public static ArrayList<String> getGroupeList() {
        ArrayList<String> tempList = new ArrayList<>();
        for(Group group:groupService.getGroups()){
            tempList.add(group.getGroupName());
        }
        return tempList;
    }
    public static ArrayList<String> getLessonList() {
        ArrayList<String> tempList = new ArrayList<>();
        for(Lesson lesson:lessonService.getLessons()){
            tempList.add(lesson.getLessonName());
        }
        return tempList;
    }
    public static ArrayList<String> getSpecialityList() {
        ArrayList<String> tempList = new ArrayList<>();
        for(Speciality speciality:specialityService.getSpecialities()){
            tempList.add(speciality.getSpecialityName());
        }
        return tempList;
    }
    public static ArrayList<String> getSubjectList() {
        ArrayList<String> tempList = new ArrayList<>();
        for(Subject subject:subjectService.getSubjectList()){
            tempList.add(subject.getSubjectName());
        }
        return tempList;
    }
    public static ArrayList<String> getTeacherList() {
        ArrayList<String> tempList = new ArrayList<>();
        for(Teacher teacher:teacherService.getTeachers()){
            tempList.add(teacher.getTeacherSurname()+teacher.getTeacherName());
        }
        return tempList;
    }

    public static ArrayList<String> getClassRoomTypeList() {
        ArrayList<String> tempList = new ArrayList<>();
        for(ClassRoomTypes roomType:ClassRoomTypes.values()){
            tempList.add(roomType.toString());
        }
        return tempList;
    }

    public static ArrayList<String> getExamList() {
        ArrayList<String> tempList = new ArrayList<>();
        for(ExamType examType:ExamType.values()){
            tempList.add(examType.toString());
        }
        return tempList;
    }

    public static ArrayList<String> getLessonTypeList() {
        ArrayList<String> tempList = new ArrayList<>();
        for(LessonType lessonType:LessonType.values()){
            tempList.add(lessonType.toString());
        }
        return tempList;
    }
}
