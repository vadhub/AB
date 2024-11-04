package com.backend.athletica.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "email")
    private String email;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "password")
    private String password;

    public User() {}

    public User(Long idUser, String nickname, String firstname, String lastname, String email, String password) {
        this.idUser = idUser;
        this.nickname = nickname;
        this.firstname = firstname;
        this.email = email;
        this.lastname = lastname;
        this.password = password;
    }

    public User(String nickname, String firstname, String lastname, String email, String password) {
        this.nickname = nickname;
        this.firstname = firstname;
        this.email = email;
        this.lastname = lastname;
        this.password = password;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setId(Long idUser) {
        this.idUser = idUser;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String username) {
        this.nickname = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }
}
