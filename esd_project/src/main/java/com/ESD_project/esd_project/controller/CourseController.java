package com.ESD_project.esd_project.controller;

import com.ESD_project.esd_project.model.Course;
import com.ESD_project.esd_project.model.Employee;
import com.ESD_project.esd_project.service.CourseService;
import com.ESD_project.esd_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/course")
public class CourseController {
    private final CourseService courseService;
    private final EmployeeService employeeService;
    @Autowired
    public CourseController(CourseService courseService, EmployeeService employeeService) {
        this.courseService = courseService;
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Course> getCourse(){return courseService.getCourse();}

    @PostMapping
    public void  registerNewCourse(@RequestBody Course course){
        courseService.addNewCourse(course);
    }

    @GetMapping("/faculty/{EmployeeId}")
    public ResponseEntity<List<Course>> getCourseByEmployee(@PathVariable Integer EmployeeId){
        Optional<Employee> employee=employeeService.getEmployeeByID(EmployeeId);
        if(employee==null){
            return ResponseEntity.notFound().build();
        }
        List<Course> courses = courseService.getCoursesByEmployee(employee);
        return ResponseEntity.ok(courses);
    }



//    @Autowired
//    private CourseService courseService;
//    @GetMapping("/courses")
//    public String getCoursesForEmployee(Model model) {
//        Integer employeeId = 1; // Replace with the actual employee ID
//        List<Object[]> courseDetails = courseService.getCourseDetailsForEmployeeId(employeeId);
//        model.addAttribute("courseDetails", courseDetails);
//
//        return "courses"; // Thymeleaf template name
//    }
}
