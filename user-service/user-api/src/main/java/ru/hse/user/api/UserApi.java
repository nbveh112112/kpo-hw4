package ru.hse.user.api;

import java.util.UUID;

import ru.hse.user.api.dto.AuthRequest;
import ru.hse.user.api.dto.User;

public interface UserApi {
    User Create(User request);

    String createToken(AuthRequest user);

    void validateToken(String token);

    void Delete(UUID request);
    User Get(String name, UUID id);
}
