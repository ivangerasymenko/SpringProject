package com.example.facSchedule.entity;

import javax.persistence.*;

@Entity
@Table(name = "Speciality")
public class SpecialityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpeciality;
    private String specialityName;

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

}

