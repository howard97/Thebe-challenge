package com.example.webdeveloperchallenge.controller;

import com.example.webdeveloperchallenge.interfaces.IStudentService;
import com.example.webdeveloperchallenge.model.Student;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentWebController {
    private final IStudentService studentService;
    private Logger logger = LogManager.getLogger(StudentWebController.class);

    @Autowired
    public StudentWebController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/studentApplication")
    public String displayStudent(){
        return "/studentManagement/studentApplication";
    }

    @GetMapping("/listOfStudents")
    public String displayListOfStudents(){
        return "studentManagement/listOfStudents";
    }


    /*@GetMapping("/studentProfile/{id}")
    public ModelAndView displayStudentProfile(@PathVariable Long id){
        ModelAndView view = new ModelAndView("studentManagement/studentProfile");
        try{
            Student student = studentService.getStudent(id);
            view.addObject("student", student);
        }catch (Exception e){
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return view;
    }*/
    @GetMapping("/studentProfile/{id}")
    public String dispay(@PathVariable Long id, Model model){
        Student student = studentService.getStudent(id);
        model.addAttribute("student",student);
        return "studentManagement/studentProfile";
    }
}
