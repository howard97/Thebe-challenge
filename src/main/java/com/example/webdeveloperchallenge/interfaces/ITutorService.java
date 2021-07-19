package com.example.webdeveloperchallenge.interfaces;

import com.example.webdeveloperchallenge.dto.TutorDto;
import com.example.webdeveloperchallenge.model.Tutor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITutorService {
    List<Tutor> findAllTutors();
    Map<String, Object> saveTutorData(TutorDto formDto) throws Exception;
    ResponseEntity<Tutor> getTutorById(Long id);
}
