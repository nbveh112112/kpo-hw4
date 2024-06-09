package ru.hse.user.data.api.repository;

import ru.hse.user.data.api.model.User;

import java.util.UUID;

public interface UserRepository {
    User save(User order);

    User findById(UUID id);

    User findByUserName(String name);

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
