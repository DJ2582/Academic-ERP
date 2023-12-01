package com.ESD_project.esd_project.repository;

import com.ESD_project.esd_project.model.Student;
import com.ESD_project.esd_project.model.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCoursesRepository extends JpaRepository<StudentCourses,Integer> {
//    @Query("select cs.student.firstName,cs.student.lastName,cs.student.rollNumber from StudentCourses cs join cs.student s join cs.course c where cs.course.employee.employeeId=:employeeId")
@Query("select cs.student.firstName,cs.student.lastName,cs.student.rollNumber from StudentCourses cs join cs.student s join cs.course c where c.courseId=cs.course.courseId and cs.course.courseId=:employeeId")
    List<Object[]> findStudentsByEmployeeID(Integer employeeId);
}
