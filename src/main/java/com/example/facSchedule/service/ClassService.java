package com.example.facSchedule.service;

import com.example.facSchedule.entity.ClassEntity;
import com.example.facSchedule.entity.SubjectEntity;
import com.example.facSchedule.repository.ClassRepo;
import com.example.facSchedule.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClassService {

    @Autowired
    private ClassRepo classRepo;
    @Autowired
    private SubjectRepo subjectRepo;

    /*public ClassEntity addClass(ClassEntity Class, Long subjectId) {
        SubjectEntity subject = subjectRepo.findById(subjectId).get();
        Class.setSubject(subject);
        return classRepo.save(Class);
    }*/

    public Long delete(Long id) {
        classRepo.deleteById(id);
        return id;
    }
}
