package ru.hse.user.app.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SessionMapper {

    ru.hse.user.data.api.model.Session appDto2DataModel(
            ru.hse.user.app.dto.Session station);

    ru.hse.user.app.dto.Session dataModel2AppDto(
            ru.hse.user.data.api.model.Session station);

}
