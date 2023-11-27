package com.ESD_project.esd_project.repository;

import com.ESD_project.esd_project.model.CourseSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseScheduleRepository extends JpaRepository<CourseSchedule,Integer>,CrudRepository<CourseSchedule,Integer>{
//    @Query("select cs.Room,c.name,emp.firstName from CourseSchedule cs join cs.course c join cs.course.employee emp where cs.course.employee.employeeId=:input")
//    @Query("select c.name,sc.specialization.name from SpecializationCourse sc join sc.specialization s join sc.course c")
    @Query("select c.name as CourseName,cs.time,cs.Room,cs.day,sp.specialization.name,c.courseId from Course c join c.employee e join CourseSchedule cs on cs.course.courseId=c.courseId join SpecializationCourse sp on sp.course.courseId=c.courseId where e.employeeId=:input")
    List<Object[]> getCourseName(Integer input);
}
