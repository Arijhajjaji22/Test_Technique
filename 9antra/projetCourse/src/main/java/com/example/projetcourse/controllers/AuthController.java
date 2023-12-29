package com.example.projetcourse.controllers;

import com.example.projetcourse.entites.UserCredentials;
import com.example.projetcourse.repositories.UserRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserCredentials userCredentials) {
        System.out.println("Requête de connexion reçue. Email : " + userCredentials.getEmail());
        if (isValidCredentials(userCredentials)) {
            // Vérifier si l'utilisateur existe déjà dans la base de données
            Optional<UserCredentials> existingUser = userRepository.findByEmail(userCredentials.getEmail());

            if (existingUser.isPresent()) {
                // L'utilisateur existe déjà, authentification réussie
                Map<String, String> response = new HashMap<>();
                response.put("message", "Login successful");

                return ResponseEntity.ok(response);
            } else {
                System.out.println("Authentification invalide.");
                // L'utilisateur n'existe pas, vous pourriez ajouter une logique supplémentaire ici
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.emptyMap());
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.emptyMap());
        }
    }

    private boolean isValidCredentials(UserCredentials userCredentials) {
        return StringUtils.isNotBlank(userCredentials.getEmail()) && StringUtils.isNotBlank(userCredentials.getName());
    }
}
