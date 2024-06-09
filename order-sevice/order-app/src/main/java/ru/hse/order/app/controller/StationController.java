package ru.hse.order.app.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hse.order.api.StationApi;
import ru.hse.order.api.dto.Station;
import ru.hse.order.app.mapper.StationMapper;
import ru.hse.order.app.service.StationService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/station")
public class StationController implements StationApi {
    private final StationService stationService;
    private final StationMapper stationMapper;
    @Override
    @PostMapping
    public Station stationCreate(@RequestBody Station request) {
        request = stationMapper.appDto2ApiDto(stationService.createStation(stationMapper.apiDto2AppDto(request)));
        return request;
    }

    @Override
    @PutMapping
    public void stationUpdate(@RequestBody Station request) {
        stationService.updateStation(stationMapper.apiDto2AppDto(request));

    }

    @Override
    @GetMapping("/{id}")
    public Station stationGet(@PathVariable UUID id) {
        return stationMapper.appDto2ApiDto(stationService.getStationById(id));
    }

    @Override
    @DeleteMapping
    public void stationDelete(@RequestBody UUID request) {
        stationService.deleteStation(request);
    }

    @Override
    @GetMapping("/name/{name}")
    public List<Station> stationFindByNameLike(@PathVariable(required = false) String name) {
        var list = stationService.FindByNameLike(name);
        return list.stream()
                .map(stationMapper::appDto2ApiDto)
                .toList();
    }
}
