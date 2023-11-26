package com.ESD_project.esd_project.service;

import com.ESD_project.esd_project.model.Course;
import com.ESD_project.esd_project.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.ESD_project.esd_project.model.Employee;
import com.ESD_project.esd_project.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    public final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public List<Course> getCourse(){return  courseRepository.findAll();}
    public void addCourse(Course course){
        courseRepository.save(course);
    }


    public void addNewCourse(Course course) {
        courseRepository.save(course);
    }

    public List<Course> getCoursesByEmployee(Optional<Employee> employee) {
        return courseRepository.findCourseByEmployee(employee);
    }
}
