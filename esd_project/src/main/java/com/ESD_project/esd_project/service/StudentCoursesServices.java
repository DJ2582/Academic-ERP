package com.ESD_project.esd_project.service;

import com.ESD_project.esd_project.model.StudentCourses;
import com.ESD_project.esd_project.repository.StudentCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCoursesServices {
    @Autowired
    private StudentCoursesRepository studentCoursesRepository;

    public StudentCoursesServices(StudentCoursesRepository studentCoursesRepository) {
        this.studentCoursesRepository = studentCoursesRepository;
    }
    public List<StudentCourses> getStudentCourse(){
        return studentCoursesRepository.findAll();
    }
    public void addNewStudentCourse(StudentCourses studentCourses){
        studentCoursesRepository.save(studentCourses);
    }

    public List<Object[]> findStudents(Integer employeeId) {
        return studentCoursesRepository.findStudentsByEmployeeID(employeeId);
    }
}
