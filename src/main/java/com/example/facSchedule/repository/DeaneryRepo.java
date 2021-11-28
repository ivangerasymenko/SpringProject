package com.example.facSchedule.repository;

import com.example.facSchedule.entity.DeaneryEntity;
import org.springframework.data.repository.CrudRepository;

public interface DeaneryRepo extends CrudRepository<DeaneryEntity, Long>
{
    DeaneryEntity findByLogin(String login);
    DeaneryEntity findByIdDeanery(Long idDeanery);
}