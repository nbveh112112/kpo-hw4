package ru.hse.user.app.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.hse.user.app.dto.AuthRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T19:56:06+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class AuthRequestMapperImpl implements AuthRequestMapper {

    @Override
    public AuthRequest apiDto2AppDto(ru.hse.user.api.dto.AuthRequest authRequest) {
        if ( authRequest == null ) {
            return null;
        }

        AuthRequest authRequest1 = new AuthRequest();

        authRequest1.setName( authRequest.getName() );
        authRequest1.setPassword( authRequest.getPassword() );

        return authRequest1;
    }

    @Override
    public ru.hse.user.api.dto.AuthRequest appDto2ApiDto(AuthRequest authRequest) {
        if ( authRequest == null ) {
            return null;
        }

        ru.hse.user.api.dto.AuthRequest authRequest1 = new ru.hse.user.api.dto.AuthRequest();

        authRequest1.setName( authRequest.getName() );
        authRequest1.setPassword( authRequest.getPassword() );

        return authRequest1;
    }
}
