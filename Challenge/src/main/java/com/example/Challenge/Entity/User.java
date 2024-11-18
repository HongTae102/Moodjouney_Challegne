package com.example.Challenge.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class User {
    @Id
    @Column(name="User_id", length = 45)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private int id;

    @Column(name="User_name", length = 255)
    private String name;

    @Column(name="email", length = 255)
    private String email;

    @Column(name="password", length = 255)
    private String password;

    @Column(name="membership", length = 45)
    private int membership = 0; // Default to 0

    public User() {
        this.membership = 0;
    }
    
    public User(int id, String name, String email, String password, int membership) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.membership = membership;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getMembership() {
        return membership;
    }

    public void setMembership(int membership) {
        this.membership = membership;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", membership="
                + membership + "]";
    }

}