package com.example.webdeveloperchallenge.interfaces;

import com.example.webdeveloperchallenge.dto.StudentDto;
import com.example.webdeveloperchallenge.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    List<Student> getAllStudent();
    ResponseEntity<Student> getStudentById(Long id);
    Map<String, Object> saveStudentData(StudentDto formDto) throws Exception;
    Student getStudent(Long id);
}
