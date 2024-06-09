package ru.hse.user.data.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.hse.user.data.api.model.User;
import ru.hse.user.data.api.repository.UserRepository;

import java.util.UUID;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    public static final RowMapper<User> ORDER_ROW_MAPPER =
            (rs, i) -> {
                User user = new User();

                user.setId(UUID.fromString(rs.getString("id")));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCreated(rs.getTimestamp("created_at"));
                return user;
            };

    private final JdbcTemplate jdbcTemplate;

    @Override
    public User save(User user) {
        return jdbcTemplate.queryForObject(
                "insert into users(id, name, email, password, created_at) "
                        + "values (uuid_generate_v4(), ?, ?, ?, ?) "
                        + "returning id, name, email, password, created_at",
                ORDER_ROW_MAPPER,
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getCreated());
    }


    @Override
    public User findById(UUID id) {
        try {
            return jdbcTemplate.queryForObject("select id, name, email, password, created_at from users where id=?", ORDER_ROW_MAPPER, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User findByUserName(String name) {
        try {
            return jdbcTemplate.queryForObject("select id, name, email, password, created_at from users where name=?", ORDER_ROW_MAPPER, name);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteById(UUID id) {
        jdbcTemplate.update("delete from users where id=?", id);
    }

    @Override
    public boolean existsById(UUID id) {
        return Boolean.TRUE.equals(jdbcTemplate.queryForObject(
                "select exists(select * from users where id=?)", Boolean.class, id));
    }

}
