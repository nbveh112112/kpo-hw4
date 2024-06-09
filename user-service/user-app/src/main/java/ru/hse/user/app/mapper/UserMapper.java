package ru.hse.user.app.mapper;

import org.mapstruct.Mapper;
import ru.hse.user.app.dto.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ru.hse.user.api.dto.User appDto2ApiDto(
            User order);

    User apiDto2AppDto(
            ru.hse.user.api.dto.User order);

    User dataModel2AppDto(
            ru.hse.user.data.api.model.User order);

    ru.hse.user.data.api.model.User appDto2DataModel(
            User order);
}
