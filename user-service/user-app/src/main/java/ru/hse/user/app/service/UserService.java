package ru.hse.user.app.service;

import ru.hse.user.app.dto.AuthRequest;
import ru.hse.user.app.dto.User;

import java.util.UUID;

public interface UserService {
    User create(User user);

    String createToken(AuthRequest authRequest);

    void validateToken(String token);

    void delete(UUID id);
    User getById(UUID id);

    User getByName(String name);
}
