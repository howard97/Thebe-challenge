package com.example.webdeveloperchallenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TutorWebController {
    @GetMapping("/tutorApplication")
    public String displayTutor(){
        return "tutorManagement/tutorApplication";
    }

    @GetMapping("/listOfTutors")
    public String displayListOfTutors(){
        return "tutorManagement/listOfTutors";
    }
}
