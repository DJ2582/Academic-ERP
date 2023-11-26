package com.ESD_project.esd_project.controller;

import com.ESD_project.esd_project.model.Employee;
import com.ESD_project.esd_project.model.Login;
import com.ESD_project.esd_project.model.LoginMessage;
import com.ESD_project.esd_project.repository.FacultyRepository;
import com.ESD_project.esd_project.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @Autowired
    private FacultyRepository facultyRepository;

    @PostMapping("/register")
    public ResponseEntity<String> RegisterAdmin(@RequestBody Employee adminData) {
        facultyService.saveAdmin(adminData);
        return new ResponseEntity<>("Admin created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody Login login){
        LoginMessage loginMessage=facultyService.loginEmployee(login);
        return ResponseEntity.ok(loginMessage);
    }
}
