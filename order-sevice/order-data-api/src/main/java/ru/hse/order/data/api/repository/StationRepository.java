package ru.hse.order.data.api.repository;

import ru.hse.order.data.api.model.Station;

import java.util.List;
import java.util.UUID;

public interface StationRepository {
    Station save(Station order);

    void updateById(Station order);

    Station findById(UUID id);

    List<Station> findByNameLike(String name);


    void deleteById(UUID id);

    boolean existsById(UUID id);
}
