package com.ESD_project.esd_project.repository;

import com.ESD_project.esd_project.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization,Integer> {
    //Optional<Specialization> findSpecializationByCode(Integer code);
}
