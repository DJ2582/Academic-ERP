package com.ESD_project.esd_project.repository;

import com.ESD_project.esd_project.model.Student;
import com.ESD_project.esd_project.model.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCoursesRepository extends JpaRepository<StudentCourses,Integer> {
}
