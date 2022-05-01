package com.example.patientlogin.admin;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode

@Entity(name = "admin")
public class Admin {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // auto generated when we create a user.


    @Column
    private String username;

    @Column
    private String password;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
