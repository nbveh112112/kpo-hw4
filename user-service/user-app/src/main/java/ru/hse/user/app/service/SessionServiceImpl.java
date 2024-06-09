package ru.hse.user.app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hse.user.app.dto.Session;
import ru.hse.user.app.exception.NotFoundById;
import ru.hse.user.app.mapper.SessionMapper;
import ru.hse.user.data.api.repository.SessionRepository;

import java.util.UUID;

@Service
@AllArgsConstructor
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;
    private final SessionMapper sessionMapper;

    @Override
    public Session create(Session session) {
        session = sessionMapper.dataModel2AppDto(sessionRepository.save(sessionMapper.appDto2DataModel(session)));
        return session;
    }

    @Override
    public Session getById(UUID id) {
        if (!sessionRepository.existsById(id)) {
            throw new NotFoundById(id);
        }
        return sessionMapper.dataModel2AppDto(sessionRepository.findById(id));
    }

    @Override
    public Session getByToken(String token) {
        return sessionMapper.dataModel2AppDto(sessionRepository.findByToken(token));
    }

    @Override
    public void updateById(Session session) {
        if (!sessionRepository.existsById(session.getId())) {
            throw new NotFoundById(session.getId());
        }
        sessionRepository.updateById(sessionMapper.appDto2DataModel(session));
    }

    @Override
    public void delete(UUID id) {
        if (!sessionRepository.existsById(id)) {
            throw new NotFoundById(id);
        }
        sessionRepository.deleteById(id);
    }
}
