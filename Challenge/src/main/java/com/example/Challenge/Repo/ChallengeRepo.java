package com.example.Challenge.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Challenge.Entity.Challenge;

public interface ChallengeRepo extends JpaRepository<Challenge, Integer> {
}