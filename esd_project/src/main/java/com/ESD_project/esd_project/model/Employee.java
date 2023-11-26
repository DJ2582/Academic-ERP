package com.ESD_project.esd_project.model;
import jakarta.persistence.*;
@Entity
@Table
public class Employee {

    @Id
    private Integer employeeId;

    @Column(nullable = false)
    private String firstName;
    private String lastname;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(name="password",nullable = false)
    private String password;
    @Column
    private String title;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employee(Integer employeeId, String firstName, String lastname, String email, String title,String password) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.title = title;
        this.password= password;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
