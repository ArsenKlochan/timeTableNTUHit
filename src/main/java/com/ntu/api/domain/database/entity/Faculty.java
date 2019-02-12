package com.ntu.api.domain.database.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @Column(name = "faculty_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long facultyId;

    @Column(name= "faculty_name")
    private String facultyName;

    @Column(name = "faculty_description")
    private String facultyDescription;

    @Column(name = "faculty_adress")
    private String facultyAdress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "faculty", targetEntity = Curriculum.class)
    @Column(name="faculty_curriculums")
    private List<Curriculum> curriculums = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "faculty", targetEntity = Department.class)
    @Column(name="faculty_departments")
    private List<Department> departments = new ArrayList<>();

    public Faculty(){}

    public Faculty(String facultyName, String facultyDescription, String facultyAdress) {
        this.facultyName = facultyName;
        this.facultyDescription = facultyDescription;
        this.facultyAdress = facultyAdress;
    }

    public Faculty(String facultyName, String facultyDescription, String facultyAdress, List<Curriculum> curriculums,
                   List<Department> departments) {
        this.facultyName = facultyName;
        this.facultyDescription = facultyDescription;
        this.facultyAdress = facultyAdress;
        this.curriculums = curriculums;
        this.departments = departments;
    }

    public Long getFacultyId() {
        return facultyId;
    }
    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }
    public String getFacultyName() {
        return facultyName;
    }
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
    public String getFacultyDescription() {
        return facultyDescription;
    }
    public void setFacultyDescription(String facultyDescription) {
        this.facultyDescription = facultyDescription;
    }
    public List<Curriculum> getCurriculums() {
        return curriculums;
    }
    public void setCurriculums(List<Curriculum> curriculums) {
        this.curriculums = curriculums;
    }
    public List<Department> getDepartments() {
        return departments;
    }
    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
    public String getFacultyAdress() {
        return facultyAdress;
    }
    public void setFacultyAdress(String facultyAdress) {
        this.facultyAdress = facultyAdress;
    }

    private String curriculumToString(){
        StringBuilder sb = new StringBuilder();
        for (Curriculum curriculum: curriculums) {
            sb.append(curriculum.getCurriculumCode()+ " " + curriculum.getCurriculumName() + "/n");
        }
        return sb.toString();
    }

    private String departmentsToString(){
        StringBuilder sb = new StringBuilder();
        for (Department dep: departments) {
            sb.append(dep.getDepartmentCode() + " " + dep.getDepartmentName() + "/n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Faculty{");
        sb.append("facultyId: ").append(facultyId);
        sb.append(", facultyName: '").append(facultyName).append('\'');
        sb.append(", facultyDescription: '").append(facultyDescription).append('\'');
        sb.append(", curriculums: ").append(curriculumToString());
        sb.append(", departments: ").append(departmentsToString());
        sb.append('}');
        return sb.toString();
    }
}
