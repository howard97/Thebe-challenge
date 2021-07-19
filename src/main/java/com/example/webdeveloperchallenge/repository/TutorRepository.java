package com.example.webdeveloperchallenge.repository;

import com.example.webdeveloperchallenge.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor,Long> {
    Tutor findByEmail(String email);
}
