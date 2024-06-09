package ru.hse.user.data.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.hse.user.data.api.model.Session;
import ru.hse.user.data.api.repository.SessionRepository;

import java.util.UUID;

@Repository
@AllArgsConstructor
public class SessionRepositoryImpl implements SessionRepository {

    public static final RowMapper<Session> STATION_ROW_MAPPER =
            (rs, i) -> {
                Session session = new Session();
                session.setId(UUID.fromString(rs.getString("id")));
                session.setUser_id(UUID.fromString(rs.getString("user_id")));
                session.setToken(rs.getString("token"));
                session.setExpires(rs.getTimestamp("expires"));
                return session;
            };

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Session save(Session session) {
        return jdbcTemplate.queryForObject(
                "insert into sessions(id, user_id, token, expires) values (uuid_generate_v4(), ?, ?, ?) returning id, user_id, token, expires",
                STATION_ROW_MAPPER,
                session.getUser_id(),
                session.getToken(),
                session.getExpires()
        );
    }

    @Override
    public void updateById(Session order) {
        jdbcTemplate.update(
                "update sessions set user_id = ?, token = ?, expires = ? where id = ?",
                order.getUser_id(),
                order.getToken(),
                order.getExpires(),
                order.getId()
        );
    }

    @Override
    public Session findById(UUID id) {
        return jdbcTemplate.queryForObject(
                "select id, user_id, token, expires from sessions where id = ?",
                STATION_ROW_MAPPER,
                id
        );
    }

    @Override
    public Session findByToken(String token) {
        return jdbcTemplate.queryForObject(
                "select id, user_id, token, expires from sessions where token = ?",
                STATION_ROW_MAPPER,
                token
        );
    }


    @Override
    public void deleteById(UUID id) {
        jdbcTemplate.update("delete from sessions where id = ?", id);
    }

    @Override
    public boolean existsById(UUID id) {
        return Boolean.TRUE.equals(
                jdbcTemplate.queryForObject(
                        "select exists(select * from sessions where id = ?)",
                        Boolean.class,
                        id
                )
        );
    }
}
