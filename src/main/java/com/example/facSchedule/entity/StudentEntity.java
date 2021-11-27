package com.example.facSchedule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_student;
    private Long id_speciality;
    private String name;
    private Integer year_of_admission;

    public StudentEntity() {
    }

    public Long getId_student() {
        return id_student;
    }

    public void setId_student(Long id_student) {
        this.id_student = id_student;
    }

    public Long getId_speciality() {
        return id_speciality;
    }

    public void setId_speciality(Long id_speciality) {
        this.id_speciality = id_speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear_of_admission() {
        return year_of_admission;
    }

    public void setYear_of_admission(Integer year_of_admission) {
        this.year_of_admission = year_of_admission;
    }
}
