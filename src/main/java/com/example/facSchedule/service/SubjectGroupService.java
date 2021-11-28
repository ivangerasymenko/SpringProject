package com.example.facSchedule.service;

import com.example.facSchedule.repository.SubjectGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectGroupService {


/*@Autowired
    private SubjectGroupRepo studentRepo;
    public StudentEntity add(StudentEntity student) throws UserAlreadyExistException {
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
    }*/
}
