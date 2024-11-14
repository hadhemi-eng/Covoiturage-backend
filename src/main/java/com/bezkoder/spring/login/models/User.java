package com.bezkoder.spring.login.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typ_User")
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank
    private String username;

    @NotBlank

    private String email;

    @NotBlank

    private String password;
  @NotBlank

  private String confirmedPassword;
  private String firstName;
  private Date createdAt = new Date();
  private String genre;
  private String  birthdate;
  private String lastName;
  private String tel;
  private Boolean isPhoneVerified;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

  public User(Long id, @NotBlank  String username, @NotBlank  String email, @NotBlank  String password, @NotBlank  String confirmedPassword, String firstName, Date createdAt, String genre, String birthdate, String lastName, String tel, Boolean isPhoneVerified) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.confirmedPassword = confirmedPassword;
    this.firstName = firstName;
    this.createdAt = createdAt;
    this.genre = genre;
    this.birthdate = birthdate;
    this.lastName = lastName;
    this.tel = tel;
    this.isPhoneVerified = isPhoneVerified;
  }

  public User(String username, String email, String encode) {
  }

  public String getConfirmedPassword() {
    return confirmedPassword;
  }

  public void setConfirmedPassword(String confirmedPassword) {
    this.confirmedPassword = confirmedPassword;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public Boolean getPhoneVerified() {
    return isPhoneVerified;
  }

  public void setPhoneVerified(Boolean phoneVerified) {
    isPhoneVerified = phoneVerified;
  }

  public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
