package com.example.facSchedule.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Speciality")
public class SpecialityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpeciality;
    private String specialityName;

    @ManyToOne
    @JoinColumn(name = "deanery_id")
    private DeaneryEntity deanery;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "speciality")
    List<SubjectEntity> subjects;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "speciality")
    List<StudentEntity> students;

    /*
{
  "specialityName":"",
}
*/

    public SpecialityEntity() {
    }

    public Long getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Long idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public DeaneryEntity getDeanery() {
        return deanery;
    }

    public void setDeanery(DeaneryEntity deanery) {
        this.deanery = deanery;
    }

    public List<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectEntity> subjects) {
        this.subjects = subjects;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
}

