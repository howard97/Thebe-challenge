package com.example.webdeveloperchallenge.interfaces;

import com.example.webdeveloperchallenge.model.TutorStudents;

public interface ITutorStudentService {
    TutorStudents assignTutorToStudent(Long studentId, Long tutorId);
}
