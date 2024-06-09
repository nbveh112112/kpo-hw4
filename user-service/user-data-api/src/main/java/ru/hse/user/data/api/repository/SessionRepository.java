package ru.hse.user.data.api.repository;

import ru.hse.user.data.api.model.Session;

import java.util.UUID;

public interface SessionRepository {
    Session save(Session order);

    void updateById(Session order);

    Session findById(UUID id);

    Session findByToken(String token);

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
