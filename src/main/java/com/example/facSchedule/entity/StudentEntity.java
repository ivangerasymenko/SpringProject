package com.example.facSchedule.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_student;
    private Long id_speciality;
    private String studentName;
    private Integer year_of_admission;
    private String login;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<SubStudEntity> studentSubjects;

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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getYear_of_admission() {
        return year_of_admission;
    }

    public void setYear_of_admission(Integer year_of_admission) {
        this.year_of_admission = year_of_admission;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
