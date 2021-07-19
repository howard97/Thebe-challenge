package com.example.webdeveloperchallenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Basic
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    @Basic
    @Column(name = "STUDENT_ID", nullable = false)
    private Long studentNumber;
    @Basic
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Basic
    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;
}
