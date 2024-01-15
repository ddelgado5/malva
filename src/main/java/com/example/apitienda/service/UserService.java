package com.example.apitienda.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {

    ResponseEntity<String> signUp(Map<String, String> requeMap);

    ResponseEntity<String>login(Map<String, String> requeMap);
}
