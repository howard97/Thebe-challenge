package com.example.webdeveloperchallenge.controller;

import com.example.webdeveloperchallenge.interfaces.ITutorStudentService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TutorStudentController {
    private final ITutorStudentService tutorStudentService;
    private Logger logger = LogManager.getLogger(TutorStudentController.class);

    @Autowired
    public TutorStudentController(ITutorStudentService tutorStudentService) {
        this.tutorStudentService = tutorStudentService;
    }

    @PostMapping("assignTutorToStudent/{id}")
    public Map<String,Object> assignTutorToStudent(@PathVariable String id)throws Exception{
        Map<String,Object>response = new HashMap<>();
        try{
            response = tutorStudentService.assignTutorToStudent(id);
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return response;
    }


}
