package com.bezkoder.spring.login.models;



import javax.persistence.*;

@Entity
public class Modelvoiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nom;
    @ManyToOne
private MarqueVoiture marqueVoiture;

    public MarqueVoiture getMarqueVoiture() {
        return marqueVoiture;
    }

    public void setMarqueVoiture(MarqueVoiture marqueVoiture) {
        this.marqueVoiture = marqueVoiture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Modelvoiture() {
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Modelvoiture(Long id, String nom, MarqueVoiture marqueVoiture) {
        this.id = id;
        this.nom = nom;
        this.marqueVoiture = marqueVoiture;
    }
}
