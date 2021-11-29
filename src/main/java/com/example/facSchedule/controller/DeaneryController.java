package com.example.facSchedule.controller;

import com.example.facSchedule.entity.*;
import com.example.facSchedule.exceptions.AlreadyExistException;
import com.example.facSchedule.exceptions.NotFoundException;
import com.example.facSchedule.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//TODO addProfessor
//TODO addStudent
//TODO create http query for call auto gen schedule
//TODO auto gen schedule (later)

@RestController
@RequestMapping("/deanery")
public class DeaneryController {

    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private ProfessorService professorService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectGroupService subjectGroupService;
    @Autowired
    private StudentService studentService;



    @PostMapping("/registerProfessor")
    public ResponseEntity registerProfessor(@RequestBody ProfessorEntity professor) {
        try {
            professorService.registration(professor);
            return ResponseEntity.ok("Professor created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/registerStudent")
    public ResponseEntity registerStudent(@RequestBody StudentEntity student , @RequestParam Long specialityId) {
        try {
            studentService.registration(student, specialityId);
            return ResponseEntity.ok("Student created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/addSpeciality")
    public ResponseEntity addSpeciality(@RequestBody SpecialityEntity speciality) {
        try {
            specialityService.addSpeciality(speciality);
            return ResponseEntity.ok("Speciality created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/addSubject/{idSpeciality}")
    public ResponseEntity addSubjectToSpeciality(@RequestBody SubjectEntity subject, @PathVariable Long idSpeciality) {
        try {
            subjectService.addSubject(subject, idSpeciality);
            return ResponseEntity.ok("Subject" + subject.getSubjectName() + " created in speciality with id " + idSpeciality);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    ///TODO test this
    @PostMapping("/addGroupToSubject")
    public ResponseEntity addGroupToSubject(@RequestBody SubjectGroupEntity subjectGroup, @RequestParam Long idSubject, @RequestParam Long idProfessor) {
        try {
            subjectGroupService.addGroupToSubject(subjectGroup, idSubject, idProfessor);
            return ResponseEntity.ok("Group: (" + subjectGroup.getGroupName() + ") for subject with id: (" + idSubject + ") created" );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getSpecialities")
    public ResponseEntity getSpecialities() {
        try {
            return ResponseEntity.ok(specialityService.getAllSpeciality());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
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
