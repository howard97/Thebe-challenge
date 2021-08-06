package com.example.webdeveloperchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String studentNumber;
    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;
}
