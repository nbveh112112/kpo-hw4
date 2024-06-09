package ru.hse.user.app.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthRequestMapper {


    ru.hse.user.app.dto.AuthRequest apiDto2AppDto(ru.hse.user.api.dto.AuthRequest authRequest);


    ru.hse.user.api.dto.AuthRequest appDto2ApiDto(ru.hse.user.app.dto.AuthRequest authRequest);
}
