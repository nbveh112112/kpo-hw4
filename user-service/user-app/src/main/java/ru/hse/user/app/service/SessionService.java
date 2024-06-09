package ru.hse.user.app.service;

import ru.hse.user.app.dto.Session;

import java.util.UUID;

public interface SessionService {

    Session create(Session session);

    Session getById(UUID id);

    Session getByToken(String token);

    void  updateById(Session session);

    void delete(UUID id);
}
