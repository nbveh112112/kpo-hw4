package ru.hse.order.app.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.hse.order.app.dto.Order;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T01:24:11+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public ru.hse.order.api.dto.Order appDto2ApiDto(Order order) {
        if ( order == null ) {
            return null;
        }

        ru.hse.order.api.dto.Order order1 = new ru.hse.order.api.dto.Order();

        order1.setId( order.getId() );
        order1.setUser_id( order.getUser_id() );
        order1.setFrom_station_id( order.getFrom_station_id() );
        order1.setTo_station_id( order.getTo_station_id() );
        order1.setCreated( order.getCreated() );
        order1.setStatus( order.getStatus() );

        return order1;
    }

    @Override
    public Order apiDto2AppDto(ru.hse.order.api.dto.Order order) {
        if ( order == null ) {
            return null;
        }

        Order order1 = new Order();

        order1.setId( order.getId() );
        order1.setUser_id( order.getUser_id() );
        order1.setFrom_station_id( order.getFrom_station_id() );
        order1.setTo_station_id( order.getTo_station_id() );
        order1.setCreated( order.getCreated() );
        order1.setStatus( order.getStatus() );

        return order1;
    }

    @Override
    public Order dataModel2AppDto(ru.hse.order.data.api.model.Order order) {
        if ( order == null ) {
            return null;
        }

        Order order1 = new Order();

        order1.setId( order.getId() );
        order1.setUser_id( order.getUser_id() );
        order1.setFrom_station_id( order.getFrom_station_id() );
        order1.setTo_station_id( order.getTo_station_id() );
        order1.setCreated( order.getCreated() );
        order1.setStatus( order.getStatus() );

        return order1;
    }

    @Override
    public ru.hse.order.data.api.model.Order appDto2DataModel(Order order) {
        if ( order == null ) {
            return null;
        }

        ru.hse.order.data.api.model.Order order1 = new ru.hse.order.data.api.model.Order();

        order1.setId( order.getId() );
        order1.setUser_id( order.getUser_id() );
        order1.setFrom_station_id( order.getFrom_station_id() );
        order1.setTo_station_id( order.getTo_station_id() );
        order1.setCreated( order.getCreated() );
        order1.setStatus( order.getStatus() );

        return order1;
    }
}
