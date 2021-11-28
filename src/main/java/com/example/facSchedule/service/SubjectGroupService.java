package com.example.facSchedule.service;

import com.example.facSchedule.entity.ProfessorEntity;
import com.example.facSchedule.entity.SubjectEntity;
import com.example.facSchedule.entity.SubjectGroupEntity;
import com.example.facSchedule.exceptions.AlreadyExistException;
import com.example.facSchedule.exceptions.NotFoundException;
import com.example.facSchedule.repository.ProfessorRepo;
import com.example.facSchedule.repository.SubjectGroupRepo;
import com.example.facSchedule.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectGroupService {


@Autowired
private SubjectGroupRepo subjectGroupRepo;

@Autowired
private ProfessorRepo professorRepo;

@Autowired
private SubjectRepo subjectRepo;

    public SubjectGroupEntity add(SubjectGroupEntity subjectGroup, Long idProfessor, Long idSubject) throws AlreadyExistException, NotFoundException {
        ProfessorEntity professor = professorRepo.findByIdProfessor(idProfessor);
        SubjectEntity subject = subjectRepo.findByIdSubject(idSubject);
        if (professor == null) throw new NotFoundException("No such professor!");
        if (subject == null) throw new NotFoundException("No such subject!");
        if (subjectRepo.findByIdSubject(subjectGroup.getIdGroup()) != null) throw new AlreadyExistException("No such subject!");
        subjectGroup.setSubject(subject);
        subjectGroup.setProfessor(professor);
        return subjectGroupRepo.save(subjectGroup);
    }

   /* public StudentEntity getOne(String login) throws NotFoundException {
        StudentEntity student = studentRepo.findByLogin(login);
        if (student == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return student;
    }*/

    public Long delete(Long id) {
        subjectGroupRepo.deleteById(id);
        return id;
    }

}
