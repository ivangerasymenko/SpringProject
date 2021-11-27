package com.example.facSchedule.repository;


import com.example.facSchedule.entity.PickedSubjectEntity;
import org.springframework.data.repository.CrudRepository;

public interface SubStudRepo extends CrudRepository<PickedSubjectEntity, Long>{
}

