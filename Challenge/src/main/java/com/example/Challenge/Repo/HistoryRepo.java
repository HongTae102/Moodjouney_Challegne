package com.example.Challenge.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Challenge.Entity.History;

@Repository
public interface HistoryRepo extends JpaRepository<History, Long> {
    List<History> findByEmail(String email);
}
