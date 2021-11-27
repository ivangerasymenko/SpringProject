package com.example.facSchedule.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Subject")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubject;
    private String subjectName;
    private Integer course;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private List<ClassEntity> classes;

    public SubjectEntity() {
    }

    public Long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Long idSubject) {
        this.idSubject = idSubject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public List<ClassEntity> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassEntity> classes) {
        this.classes = classes;
    }

}
