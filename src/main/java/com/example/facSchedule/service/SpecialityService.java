package com.example.facSchedule.service;

import com.example.facSchedule.entity.DeaneryEntity;
import com.example.facSchedule.entity.SpecialityEntity;
import com.example.facSchedule.exceptions.AlreadyExistException;
import com.example.facSchedule.exceptions.NotFoundException;
import com.example.facSchedule.repository.DeaneryRepo;
import com.example.facSchedule.repository.SpecialityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialityService {

    @Autowired
    private SpecialityRepo specialityRepo;

    @Autowired
    private DeaneryRepo deaneryRepo;


    public SpecialityEntity addSpeciality(SpecialityEntity speciality, Long deaneryId) throws Exception {
        if (specialityRepo.findBySpecialityName(speciality.getSpecialityName()) != null) {
            throw new AlreadyExistException("Така спеціальність вже існує!");
        }

        DeaneryEntity deanery = deaneryRepo.findByIdDeanery(deaneryId);
        if (deanery == null) {
            throw new NotFoundException("Не коректний деканат");
        }

        speciality.setDeanery(deanery);
        return specialityRepo.save(speciality);

    }
}
