package com.ESD_project.esd_project.service;

import com.ESD_project.esd_project.model.Student;
import com.ESD_project.esd_project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByRollNumber(student.getRollNumber());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("student rollnumber taken");
        }
        studentRepository.save(student);
    }
}
