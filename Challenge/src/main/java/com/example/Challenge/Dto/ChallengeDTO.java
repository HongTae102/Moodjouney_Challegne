package com.example.Challenge.Dto;

public class ChallengeDTO {
    private int challenge_id;
    private String challenge;

    public ChallengeDTO(int employeeid, String employeename, String email, String password) {
        this.challenge_id = employeeid;
        this.challenge = employeename;
    }

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
        return "ChallengeDTO [challenge_id=" + challenge_id + ", challenge=" + challenge + "]";
    }

}
