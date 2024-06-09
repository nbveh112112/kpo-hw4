package ru.hse.user.app.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.hse.user.app.dto.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T17:16:35+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public ru.hse.user.api.dto.User appDto2ApiDto(User order) {
        if ( order == null ) {
            return null;
        }

        ru.hse.user.api.dto.User user = new ru.hse.user.api.dto.User();

        user.setId( order.getId() );
        user.setName( order.getName() );
        user.setEmail( order.getEmail() );
        user.setPassword( order.getPassword() );

        return user;
    }

    @Override
    public User apiDto2AppDto(ru.hse.user.api.dto.User order) {
        if ( order == null ) {
            return null;
        }

        User user = new User();

        user.setId( order.getId() );
        user.setName( order.getName() );
        user.setEmail( order.getEmail() );
        user.setPassword( order.getPassword() );

        return user;
    }

    @Override
    public User dataModel2AppDto(ru.hse.user.data.api.model.User order) {
        if ( order == null ) {
            return null;
        }

        User user = new User();

        user.setId( order.getId() );
        user.setName( order.getName() );
        user.setEmail( order.getEmail() );
        user.setPassword( order.getPassword() );
        user.setCreated( order.getCreated() );

        return user;
    }

    @Override
    public ru.hse.user.data.api.model.User appDto2DataModel(User order) {
        if ( order == null ) {
            return null;
        }

        ru.hse.user.data.api.model.User user = new ru.hse.user.data.api.model.User();

        user.setId( order.getId() );
        user.setName( order.getName() );
        user.setEmail( order.getEmail() );
        user.setPassword( order.getPassword() );
        user.setCreated( order.getCreated() );

        return user;
    }
}
