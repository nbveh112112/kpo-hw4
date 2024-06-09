package ru.hse.order.app.mapper;

import org.mapstruct.Mapper;
import ru.hse.order.api.dto.Station;

@Mapper(componentModel = "spring")
public interface StationMapper {

    ru.hse.order.data.api.model.Station appDto2DataModel(
            ru.hse.order.app.dto.Station station);

    ru.hse.order.app.dto.Station dataModel2AppDto(
            ru.hse.order.data.api.model.Station station);

    ru.hse.order.app.dto.Station apiDto2AppDto(
            Station station);

    Station appDto2ApiDto(
            ru.hse.order.app.dto.Station station);
}
