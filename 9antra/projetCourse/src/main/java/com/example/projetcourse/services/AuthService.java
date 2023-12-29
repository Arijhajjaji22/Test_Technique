package com.example.projetcourse.services;

import com.example.projetcourse.entites.UserCredentials;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    public boolean authenticateUser(UserCredentials userCredentials) {
        System.out.println("Authentification de l'utilisateur : " + userCredentials.getEmail());
        return true;
    }
}
