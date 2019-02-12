package com.ntu.api.domain.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "group")
public class Group {

    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;

    @Column(name = "groupCode")
    private String groupCode;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_description")
    private String groupDescription;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Course.class)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Group(){}

    public Group(String groupCode, String groupName, String groupDescription, Course course) {
        this.groupCode = groupCode;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.course = course;
    }

    public Long getGroupId() {
        return groupId;
    }
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    public String getGroupCode() {
        return groupCode;
    }
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getGroupDescription() {
        return groupDescription;
    }
    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Group{");
        sb.append("groupId=").append(groupId);
        sb.append(", groupCode='").append(groupCode).append('\'');
        sb.append(", groupName='").append(groupName).append('\'');
        sb.append(", groupDescription='").append(groupDescription).append('\'');
        sb.append(", course=").append(course.getCourseName());
        sb.append('}');
        return sb.toString();
    }
}
