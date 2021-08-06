package com.example.webdeveloperchallenge.controller;

import com.example.webdeveloperchallenge.interfaces.IStudentService;
import com.example.webdeveloperchallenge.interfaces.ITutorService;
import com.example.webdeveloperchallenge.model.Student;
import com.example.webdeveloperchallenge.model.Tutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TutorStudentWebController {
    private final IStudentService studentService;
    private final ITutorService tutorService;

    public TutorStudentWebController(IStudentService studentService, ITutorService tutorService) {
        this.studentService = studentService;
        this.tutorService = tutorService;
    }

    @GetMapping("/displayTutorStudent")
    public ModelAndView displayTutorStudent(){
        ModelAndView view = new ModelAndView("tutorManagement/tutorStudentList");
        List<Student> students = studentService.getAllStudent();
        if(students.size() == 0){
            return view;
        }
        List<Tutor> tutorList = tutorService.findAllTutors();
        if(tutorList.size()==0){
            return view;
        }
        view.addObject("students", students);
        view.addObject("tutorList",tutorList );
        return view;
    }
}
