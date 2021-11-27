package com.example.facSchedule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SpecialityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_speciality;
    private String speciality_name;

    public SpecialityEntity() {
    }

    public Long getId_speciality() {
        return id_speciality;
    }

    public void setId_speciality(Long id_speciality) {
        this.id_speciality = id_speciality;
    }

    public String getSpeciality_name() {
        return speciality_name;
    }

    public void setSpeciality_name(String speciality_name) {
        this.speciality_name = speciality_name;
    }
}

