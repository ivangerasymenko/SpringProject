package com.example.facSchedule.repository;


import com.example.facSchedule.entity.StudentEntity;
import com.example.facSchedule.entity.SubjectEntity;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepo extends CrudRepository<SubjectEntity, Long>{
    SubjectEntity findBySubjectName(String subjectName);
    SubjectEntity findByIdSubject(Long id);
}

