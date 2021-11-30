package com.example.facSchedule.repository;

import com.example.facSchedule.entity.SpecialityEntity;
import com.example.facSchedule.entity.SubjectEntity;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepo extends CrudRepository<SubjectEntity, Long>
{
    SubjectEntity findByIdSubject(Long id);
    Iterable <SubjectEntity> findAllBySpeciality(SpecialityEntity speciality);
}

