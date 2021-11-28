package com.example.facSchedule.service;

import com.example.facSchedule.entity.SpecialityEntity;
import com.example.facSchedule.entity.StudentEntity;
import com.example.facSchedule.exceptions.AlreadyExistException;
import com.example.facSchedule.exceptions.NotFoundException;
import com.example.facSchedule.repository.SpecialityRepo;
import com.example.facSchedule.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private SpecialityRepo specialityRepo;

    public StudentEntity registration (StudentEntity student, Long specialityId) throws AlreadyExistException, NotFoundException {
        SpecialityEntity speciality = specialityRepo.findByIdSpeciality(specialityId);
        if (speciality == null) {
            throw new NotFoundException("No such speciality!");
        }
        if (studentRepo.findByLogin(student.getLogin()) != null) {
            throw new AlreadyExistException("Користувач з таким логіном вже існує");
        }
        student.setSpeciality(speciality);
        return studentRepo.save(student);
    }

    public StudentEntity getOne(String login) throws NotFoundException {
        StudentEntity student = studentRepo.findByLogin(login);
        if (student == null) {
            throw new NotFoundException("Пользователь не найден");
        }
        return student;
    }

    public Long delete(Long id) {
        studentRepo.deleteById(id);
        return id;
    }

}
