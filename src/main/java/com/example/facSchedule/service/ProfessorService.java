package com.example.facSchedule.service;

import com.example.facSchedule.repository.ProfessorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepo professorRepo;


    ///TODO rewrite

   /* public ProfessorEntity registration (ProfessorEntity professor, Long deaneryId) throws AlreadyExistException, NotFoundException {
        DeaneryEntity deanery = deaneryRepo.findByIdDeanery(deaneryId);
        if (deaneryId == null) throw new NotFoundException("No such deanery!");
        if (professorRepo.findByLogin(professor.getLogin()) != null) throw new AlreadyExistException("Професор з таким логіном вже існує");
        professor.setDeanery(deanery);
        return professorRepo.save(professor);
    }*/

    public Long delete(Long id) {
        professorRepo.deleteById(id);
        return id;
    }

}