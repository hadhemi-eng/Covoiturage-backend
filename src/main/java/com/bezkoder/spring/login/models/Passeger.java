package com.bezkoder.spring.login.models;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Entity
@DiscriminatorValue("passager")
public class Passeger extends User {
    public Passeger() {
    }

    public Passeger(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 120) String confirmedPassword, String firstName, Date createdAt, String genre, String birthdate, String lastName, String tel, Boolean isPhoneVerified) {
        super(id, username, email, password, confirmedPassword, firstName, createdAt, genre, birthdate, lastName, tel, isPhoneVerified);
    }
}
