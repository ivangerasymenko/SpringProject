package com.example.facSchedule.entity;

import javax.persistence.*;

@Entity
@Table(name = "PickedSubject")
public class PickedSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubStud;
    private Long idSubject;
    private Long idGroupStud;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    public PickedSubjectEntity() {
    }

    public Long getIdSubStud() {
        return idSubStud;
    }

    public void setIdSubStud(Long idSubStud) {
        this.idSubStud = idSubStud;
    }

    public Long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Long idSubject) {
        this.idSubject = idSubject;
    }

    public Long getIdGroupStud() {
        return idGroupStud;
    }

    public void setIdGroupStud(Long idGroupStud) {
        this.idGroupStud = idGroupStud;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}
