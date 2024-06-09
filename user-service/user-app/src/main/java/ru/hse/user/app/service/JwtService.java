package ru.hse.user.app.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public interface JwtService {
    Jws<Claims> validateToken(String token);

    String generateToken(String username);
}
