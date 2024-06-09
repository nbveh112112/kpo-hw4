package ru.hse.user.app.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class IncorrectPassword extends RuntimeException {
    public IncorrectPassword() {
        super("Incorrect password");
    }
}
