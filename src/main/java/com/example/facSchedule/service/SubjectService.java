package com.example.facSchedule.service;

import com.example.facSchedule.entity.SpecialityEntity;
import com.example.facSchedule.entity.SubjectEntity;
import com.example.facSchedule.exceptions.AlreadyExistException;
import com.example.facSchedule.exceptions.NotFoundException;
import com.example.facSchedule.model.SpecialityModel;
import com.example.facSchedule.model.SubjectModel;
import com.example.facSchedule.repository.SpecialityRepo;
import com.example.facSchedule.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private SpecialityRepo specialityRepo;

    public SubjectEntity addSubject(SubjectEntity subject, Long idSpeciality) throws NotFoundException,AlreadyExistException {
        SpecialityEntity specialityEntity = specialityRepo.findByIdSpeciality(idSpeciality);
        if (specialityEntity == null) throw new NotFoundException("No such speciality!");
        if(subjectRepo.findBySpecialityAndSubjectName(specialityEntity,subject.getSubjectName()) != null) throw new AlreadyExistException("Subject already exist on this speciality!");
        subject.setSpeciality(specialityEntity);
        return subjectRepo.save(subject);
    }

    public SubjectEntity getOneSubject(Long id) throws NotFoundException {
        SubjectEntity subject = subjectRepo.findByIdSubject(id);
        if (subject == null) throw new NotFoundException("No such subject");
        return subject;
    }

    public Long delete(Long id) {
        subjectRepo.deleteById(id);
        return id;
    }

    public List<SubjectModel> getSpecialitySubjects(Long idSpeciality) throws NotFoundException {
        SpecialityEntity specialityEntity = specialityRepo.findByIdSpeciality(idSpeciality);
        if (specialityEntity == null) throw new NotFoundException("No such speciality!");
        List<SubjectModel> list =  StreamSupport.stream(subjectRepo.findAllBySpeciality(specialityEntity).spliterator(), false).map(SubjectModel::toModel)
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            throw new NotFoundException("No subjects!");
        }
        return list;
    }
}
