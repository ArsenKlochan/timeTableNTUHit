package com.ntu.api.domain.database.entity;

import com.ntu.api.domain.database.entity.enums.ClassRoomTypes;

import javax.persistence.*;

@Entity
@Table(name = "classRooms")
public class ClassRoom {

    @Id
    @Column(name = "classrooms_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long classRoomsId;

    @Column(name = "classrooms_name")
    private String classRoomName;

    @Column(name = "classroom_description")
    private String classRoomDescription;

    @Column(name = "Type")
    @Enumerated(EnumType.ORDINAL)
    private ClassRoomTypes type;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Building.class)
    @JoinColumn(name = "building", nullable = false)
    private Building building;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Department.class)
    @JoinColumn(name = "department", nullable = false)
    private Department department;

    public ClassRoom(){}

    public ClassRoom(String classRoomName, String classRoomDescription, ClassRoomTypes type, Building building, Department department) {
        this.classRoomName = classRoomName;
        this.classRoomDescription = classRoomDescription;
        this.type = type;
        this.building = building;
        this.department = department;
    }

    public Long getClassRoomsId() {
        return classRoomsId;
    }
    public void setClassRoomsId(Long classRoomsId) {
        this.classRoomsId = classRoomsId;
    }
    public String getClassRoomName() {
        return classRoomName;
    }
    public void setClassRoomName(String classRoomsName) {
        this.classRoomName = classRoomsName;
    }
    public String getClassRoomDescription() {
        return classRoomDescription;
    }
    public void setClassRoomDescription(String classRoomDescription) {
        this.classRoomDescription = classRoomDescription;
    }
    public ClassRoomTypes getType() {
        return type;
    }
    public void setType(ClassRoomTypes type) {
        this.type = type;
    }
    public Building getBuilding() {
        return building;
    }
    public void setBuilding(Building building) {
        this.building = building;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClassRoom{");
        sb.append("classRoomsId=").append(classRoomsId);
        sb.append(", classRoomsName='").append(classRoomName).append('\'');
        sb.append(", classRoomDescription='").append(classRoomDescription).append('\'');
        sb.append(", type=").append(type);
        sb.append(", building=").append(building);
        sb.append('}');
        return sb.toString();
    }
}
