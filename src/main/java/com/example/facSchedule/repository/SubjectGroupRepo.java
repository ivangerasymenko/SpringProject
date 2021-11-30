package com.example.facSchedule.repository;

import com.example.facSchedule.entity.SubjectEntity;
import com.example.facSchedule.entity.SubjectGroupEntity;
import org.springframework.data.repository.CrudRepository;

public interface SubjectGroupRepo extends CrudRepository<SubjectGroupEntity, Long>
{
    SubjectGroupEntity findByIdGroup(Long idGroup);
    SubjectEntity findByGroupName(String groupName);
    Iterable<SubjectGroupEntity> findAllBySubject(SubjectEntity subject);
}
