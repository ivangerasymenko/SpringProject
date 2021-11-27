package com.example.facSchedule.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;
    private Long idSpeciality;
    private String studentName;
    private Integer yearOfAdmission;
    private String login;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<PickedSubjectEntity> studentSubjects;

    public StudentEntity() {
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public Long getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Long idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(Integer yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
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

    public List<PickedSubjectEntity> getStudentSubjects() {
        return studentSubjects;
    }

    public void setStudentSubjects(List<PickedSubjectEntity> studentSubjects) {
        this.studentSubjects = studentSubjects;
    }

}
