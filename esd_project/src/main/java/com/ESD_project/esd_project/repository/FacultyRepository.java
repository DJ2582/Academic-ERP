package com.ESD_project.esd_project.repository;

import com.ESD_project.esd_project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Employee,Integer> {
    Employee findByEmail(String email);
    Optional<Employee> findOneByEmailAndPassword(String email, String password);
}
