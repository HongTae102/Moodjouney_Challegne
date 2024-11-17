package com.example.Challenge.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Challenge")
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="challenge_id")
    private int challenge_id;

    @Column(name="challenge", length = 500)
    private String challenge;

    public int getChallenge_id() {
        return challenge_id;
    }

    public void setChallenge_id(int challenge_id) {
        this.challenge_id = challenge_id;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    @Override
    public String toString() {
        return "Challenge [challenge_id=" + challenge_id + ", challenge=" + challenge + "]";
    }
}
