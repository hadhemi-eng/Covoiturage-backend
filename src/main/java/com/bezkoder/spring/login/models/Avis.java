package com.bezkoder.spring.login.models;


import javax.persistence.*;

@Entity
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private int raiting;
    @ManyToOne
    private Chauffeur chauffeur;
    @ManyToOne
    private Passeger passeger;

    public Passeger getPasseger() {
        return passeger;
    }

    public void setPasseger(Passeger passeger) {
        this.passeger = passeger;
    }

    public Avis() {
    }



    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Avis(Long id, int raiting, Chauffeur chauffeur, Passeger passeger) {
        this.id = id;
        this.raiting = raiting;
        this.chauffeur = chauffeur;
        this.passeger = passeger;
    }
}


