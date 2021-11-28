package com.example.facSchedule.service;

import com.example.facSchedule.entity.SpecialityEntity;
import com.example.facSchedule.repository.SpecialityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialityService {

    @Autowired
    private SpecialityRepo specialityRepo;

    public SpecialityEntity addSpeciality(SpecialityEntity speciality) throws Exception {
        if (specialityRepo.findBySpecialityName(speciality.getSpecialityName()) != null) {
            throw new Exception("Така спеціальність вже існує!");
        }
        return specialityRepo.save(speciality);
    }
}
