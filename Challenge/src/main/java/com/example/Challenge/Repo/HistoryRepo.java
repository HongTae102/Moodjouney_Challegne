package com.example.Challenge.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Challenge.Entity.History;

public interface HistoryRepo extends JpaRepository<History, Long> {
}
