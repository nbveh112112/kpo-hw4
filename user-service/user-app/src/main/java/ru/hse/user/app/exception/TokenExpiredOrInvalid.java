package ru.hse.user.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.GONE)
public class TokenExpiredOrInvalid extends RuntimeException {
    public TokenExpiredOrInvalid(String id) {
        super("Token '" + id + "' expired or invalid");
    }
}
