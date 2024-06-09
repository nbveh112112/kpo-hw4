package ru.hse.api.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import ru.hse.api.gateway.exception.UnAuthorized;
import ru.hse.api.gateway.service.JwtService;
import ru.hse.api.gateway.service.JwtServiceImpl;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
    @Autowired
    private RouteValidator validator;
    private JwtService jwtService = new JwtServiceImpl();

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new UnAuthorized("Authorization header not found");
                }
                String auth = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (auth == null || !auth.startsWith("Bearer ")) {
                    throw new UnAuthorized("Invalid authorization header");
                }
                String authToken = auth.substring(7);
                try {
                    jwtService.validateToken(authToken);
                } catch (Exception e) {
                    System.out.println("Invalid token: " + authToken);
                    throw new UnAuthorized("Invalid token");
                }
            }
            return chain.filter(exchange);
        };
    }

    public static class Config {
    }
}
