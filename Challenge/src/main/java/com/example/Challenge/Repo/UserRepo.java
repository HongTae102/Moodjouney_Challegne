package com.example.Challenge.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.Challenge.Entity.User;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Integer>
{
    Optional<User> findOneByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    
}
