package com.example.facSchedule.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Deanery")
public class DeaneryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeanery;
    private String login;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deanery")
    List<ProfessorEntity> professors;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deanery")
    List<SpecialityEntity> specialities;

    public Long getIdDeanery() {
        return idDeanery;
    }

    public void setIdDeanery(Long idDeanery) {
        this.idDeanery = idDeanery;
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

    public List<ProfessorEntity> getProfessors() {
        return professors;
    }

    public List<SpecialityEntity> getSpecialities() {
        return specialities;
    }

}
