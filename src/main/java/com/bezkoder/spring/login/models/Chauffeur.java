package com.bezkoder.spring.login.models;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("conducteur")
public class Chauffeur extends User {


    private int note;
    private String permis;
    private String cin;
    private String photo;
    private String adress;

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getPermis() {
        return permis;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Chauffeur() {

    }

    public Chauffeur(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 120) String confirmedPassword, String firstName, Date createdAt, String genre, String birthdate, String lastName, String tel, Boolean isPhoneVerified, int note, String permis, String cin, String photo, String adress) {
        super(id, username, email, password, confirmedPassword, firstName, createdAt, genre, birthdate, lastName, tel, isPhoneVerified);
        this.note = note;
        this.permis = permis;
        this.cin = cin;
        this.photo = photo;
        this.adress = adress;
    }
}
