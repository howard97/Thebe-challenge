package com.example.webdeveloperchallenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, precision = 0)
    private Long id;
    @Basic
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Basic
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    @Basic
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Basic
    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;
    @Basic
    @Column(name = "TUTOR_COURSE", nullable = false)
    private String tutorCourse;

}
