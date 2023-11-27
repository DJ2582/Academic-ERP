package com.ESD_project.esd_project.repository;

import com.ESD_project.esd_project.model.Course;
import com.ESD_project.esd_project.model.Employee;
//import com.ESD_project.esd_project.service.CourseRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {                                    //CourseRepositoryCustom pass after JpaRepo
    List<Course> findCourseByEmployee(@Param("employee")Optional<Employee> employee);

}
