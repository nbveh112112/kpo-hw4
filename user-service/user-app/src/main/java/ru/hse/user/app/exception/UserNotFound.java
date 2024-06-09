package ru.hse.user.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException{

    public UserNotFound(String id) {
        super("User: '" + id + "' not found");
    }
}
