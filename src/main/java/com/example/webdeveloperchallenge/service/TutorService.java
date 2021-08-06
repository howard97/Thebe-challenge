package com.example.webdeveloperchallenge.service;

import com.example.webdeveloperchallenge.commons.enums.Responses;
import com.example.webdeveloperchallenge.commons.exception.CustomsException;
import com.example.webdeveloperchallenge.commons.exception.ErrorCode;
import com.example.webdeveloperchallenge.dto.TutorDto;
import com.example.webdeveloperchallenge.interfaces.ITutorService;
import com.example.webdeveloperchallenge.model.Student;
import com.example.webdeveloperchallenge.model.Tutor;
import com.example.webdeveloperchallenge.repository.StudentRepository;
import com.example.webdeveloperchallenge.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TutorService implements ITutorService {
    private final TutorRepository tutorRepository;
   private final StudentRepository studentRepository;

    @Autowired
    public TutorService(TutorRepository tutorRepository, StudentRepository studentRepository) {
        this.tutorRepository = tutorRepository;
        this.studentRepository = studentRepository;
    }

    /**
     * method to find all tutors
     * @Author: Howard Sakala
     *
     */
    @Override
    public List<Tutor> findAllTutors() {
        return tutorRepository.findAll();
    }

    /**
     * method to save Tutor data
     * @Author: Howard Sakala
     *
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Map<String, Object> saveTutorData(TutorDto formDto)throws Exception {
        Map<String, Object> response = new HashMap<>();
        if(checkTutor(formDto.getEmail())){
            response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusError );
            response.put( Responses.ResponseHeaderMessage, formDto.getFirstName() + " " + formDto.getLastName() + " is Already a member on the system!" );
            response.put( Responses.ResponseHeaderData, 507 );
            return response;
        }


        Tutor tutor = new Tutor();
        tutor.setEmail(formDto.getEmail());
        tutor.setFirstName(formDto.getFirstName());
        tutor.setLastName(formDto.getLastName());
        tutor.setTutorCourse(formDto.getTutorCourse());
        tutor.setPhoneNumber(formDto.getPhoneNumber());

        tutorRepository.save(tutor);
        //Notify the user that the data has been saved
        response.put( Responses.ResponseHeaderStatus, Responses.ResponseStatusSuccess );
        response.put( Responses.ResponseHeaderMessage, formDto.getFirstName()+ " " + formDto.getLastName() + " Data has successfully been submitted!" );
        response.put( Responses.ResponseHeaderData, 1 );

        return response;
    }

    @Override
    public ResponseEntity<Tutor> getTutorById(Long id) {
        Tutor tutor = tutorRepository.findById(id).orElseThrow(()-> new CustomsException("STUDENT NOT FOUND WITH ID ", ErrorCode.ERR_602));;
        return ResponseEntity.ok(tutor);
    }

    @Override
    public Tutor getTutor(Long tutor) {
        return tutorRepository.getById(tutor);
    }


    /**
     * method to check if tutor already exists
     * @Author: Howard Sakala
     *
     */
    public Boolean checkTutor(String email){
        Tutor tutor = tutorRepository.findByEmail(email);
        return tutor != null;
    }
}
