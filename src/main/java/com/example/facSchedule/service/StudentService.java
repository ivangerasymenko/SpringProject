package com.example.facSchedule.service;

import com.example.facSchedule.entity.StudentEntity;
import com.example.facSchedule.exceptions.UserAlreadyExistException;
import com.example.facSchedule.exceptions.UserNotFoundException;
import com.example.facSchedule.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public StudentEntity registration (StudentEntity student) throws UserAlreadyExistException {
        if (studentRepo.findByLogin(student.getLogin()) != null) {
            throw new UserAlreadyExistException("Користувач з таким логіном вже існує");
        }
        return studentRepo.save(student);
    }

    public StudentEntity getOne(String login) throws UserNotFoundException {
        StudentEntity student = studentRepo.findByLogin(login);
        if (student == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return student;
    }


    public Long delete(Long id) {
        studentRepo.deleteById(id);
        return id;
    }
}
