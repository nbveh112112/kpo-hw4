package ru.hse.order.app.mapper;

import org.mapstruct.Mapper;
import ru.hse.order.app.dto.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    ru.hse.order.api.dto.Order appDto2ApiDto(
            Order order);

    Order apiDto2AppDto(
            ru.hse.order.api.dto.Order order);

    Order dataModel2AppDto(
            ru.hse.order.data.api.model.Order order);

    ru.hse.order.data.api.model.Order appDto2DataModel(
            Order order);
}
