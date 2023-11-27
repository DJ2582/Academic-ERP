package com.ESD_project.esd_project.controller;

import com.ESD_project.esd_project.model.CourseSchedule;
import com.ESD_project.esd_project.service.CourseScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping(path="/courseschedule")
public class CourseScheduleController {
    private final CourseScheduleService courseScheduleService;
    @Autowired
    public CourseScheduleController(CourseScheduleService courseScheduleService) {
        this.courseScheduleService = courseScheduleService;
    }
    @GetMapping
    public List<CourseSchedule> getCourse(){return courseScheduleService.getCourse();}
    @PostMapping
    public  void registerNewCourseSchedule(@RequestBody CourseSchedule courseSchedule){
        courseScheduleService.addNewCourseSchedule(courseSchedule);
    }

    @GetMapping(path="/course/{input}")
    public List<Object[]> questionone(@PathVariable Integer input){return courseScheduleService.getCourseName(input);}
}
