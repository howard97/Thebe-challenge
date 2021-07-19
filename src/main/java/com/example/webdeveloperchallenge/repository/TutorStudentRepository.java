package com.example.webdeveloperchallenge.repository;

import com.example.webdeveloperchallenge.model.TutorStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorStudentRepository extends JpaRepository<TutorStudents,Long> {
}
