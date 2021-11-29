package com.example.facSchedule.service;

import com.example.facSchedule.entity.ProfessorEntity;
import com.example.facSchedule.exceptions.AlreadyExistException;
import com.example.facSchedule.exceptions.NotFoundException;
import com.example.facSchedule.repository.ProfessorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepo professorRepo;


    ///TODO rewrite

    public ProfessorEntity registration (ProfessorEntity professor) throws AlreadyExistException {
        if (professorRepo.findByLogin(professor.getLogin()) != null) throw new AlreadyExistException("Професор з таким логіном вже існує");
        return professorRepo.save(professor);
    }

    public Long delete(Long id) {
        professorRepo.deleteById(id);
        return id;
    }

}