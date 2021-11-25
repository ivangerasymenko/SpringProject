package com.example.facSchedule.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class StudentControllers {



    @RestController
    @RequestMapping("/Students")
    public class StudentController {

        @GetMapping("")
        public ResponseEntity getStudents() {
            try {
                return ResponseEntity.ok("Server Workait");
            }catch (Exception e){
                return ResponseEntity.badRequest().body("Oshybka");
            }
        }

    }
}
