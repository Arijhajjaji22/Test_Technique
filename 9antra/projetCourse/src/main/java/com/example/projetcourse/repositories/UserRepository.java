package com.example.projetcourse.repositories;

// UserRepository.java
import com.example.projetcourse.entites.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserCredentials, Long> {
    Optional<UserCredentials> findByEmail(String email);
}

