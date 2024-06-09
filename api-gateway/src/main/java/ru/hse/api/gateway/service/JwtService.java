package ru.hse.api.gateway.service;

public interface JwtService {
    void validateToken(String token);
}
