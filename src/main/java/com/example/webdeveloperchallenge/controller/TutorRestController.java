package com.example.webdeveloperchallenge.controller;

import com.example.webdeveloperchallenge.commons.enums.Responses;
import com.example.webdeveloperchallenge.dto.TutorDto;
import com.example.webdeveloperchallenge.interfaces.ITutorService;
import com.example.webdeveloperchallenge.model.Tutor;
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
public class TutorRestController {
    private final ITutorService tutorService;
    private final Logger logger = LogManager.getLogger(TutorRestController.class);

    @Autowired
    public TutorRestController(ITutorService tutorService) {
        this.tutorService = tutorService;
    }

    /**
     * method to endpoint to get all tutors
     * @Author: Howard Sakala
     *
     */
    @GetMapping("/tutors")
    public ResponseEntity<List<Tutor>> getAllTutors(){
        List<Tutor> tutorList = tutorService.findAllTutors();
        return ResponseEntity.ok(tutorList);
    }

    @GetMapping("/tutors/{id}")
    public ResponseEntity<Tutor>getTutorById(@PathVariable Long id){
        return tutorService.getTutorById(id);
    }

    /**
     * method to end point to create tutor
     * @Author: Howard Sakala
     *
     */
    @PostMapping("/tutors")
    public Map<String, Object> createTutor(@Valid @RequestBody TutorDto formDto, BindingResult result)throws Exception{
        Map<String,Object>response = new HashMap<>();
        if (result.hasErrors()) {
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
            response.put( Responses.ResponseHeaderMessage, "Enter all inputs in a correct format." );
            response.put( Responses.ResponseHeaderData, 500 );
            response.put( "payload", result.getAllErrors() );
            return response;
        }
        try{
            response = tutorService.saveTutorData(formDto);
        }catch (Exception e){
         logger.error(ExceptionUtils.getStackTrace(e));
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
            response.put( Responses.ResponseHeaderMessage, "Error Submitting Tutor Data!" );
            response.put( Responses.ResponseHeaderData, 500);
        }
        return response;
    }
}
