package ru.hse.order.app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hse.order.app.dto.Station;
import ru.hse.order.app.exception.NotFoundById;
import ru.hse.order.app.mapper.StationMapper;
import ru.hse.order.data.api.repository.StationRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;
    private final StationMapper stationMapper;

    @Override
    public Station createStation(Station station) {
        station = stationMapper.dataModel2AppDto(stationRepository.save(stationMapper.appDto2DataModel(station)));
        return station;
    }

    @Override
    public void updateStation(Station station) {
        if(!stationRepository.existsById(station.getId())) {
            throw new NotFoundById(station.getId());
        }
        stationRepository.updateById(stationMapper.appDto2DataModel(station));
    }

    @Override
    public void deleteStation(UUID id) {
        if(!stationRepository.existsById(id)) {
            throw new NotFoundById(id);
        }
        stationRepository.deleteById(id);
    }

    @Override
    public Station getStationById(UUID id) {
        if (!stationRepository.existsById(id)) {
            throw new NotFoundById(id);
        }
        return stationMapper.dataModel2AppDto(stationRepository.findById(id));
    }

    @Override
    public List<Station> FindByNameLike(String name) {
        var list = stationRepository.findByNameLike(name);
        return list.stream()
                .map(stationMapper::dataModel2AppDto)
                .toList();
    }
}
