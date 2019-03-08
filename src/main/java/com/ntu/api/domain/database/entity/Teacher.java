package com.ntu.api.domain.database.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @Column(name = "teacher_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacherId;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "teacher_surname")
    private String teacherSurname;

    @Column(name = "teacher_degree")
    private String teacherDegree;

    @Column(name = "teacher_status")
    private String teacherStatus;

    @Column(name = "teacher_position")
    private String teacherPosition;

    @Column(name = "teacher_description")
    private String teacherDescription;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Department.class)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public Teacher(){}

    public Teacher(String teacherName, String teacherSurname, String teacherDegree, String teacherStatus,
                   String teacherPosition, String teacherDescription, Faculty faculty, Department department) {
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.teacherDegree = teacherDegree;
        this.teacherStatus = teacherStatus;
        this.teacherPosition = teacherPosition;
        this.teacherDescription = teacherDescription;
        this.department = department;
    }

    public Long getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public String getTeacherSurname() {
        return teacherSurname;
    }
    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }
    public String getTeacherDegree() {
        return teacherDegree;
    }
    public void setTeacherDegree(String teacherDegree) {
        this.teacherDegree = teacherDegree;
    }
    public String getTeacherStatus() {
        return teacherStatus;
    }
    public void setTeacherStatus(String teacherStatus) {
        this.teacherStatus = teacherStatus;
    }
    public String getTeacherPosition() {
        return teacherPosition;
    }
    public void setTeacherPosition(String teacherPosition) {
        this.teacherPosition = teacherPosition;
    }
    public String getTeacherDescription() {
        return teacherDescription;
    }
    public void setTeacherDescription(String teacherDescription) {
        this.teacherDescription = teacherDescription;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Teacher{");
        sb.append("teacherId=").append(teacherId);
        sb.append(", teacherName='").append(teacherName).append('\'');
        sb.append(", teacherSurname='").append(teacherSurname).append('\'');
        sb.append(", teacherDegree='").append(teacherDegree).append('\'');
        sb.append(", teacherStatus='").append(teacherStatus).append('\'');
        sb.append(", teacherPosition='").append(teacherPosition).append('\'');
        sb.append(", teacherDescription='").append(teacherDescription).append('\'');
        sb.append(", department=").append(department.getDepartmentName());
        sb.append('}');
        return sb.toString();
    }
}
