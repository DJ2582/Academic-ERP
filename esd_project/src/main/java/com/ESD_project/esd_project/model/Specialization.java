package com.ESD_project.esd_project.model;

import jakarta.persistence.*;
import java.time.Year;
@Entity
@Table
public class Specialization {
    @Id
    private Integer specializationID;
    @Column(nullable = false,unique = true)
    private Integer code;

    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private Year year;
    @Column(nullable = false)
    private Integer creditsRequired;

    public Specialization(Integer specializationID, Integer code, String name, String description, Year year, Integer creditsRequired) {
        this.specializationID = specializationID;
        this.code = code;
        this.name = name;
        this.description = description;
        this.year = year;
        this.creditsRequired = creditsRequired;
    }

    public Specialization(Integer code, String name, String description, Year year, Integer creditsRequired) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.year = year;
        this.creditsRequired = creditsRequired;
    }

    public Specialization() {
    }

    public Integer getSpecializationID() {
        return specializationID;
    }

    public void setSpecializationID(Integer specializationID) {
        this.specializationID = specializationID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    public Integer getCreditsRequired() {
        return creditsRequired;
    }

    public void setCreditsRequired(Integer creditsRequired) {
        this.creditsRequired = creditsRequired;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "specializationID=" + specializationID +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", creditsRequired=" + creditsRequired +
                '}';
    }

}
