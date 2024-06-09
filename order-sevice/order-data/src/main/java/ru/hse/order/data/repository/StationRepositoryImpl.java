package ru.hse.order.data.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.hse.order.data.api.model.Station;
import ru.hse.order.data.api.repository.StationRepository;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class StationRepositoryImpl implements StationRepository {

    public static final RowMapper<Station> STATION_ROW_MAPPER =
            (rs, i) -> {
                Station station = new Station();
                station.setId(UUID.fromString(rs.getString("id")));
                station.setName(rs.getString("name"));
                return station;
            };

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Station save(Station order) {
        return jdbcTemplate.queryForObject(
                "insert into stations(id, name) values (uuid_generate_v4(), ?) returning id, name",
                STATION_ROW_MAPPER,
                order.getName()
        );
    }

    @Override
    public void updateById(Station order) {
        jdbcTemplate.update(
                "update stations set name = ? where id = ?",
                order.getName(),
                order.getId()
        );
    }

    @Override
    public Station findById(UUID id) {
        return jdbcTemplate.queryForObject(
                "select id, name from stations where id = ?",
                STATION_ROW_MAPPER,
                id
        );
    }

    @Override
    public List<Station> findByNameLike(String name) {
        return jdbcTemplate.query(
                "select id, name from stations where name like ? order by name",
                STATION_ROW_MAPPER,
                "%" + name + "%"
        );
    }

    @Override
    public void deleteById(UUID id) {
        jdbcTemplate.update("delete from stations where id = ?", id);
    }

    @Override
    public boolean existsById(UUID id) {
        return Boolean.TRUE.equals(
                jdbcTemplate.queryForObject(
                        "select exists(select * from stations where id = ?)",
                        Boolean.class,
                        id
                )
        );
    }
}
