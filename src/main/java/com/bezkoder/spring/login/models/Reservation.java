package com.bezkoder.spring.login.models;



import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Number Nbplaces;
    private String etat;
    private Boolean valide;

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    private Date heure =new Date();

//    LocalTime localTime = LocalTime.now();
    public Reservation() {
    }
    @ManyToOne
    private Passeger passeger;
    @ManyToOne
    private Annonce annonce;

    private  Date datevu ;

    public Date getDatevu() {
        return datevu;
    }

    public void setDatevu(Date datevu) {
        this.datevu = datevu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }


    public Number getNbplaces() {
        return Nbplaces;
    }

    public void setNbplaces(Number nbplaces) {
        Nbplaces = nbplaces;
    }


    public Passeger getPasseger() {
        return passeger;
    }

    public void setPasseger(Passeger passeger) {
        this.passeger = passeger;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

}
