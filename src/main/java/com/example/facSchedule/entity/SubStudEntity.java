package com.example.facSchedule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubStudEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sub_stud;
    private Long id_subject;
    private Long id_group_stud;

    public SubStudEntity() {
    }

    public Long getId_sub_stud() {
        return id_sub_stud;
    }

    public void setId_sub_stud(Long id_sub_stud) {
        this.id_sub_stud = id_sub_stud;
    }

    public Long getId_subject() {
        return id_subject;
    }

    public void setId_subject(Long id_subject) {
        this.id_subject = id_subject;
    }

    public Long getId_group_stud() {
        return id_group_stud;
    }

    public void setId_group_stud(Long id_group_stud) {
        this.id_group_stud = id_group_stud;
    }
}
