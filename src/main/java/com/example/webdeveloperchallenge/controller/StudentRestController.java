package com.example.webdeveloperchallenge.controller;

import com.example.webdeveloperchallenge.commons.enums.Responses;
import com.example.webdeveloperchallenge.dto.StudentDto;
import com.example.webdeveloperchallenge.interfaces.IStudentService;
import com.example.webdeveloperchallenge.model.Student;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class StudentRestController {
    private final IStudentService studentService;
    private final Logger logger = LogManager.getLogger(StudentRestController.class);

    @Autowired
    public StudentRestController(IStudentService studentService) {
        this.studentService = studentService;
    }


    /**
     * method to create students
     * @Author: Howard Sakala
     *
     */
    @PostMapping("/students")
    public Map<String, Object> createStudent(@Valid @RequestBody StudentDto formDto, BindingResult result){
        Map<String,Object>response = new HashMap<>();
        if (result.hasErrors()) {
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
            response.put( Responses.ResponseHeaderMessage, "Enter all inputs in a correct format." );
            response.put( Responses.ResponseHeaderData, 500 );
            response.put( "payload", result.getAllErrors() );
            return response;
        }
        try{
            response = studentService.saveStudentData(formDto);
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
            response.put( Responses.ResponseHeaderMessage, "Error Submitting Student Data!" );
            response.put( Responses.ResponseHeaderData, 500);
        }
        return response;
    }

    /**
     * method to Get All Students
     * @Author: Howard Sakala
     *
     */
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList = studentService.getAllStudent();
        return ResponseEntity.ok(studentList);
    }

    /**
     * method to Get a Student by id
     * @Author: Howard Sakala
     *
     */
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
        Long studentId = Long.parseLong(id);
     return studentService.getStudentById(studentId);
    }

}
