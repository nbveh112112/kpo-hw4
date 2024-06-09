package ru.hse.order.app.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.hse.order.data.api.model.Station;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T01:24:11+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class StationMapperImpl implements StationMapper {

    @Override
    public Station appDto2DataModel(ru.hse.order.app.dto.Station station) {
        if ( station == null ) {
            return null;
        }

        Station station1 = new Station();

        station1.setId( station.getId() );
        station1.setName( station.getName() );

        return station1;
    }

    @Override
    public ru.hse.order.app.dto.Station dataModel2AppDto(Station station) {
        if ( station == null ) {
            return null;
        }

        ru.hse.order.app.dto.Station station1 = new ru.hse.order.app.dto.Station();

        station1.setId( station.getId() );
        station1.setName( station.getName() );

        return station1;
    }

    @Override
    public ru.hse.order.app.dto.Station apiDto2AppDto(ru.hse.order.api.dto.Station station) {
        if ( station == null ) {
            return null;
        }

        ru.hse.order.app.dto.Station station1 = new ru.hse.order.app.dto.Station();

        station1.setId( station.getId() );
        station1.setName( station.getName() );

        return station1;
    }

    @Override
    public ru.hse.order.api.dto.Station appDto2ApiDto(ru.hse.order.app.dto.Station station) {
        if ( station == null ) {
            return null;
        }

        ru.hse.order.api.dto.Station station1 = new ru.hse.order.api.dto.Station();

        station1.setId( station.getId() );
        station1.setName( station.getName() );

        return station1;
    }
}
