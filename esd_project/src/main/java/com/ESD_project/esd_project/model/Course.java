package com.ESD_project.esd_project.model;

import com.ESD_project.esd_project.model.Employee;
import jakarta.persistence.*;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Year;


@Entity
@Table
public class Course {
    @Id
    @SequenceGenerator(name = "course_sequence",sequenceName = "course_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_sequence")
    private Integer courseId;

    @ManyToOne
    @JoinColumn(name = "employeeID",nullable = false)
    private Employee employee;

//    @OneToOne
//    private SpecializationCourse specializationCourse;

    @Column(nullable = false,unique = true)
    private Integer courseCode;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Year year;
    @Column(nullable = false)
    private Integer term;
    @Column(nullable = false)
    private Integer credits;
    @Column(nullable = false)
    private Integer capacity;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Course(Integer courseId, Employee employee, Integer courseCode, String name, String description, Year year, Integer term, Integer credits, Integer capacity) {
        this.courseId = courseId;
        this.employee = employee;
        this.courseCode = courseCode;
        this.name = name;
        this.description = description;
        this.year = year;
        this.term = term;
        this.credits = credits;
        this.capacity = capacity;
    }

    public Course(Employee employee, Integer courseCode, String name, String description, Year year, Integer term, Integer credits, Integer capacity) {
        this.employee = employee;
        this.courseCode = courseCode;
        this.name = name;
        this.description = description;
        this.year = year;
        this.term = term;
        this.credits = credits;
        this.capacity = capacity;
    }

    public Course() {
    }
}
