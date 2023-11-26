package com.ESD_project.esd_project.service;

import com.ESD_project.esd_project.model.Specialization;
import com.ESD_project.esd_project.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {
    @Autowired
    private final SpecializationRepository specializationRepository;

    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }
    public List<Specialization> getSpecialization(){
        return specializationRepository.findAll();
    }
    public void addNewSpecialisation(Specialization specialization){

        specializationRepository.save(specialization);
    }
}
