package com.example.facSchedule.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/students")
public class StudentControllers {


        @GetMapping("/shedukl")
        public ResponseEntity getStudents() {
            try {
                return ResponseEntity.ok("Server Workait");
            }catch (Exception e){
                return ResponseEntity.badRequest().body("Oshybka");
            }
        }
}
