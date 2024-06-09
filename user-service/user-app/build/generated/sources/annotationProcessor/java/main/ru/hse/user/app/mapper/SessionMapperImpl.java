package ru.hse.user.app.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.hse.user.data.api.model.Session;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T17:16:35+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class SessionMapperImpl implements SessionMapper {

    @Override
    public Session appDto2DataModel(ru.hse.user.app.dto.Session station) {
        if ( station == null ) {
            return null;
        }

        Session session = new Session();

        session.setId( station.getId() );
        session.setUser_id( station.getUser_id() );
        session.setToken( station.getToken() );
        session.setExpires( station.getExpires() );

        return session;
    }

    @Override
    public ru.hse.user.app.dto.Session dataModel2AppDto(Session station) {
        if ( station == null ) {
            return null;
        }

        ru.hse.user.app.dto.Session session = new ru.hse.user.app.dto.Session();

        session.setId( station.getId() );
        session.setUser_id( station.getUser_id() );
        session.setToken( station.getToken() );
        session.setExpires( station.getExpires() );

        return session;
    }
}
