package com.isikenes.mvcsecurity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "users")
public class User {
    @Id
    @NotBlank(message = "is required")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "is required")
    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private int enabled;

    public User() {
    }

    @Autowired
    public User(String username, String password, int enabled) {
        this.username = username;
        this.password = password;
        this.enabled=enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int isEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
