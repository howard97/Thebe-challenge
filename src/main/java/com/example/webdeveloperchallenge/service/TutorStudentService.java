package com.example.webdeveloperchallenge.service;

import com.example.webdeveloperchallenge.interfaces.ITutorStudentService;
import com.example.webdeveloperchallenge.model.TutorStudents;
import com.example.webdeveloperchallenge.repository.TutorStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class TutorStudentService implements ITutorStudentService {

    private final TutorStudentRepository tutorStudentRepository;

    public TutorStudentService(TutorStudentRepository tutorStudentRepository) {
        this.tutorStudentRepository = tutorStudentRepository;
    }

    @Override
    public TutorStudents assignTutorToStudent(Long studentId, Long tutorId) {
        TutorStudents students = new TutorStudents();
        students.setStudentId(studentId);
        students.setTutor(tutorId);
        TutorStudents tutorStudents = tutorStudentRepository.save(students);
        return tutorStudents;
    }
}
