package de.phonebook.model;

public class User {
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    private String email;

    private String password;

}