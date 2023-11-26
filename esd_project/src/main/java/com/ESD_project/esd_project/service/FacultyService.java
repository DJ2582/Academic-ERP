package com.ESD_project.esd_project.service;

import com.ESD_project.esd_project.model.Employee;
import com.ESD_project.esd_project.model.Login;
import com.ESD_project.esd_project.model.LoginMessage;
import com.ESD_project.esd_project.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginMessage loginEmployee(Login login) {
        String msg="";
        Employee adminFromRequest = adminRepository.findByEmail(login.getEmail());
        if(adminFromRequest!=null){
            String passwordFromRequest=login.getPassword();
            String passwordFromAdmin=adminFromRequest.getPassword();
            Boolean isPwdRight=passwordEncoder.matches(passwordFromRequest,passwordFromAdmin);
            if(isPwdRight){
                Optional<Employee> admin=adminRepository.findOneByEmailAndPassword(login.getEmail(),passwordFromAdmin);
                if(admin.isPresent()){
                    return new LoginMessage("Login Success",true);
                }
                else{
                    return new LoginMessage("Login failed",false);
                }
            }
            else {
                return new LoginMessage("Password not match", false);
            }
        }
        else{
            return new LoginMessage("Email not exits",false);
        }
    }
    public void saveAdmin(Employee adminData) {
        String encodedPassword=this.passwordEncoder.encode(adminData.getPassword());
        adminData.setPassword((encodedPassword));
        adminRepository.save(adminData);
    }
}
