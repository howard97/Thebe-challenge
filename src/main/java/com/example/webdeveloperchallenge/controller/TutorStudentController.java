package com.example.webdeveloperchallenge.controller;

import com.example.webdeveloperchallenge.interfaces.IStudentService;
import com.example.webdeveloperchallenge.interfaces.ITutorService;
import com.example.webdeveloperchallenge.interfaces.ITutorStudentService;
import com.example.webdeveloperchallenge.model.TutorStudents;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TutorStudentController {
    private final ITutorService tutorService;
    private final IStudentService studentService;
    private final ITutorStudentService tutorStudentService;
    private final Logger logger = LogManager.getLogger(TutorStudentController.class);

    @Autowired
    public TutorStudentController(ITutorService tutorService, IStudentService studentService, ITutorStudentService tutorStudentService) {
        this.tutorService = tutorService;
        this.studentService = studentService;
        this.tutorStudentService = tutorStudentService;
    }

    @GetMapping("assignTutorToStudent/{studentId}")
    @ResponseBody
    public ModelAndView assignTutorToStudent(@PathVariable String studentId, @RequestParam String tutorId)throws Exception{
        Long studentId1 = Long.parseLong(studentId);
        Long tutorId1 = Long.parseLong(tutorId);
        ModelAndView view = new ModelAndView("studentManagement/studentProfile");
        TutorStudents student = tutorStudentService.assignTutorToStudent(studentId1, tutorId1);
        if(student == null){
            return view;
        }
       view.addObject("message","Tutor Assigned successfully");
        return view;
    }


}
