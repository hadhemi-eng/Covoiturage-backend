package com.bezkoder.spring.login.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MarqueVoiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nom;
    private String logo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogo() {
        return logo;
    }

    public void setPhoto(String photo) {
        this.logo = photo;
    }

    public MarqueVoiture() {
    }

    public MarqueVoiture(Long id, String nom, String logo) {
        this.id = id;
        this.nom = nom;
        this.logo = logo;
    }
}
