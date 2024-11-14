package com.bezkoder.spring.login.models;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String date_depart;

    private String lieu_depart;
    private String lieu_arrive;

    private Boolean tabac;
    private Boolean homme;
    private Boolean femme;

    public Boolean getHomme() {
        return homme;
    }

    public void setHomme(Boolean homme) {
        this.homme = homme;
    }

    public Boolean getFemme() {
        return femme;
    }

    public void setFemme(Boolean femme) {
        this.femme = femme;
    }

    private Boolean climatiseur;
    private String type_bagage;

    public Boolean getTabac() {
        return tabac;
    }

    public void setTabac(Boolean tabac) {
        this.tabac = tabac;
    }

    public Boolean getClimatiseur() {
        return climatiseur;
    }

    public void setClimatiseur(Boolean climatiseur) {
        this.climatiseur = climatiseur;
    }

    public String getType_bagage() {
        return type_bagage;
    }

    public void setType_bagage(String type_bagage) {
        this.type_bagage = type_bagage;
    }

    private Date createdAt = new Date();

    private Number nbrplacesdisponible;
    private String prix;
    private String heurDepart;

    private String description;
    private Boolean aller_retour;
    private Boolean regulier;
    private Boolean canModify;

    public Boolean getCanModify() {
        return canModify;
    }

    public void setCanModify(Boolean canModify) {
        this.canModify = canModify;
    }

    @ManyToOne
    private Chauffeur chauffeur;
    @ManyToOne
    private Voiture voiture;

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }


    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public String getLieu_depart() {
        return lieu_depart;
    }

    public void setLieu_depart(String lieu_depart) {
        this.lieu_depart = lieu_depart;
    }

    public String getLieu_arrive() {
        return lieu_arrive;
    }

    public void setLieu_arrive(String lieu_arrive) {
        this.lieu_arrive = lieu_arrive;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Number getNbrplacesdisponible() {
        return nbrplacesdisponible;
    }

    public void setNbrplacesdisponible(Number nbrplacesdisponible) {
        this.nbrplacesdisponible = nbrplacesdisponible;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }


    public String getHeurDepart() {
        return heurDepart;
    }

    public void setHeurDepart(String heurDepart) {
        this.heurDepart = heurDepart;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAller_retour() {
        return aller_retour;
    }

    public void setAller_retour(Boolean aller_retour) {
        this.aller_retour = aller_retour;
    }

    public Boolean getRegulier() {
        return regulier;
    }

    public void setRegulier(Boolean regulier) {
        this.regulier = regulier;
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

    public Annonce(Long id, String date_depart, String lieu_depart, String lieu_arrive, Boolean tabac, Boolean homme, Boolean femme, Boolean climatiseur, String type_bagage, Date createdAt, Number nbrplacesdisponible, String prix, String heurDepart, String description, Boolean aller_retour, Boolean regulier, Boolean canModify, Chauffeur chauffeur, Voiture voiture) {
        this.id = id;
        this.date_depart = date_depart;
        this.lieu_depart = lieu_depart;
        this.lieu_arrive = lieu_arrive;
        this.tabac = tabac;
        this.homme = homme;
        this.femme = femme;
        this.climatiseur = climatiseur;
        this.type_bagage = type_bagage;
        this.createdAt = createdAt;
        this.nbrplacesdisponible = nbrplacesdisponible;
        this.prix = prix;
        this.heurDepart = heurDepart;
        this.description = description;
        this.aller_retour = aller_retour;
        this.regulier = regulier;
        this.canModify = canModify;
        this.chauffeur = chauffeur;
        this.voiture = voiture;
    }

    public Annonce() {
    }
}
