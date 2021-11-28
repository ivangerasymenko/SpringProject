package com.example.facSchedule.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SubjectGroup")
public class SubjectGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGroup;
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorEntity professor;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @ManyToMany
    private List<StudentEntity> students;

    public SubjectGroupEntity() {
    }

    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    List<PickedSubjectEntity> pickedSubjects;*/

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectGroup")
    private List<ClassEntity> classes;

    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
