package com.ntu.api.domain.database.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buildings")
public class Building {

    @Id
    @Column(name = "building_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long buildingId;

    @Column(name = "building_name")
    private String buildingName;

    @Column(name = "building_description")
    private String buildingDescription;

    @Column(name = "building_adress")
    private String buildingAdress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building", targetEntity = ClassRoom.class)
    @Column(name = "building_classrooms")
    private List<ClassRoom> classRooms= new ArrayList<>();

    public Building(){}

    public Building(String buildingName, String buildingDescription, String buildingAdress) {
        this.buildingName = buildingName;
        this.buildingDescription = buildingDescription;
        this.buildingAdress = buildingAdress;
    }

    public Building(String buildingName, String buildingDescription, String buildingAdress, List<ClassRoom> classRooms) {
        this.buildingName = buildingName;
        this.buildingDescription = buildingDescription;
        this.buildingAdress = buildingAdress;
        this.classRooms = classRooms;
    }

    public Long getBuildingId() {
        return buildingId;
    }
    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }
    public String getBuildingName() {
        return buildingName;
    }
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
    public String getBuildingDescription() {
        return buildingDescription;
    }
    public void setBuildingDescription(String buildingDescription) {
        this.buildingDescription = buildingDescription;
    }
    public String getBuildingAdress() {
        return buildingAdress;
    }
    public void setBuildingAdress(String buildingAdress) {
        this.buildingAdress = buildingAdress;
    }
    public List<ClassRoom> getClassRooms() {
        return classRooms;
    }
    public void setClassRooms(List<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }

    private String classRoomsToString(){
        StringBuilder sb = new StringBuilder();
        for(ClassRoom classRoom: classRooms){
            sb.append(classRoom.getType() + " " + classRoom.getClassRoomName() + "/n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Building{");
        sb.append("departmentId=").append(buildingId);
        sb.append(", buildingName='").append(buildingName).append('\'');
        sb.append(", buildingDescription='").append(buildingDescription).append('\'');
        sb.append(", buildingAdress='").append(buildingAdress).append('\'');
        sb.append(", classRooms=").append(classRoomsToString());
        sb.append('}');
        return sb.toString();
    }
}
