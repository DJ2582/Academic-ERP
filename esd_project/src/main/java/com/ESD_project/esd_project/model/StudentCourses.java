package com.ESD_project.esd_project.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table
@EqualsAndHashCode
@ToString
public class StudentCourses {


    @Id
    private Integer studentCoursesId;

    @ManyToOne
    @JoinColumn(name = "studentID",nullable = false)
    private Student student;
    @OneToOne
    @JoinColumn(name = "courseId",nullable = false)
    private Course course;

    public StudentCourses() {
    }

    public StudentCourses(Integer studentCoursesId, Student student, Course course) {
        this.studentCoursesId = studentCoursesId;
        this.student = student;
        this.course = course;
    }
    public Integer getStudentCoursesId() {
        return studentCoursesId;
    }

    public void setStudentCoursesId(Integer studentCoursesId) {
        this.studentCoursesId = studentCoursesId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }



}
