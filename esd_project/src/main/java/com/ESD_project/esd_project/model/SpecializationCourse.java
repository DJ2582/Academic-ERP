package com.ESD_project.esd_project.model;

import jakarta.persistence.*;
import com.ESD_project.esd_project.model.Course;
import lombok.Data;

@Entity
@Table
public class SpecializationCourse {

    @Id
    private Integer specializationCoursesID;

    public SpecializationCourse() {
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coursecourseCode",nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name ="specializationID",nullable = false)
    private Specialization specialization;

    public SpecializationCourse(Integer specializationCoursesID) {
        this.specializationCoursesID = specializationCoursesID;
    }

    public Integer getSpecializationCoursesID() {
        return specializationCoursesID;
    }

    public void setSpecializationCoursesID(Integer specializationCoursesID) {
        this.specializationCoursesID = specializationCoursesID;
    }

    @Override
    public String toString() {
        return "SpecializationCourse{" +
                "specializationCoursesID=" + specializationCoursesID +
                '}';
    }
}
