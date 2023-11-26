package com.ESD_project.esd_project.service;

import com.ESD_project.esd_project.model.CourseSchedule;
import com.ESD_project.esd_project.repository.CourseScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseScheduleService {
    @Autowired
    public final CourseScheduleRepository courseScheduleRepository;

    public CourseScheduleService(CourseScheduleRepository courseScheduleRepository) {
        this.courseScheduleRepository = courseScheduleRepository;
    }
    public List<CourseSchedule> getCourse(){
        return courseScheduleRepository.findAll();
    }
    public void addNewCourseSchedule(CourseSchedule courseSchedule){
        courseScheduleRepository.save(courseSchedule);
    }
}
