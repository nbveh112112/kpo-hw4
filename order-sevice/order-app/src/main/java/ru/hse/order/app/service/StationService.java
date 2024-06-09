package ru.hse.order.app.service;

import ru.hse.order.app.dto.Station;

import java.util.List;
import java.util.UUID;

public interface StationService {

    Station createStation(Station station);

    void updateStation(Station station);

    void deleteStation(UUID id);

    Station getStationById(UUID id);

    List<Station> FindByNameLike(String name);
}
