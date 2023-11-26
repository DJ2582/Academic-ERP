package com.ESD_project.esd_project.repository;

import com.ESD_project.esd_project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Optional<Student> findStudentByRollNumber(Integer Id);
}
