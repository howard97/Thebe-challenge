package com.example.webdeveloperchallenge.service;

import com.example.webdeveloperchallenge.commons.enums.Responses;
import com.example.webdeveloperchallenge.commons.exception.CustomsException;
import com.example.webdeveloperchallenge.commons.exception.ErrorCode;
import com.example.webdeveloperchallenge.dto.StudentDto;
import com.example.webdeveloperchallenge.interfaces.IStudentService;
import com.example.webdeveloperchallenge.model.Student;
import com.example.webdeveloperchallenge.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * method to Get All Students
     * @Author: Howard Sakala
     *
     */
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public ResponseEntity<Student> getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new CustomsException("STUDENT NOT FOUND WITH ID ", ErrorCode.ERR_602));
        return ResponseEntity.ok(student);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Map<String, Object> saveStudentData(StudentDto formDto) {
        Map<String,Object>response = new HashMap<>();
        if(getStudent(formDto.getEmail())){
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
            response.put( Responses.ResponseHeaderMessage, " is Already a member on the student populace!" );
            response.put( Responses.ResponseHeaderData, 507 );
            return response;
        }
        Student student = new Student();
        student.setStudentNumber(formDto.getStudentNumber());
        student.setEmail(formDto.getEmail());
        student.setFirstName(formDto.getFirstName());
        student.setPhoneNumber(formDto.getPhoneNumber());
        student.setLastName(formDto.getLastName());
        studentRepository.save(student);
        //Notify the user that the data has been saved
        response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusSuccess );
        response.put( Responses.ResponseHeaderMessage, formDto.getFirstName()+ " " + formDto.getLastName() + "Data has successfully been submitted!" );
        response.put( Responses.ResponseHeaderData, 1 );

        return response;
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new CustomsException("STUDENT NOT FOUND WITH ID ", ErrorCode.ERR_602));
    }

    public Boolean getStudent(String email){
        Student student = studentRepository.findByEmail(email);
        return student != null;
    }

}
