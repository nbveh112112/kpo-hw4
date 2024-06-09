package ru.hse.api.gateway.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;


@Service
public class JwtServiceImpl implements JwtService{
    public static final String SECRET = "secretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkey";

    @Override
    public void validateToken(String token) {
       Jwts.parserBuilder().setSigningKey(SECRET).build().parseClaimsJws(token);
    }
}
