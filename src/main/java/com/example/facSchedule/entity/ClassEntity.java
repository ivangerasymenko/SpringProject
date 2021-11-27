package com.example.facSchedule.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_class;
    private Long id_professor;
    private Date Day_of_class;
    private Integer num_of_class;
    private Long id_group_stud;

    @ManyToOne
    @JoinColumn(name = "subject_id ")
    private SubjectEntity subject;

    public ClassEntity() {
    }

    public Long getId_class() {
        return id_class;
    }

    public void setId_class(Long id_class) {
        this.id_class = id_class;
    }

    public Long getId_professor() {
        return id_professor;
    }

    public void setId_professor(Long id_professor) {
        this.id_professor = id_professor;
    }

    public Date getDay_of_class() {
        return Day_of_class;
    }

    public void setDay_of_class(Date day_of_class) {
        Day_of_class = day_of_class;
    }

    public Integer getNum_of_class() {
        return num_of_class;
    }

    public void setNum_of_class(Integer num_of_class) {
        this.num_of_class = num_of_class;
    }

    public Long getId_group_stud() {
        return id_group_stud;
    }

    public void setId_group_stud(Long id_group_stud) {
        this.id_group_stud = id_group_stud;
    }
}
