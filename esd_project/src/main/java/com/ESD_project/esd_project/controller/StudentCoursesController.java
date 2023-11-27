package com.ESD_project.esd_project.controller;

import com.ESD_project.esd_project.model.StudentCourses;
import com.ESD_project.esd_project.service.StudentCoursesServices;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path="/studentcourses")
public class StudentCoursesController {
    @Autowired
    public final StudentCoursesServices studentCoursesServices;

    public StudentCoursesController(StudentCoursesServices studentCoursesServices) {
        this.studentCoursesServices = studentCoursesServices;
    }
    @GetMapping
    public List<StudentCourses> getStudentCourse(){
        return studentCoursesServices.getStudentCourse();
    }

    @GetMapping(path="/all/{employeeId}")
    public ResponseEntity<List<Object[]>> query2(@PathVariable Integer employeeId){
        return new ResponseEntity<>(studentCoursesServices.findStudents(employeeId), HttpStatus.OK);
    }
}
