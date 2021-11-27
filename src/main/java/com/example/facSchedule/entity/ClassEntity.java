package com.example.facSchedule.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Class")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClass;
    private Long idProfessor;
    private Date dayOfClass;
    private Integer numOfClass;
    private Long idGroupStud;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    public Long getIdClass() {
        return idClass;
    }

    public void setIdClass(Long idClass) {
        this.idClass = idClass;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Date getDayOfClass() {
        return dayOfClass;
    }

    public void setDayOfClass(Date dayOfClass) {
        this.dayOfClass = dayOfClass;
    }

    public Integer getNumOfClass() {
        return numOfClass;
    }

    public void setNumOfClass(Integer numOfClass) {
        this.numOfClass = numOfClass;
    }

    public Long getIdGroupStud() {
        return idGroupStud;
    }

    public void setIdGroupStud(Long idGroupStud) {
        this.idGroupStud = idGroupStud;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

}
