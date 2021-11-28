package com.example.facSchedule.controller;

import com.example.facSchedule.entity.SpecialityEntity;
import com.example.facSchedule.entity.SubjectEntity;
import com.example.facSchedule.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class DeaneryController {

    @Autowired
    private DeaneryService deaneryService;
    private SpecialityService specialityService;
    private ProfessorService professorService;
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity addSpeciality(@RequestBody SpecialityEntity speciality) {
        try {
            specialityService.addSpeciality(speciality);
            return ResponseEntity.ok("Speciality created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошol trulling" + e);
        }
    }

    @PostMapping
    public ResponseEntity addSubjectToSpeciality(@RequestBody SubjectEntity subject, @RequestParam Long idSpeciality) {
        try {
            subjectService.addSubject(subject, idSpeciality);
            return ResponseEntity.ok("Subject" + subject.getSubjectName() + " created in speciality with id " + idSpeciality);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошol trulling" + e);
        }
    }

/*
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam String login) {
        try {
            return ResponseEntity.ok(studentService.getOne(login));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }*/
}
