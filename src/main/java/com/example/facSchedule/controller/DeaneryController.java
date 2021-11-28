package com.example.facSchedule.controller;

import com.example.facSchedule.entity.DeaneryEntity;
import com.example.facSchedule.entity.SpecialityEntity;
import com.example.facSchedule.entity.SubjectEntity;
import com.example.facSchedule.exceptions.AlreadyExistException;
import com.example.facSchedule.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deanery")
public class DeaneryController {

    @Autowired
    private DeaneryService deaneryService;
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private ProfessorService professorService;
    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity  registration(@RequestBody DeaneryEntity deanery) {
        try {
            deaneryService.registration(deanery);
            return ResponseEntity.ok("Deanery created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошol trulling" + e);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity addSpeciality(@RequestBody SpecialityEntity speciality, @PathVariable Long id) {
        try {
            specialityService.addSpeciality(speciality,id);
            return ResponseEntity.ok("Speciality created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/addSubject/{idSpeciality}")
    public ResponseEntity addSubjectToSpeciality(@RequestBody SubjectEntity subject, @PathVariable Long idSpeciality) {
        try {
            subjectService.addSubject(subject, idSpeciality);
            return ResponseEntity.ok("Subject" + subject.getSubjectName() + " created in speciality with id " + idSpeciality);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошol trulling" + e);
        }
    }


    @GetMapping
    public ResponseEntity getAllSpecialities(@RequestParam Long deaneryId) throws AlreadyExistException {
        return (ResponseEntity) deaneryService.getAllSpeciality(deaneryId);
    }

/*
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }*/
}
