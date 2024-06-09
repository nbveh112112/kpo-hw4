package ru.hse.order.api;

import ru.hse.order.api.dto.Station;

import java.util.List;
import java.util.UUID;

public interface StationApi {

    Station stationCreate(Station request);

    void stationUpdate(Station request);

    Station stationGet(UUID request);

    void stationDelete(UUID request);



    List<Station> stationFindByNameLike(String name);
}
