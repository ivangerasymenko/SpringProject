package com.example.facSchedule.controller;

import com.example.facSchedule.exceptions.NotFoundException;
import com.example.facSchedule.service.PickedGroupService;
import com.example.facSchedule.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

//TODO pick subject
//TODO pick group
//TODO check schedule

@RestController
@RequestMapping("/student")
public class StudentControllers {

    @Autowired
    private StudentService studentService;
    @Autowired
    private PickedGroupService pickedGroupService;

    @PostMapping("/enrollMe/{idStudent}")
    public ResponseEntity registration(@PathVariable Long idStudent, @RequestParam Long idGroup) {
        try {
            pickedGroupService.studentEnrollsGroup(idStudent, idGroup);
            return ResponseEntity.ok("Student enrolled!");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка" + e);
        }
    }

    @GetMapping("getStudent/{login}")
    public ResponseEntity getOneUser(@PathVariable String login) {
        try {
            return ResponseEntity.ok(studentService.getOne(login));
        } catch (NotFoundException e) {
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
    }
}
