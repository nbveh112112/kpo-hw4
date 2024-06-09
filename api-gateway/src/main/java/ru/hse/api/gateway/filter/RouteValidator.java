package ru.hse.api.gateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    public static final List<String> openApiRoutes = List.of(
        "/api/v1/user/register",
        "/api/v1/user/validate",
        "api/v1/user/token"
    );

    public Predicate<ServerHttpRequest> isSecured = request -> openApiRoutes
        .stream()
        .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
