package com.example.facSchedule.service;

import com.example.facSchedule.entity.DeaneryEntity;
import com.example.facSchedule.entity.SpecialityEntity;
import com.example.facSchedule.exceptions.AlreadyExistException;
import com.example.facSchedule.repository.DeaneryRepo;
import com.example.facSchedule.repository.SpecialityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeaneryService {

    @Autowired
    private DeaneryRepo deaneryRepo;
    @Autowired
    private SpecialityRepo specialityRepo;

    public DeaneryEntity registration (DeaneryEntity deanery) throws AlreadyExistException {
        if (deaneryRepo.findByLogin(deanery.getLogin()) != null) {
            throw new AlreadyExistException("Користувач з таким логіном вже існує");
        }
        return deaneryRepo.save(deanery);
    }

    public List<SpecialityEntity> getAllSpeciality (Long deaneryId) throws AlreadyExistException {
        DeaneryEntity deanery = deaneryRepo.findByIdDeanery(deaneryId);
        return deanery.getSpecialities();
    }

}
