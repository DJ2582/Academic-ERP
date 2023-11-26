package com.ESD_project.esd_project.controller;

import com.ESD_project.esd_project.model.Specialization;
import com.ESD_project.esd_project.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="/specialization")
public class SpecializationController {
    public SpecializationService specializationService;

    @Autowired
    public SpecializationController(SpecializationService specializationService){
        this.specializationService=specializationService;
    }
    @GetMapping
    public List<Specialization> getSpecialisation(){return  specializationService.getSpecialization();}

    @PostMapping
    public void postSpecialisation(@RequestBody Specialization specialisation){ specializationService.addNewSpecialisation(specialisation);}
}
