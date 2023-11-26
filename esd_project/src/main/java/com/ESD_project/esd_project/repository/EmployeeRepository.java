package com.ESD_project.esd_project.repository;

import com.ESD_project.esd_project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EmployeeRepository extends JpaRepository<Employee,Integer> {
}
