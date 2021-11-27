package com.example.facSchedule.controller;

import com.example.facSchedule.entity.StudentEntity;
import com.example.facSchedule.exceptions.UserAlreadyExistException;
import com.example.facSchedule.exceptions.UserNotFoundException;
import com.example.facSchedule.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/students")
public class StudentControllers {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity registration(@RequestBody StudentEntity student) {
        try {
            studentService.registration(student);
            return ResponseEntity.ok("Student created");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка" + e);
        }
    }


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
    }
}
