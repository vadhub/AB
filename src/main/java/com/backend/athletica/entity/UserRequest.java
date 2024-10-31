package com.backend.athletica.entity;

public class UserRequest {

    private String nickname;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}