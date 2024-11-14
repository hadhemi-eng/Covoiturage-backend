package com.bezkoder.spring.login.models;


import javax.persistence.*;

@Entity
public class Reclamation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String titre;
    private String sujet;
    private Boolean reponseRec = false;
    private String reponse;

    public Boolean getReponseRec() {
        return reponseRec;
    }

    public void setReponseRec(Boolean reponseRec) {
        this.reponseRec = reponseRec;
    }

    public Reclamation() {
    }


    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reclamation(Long id, String titre, String sujet, Boolean reponseRec, String reponse, User appUser) {
        this.id = id;
        this.titre = titre;
        this.sujet = sujet;
        this.reponseRec = reponseRec;
        this.reponse = reponse;
        this.appUser = appUser;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @ManyToOne
    private User appUser;

    public User getAppUser() {
        return appUser;
    }

    public void setAppUser(User appUser) {
        this.appUser = appUser;
    }
}
