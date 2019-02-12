package com.ntu.api.domain.database.service.serviceInterface;

import com.ntu.api.domain.database.entity.*;

import java.util.List;

public interface CourseServiceInt {
    Long addCourse(Course course);
    Course getCourse(Long id);
    void updateCourse (Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();
}
