package com.bezkoder.spring.login.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 20)
    private String name;

    public Role() {

    }


    public Role(String passager) {
    }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
