package ru.hse.user.app.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hse.user.api.UserApi;
import ru.hse.user.api.dto.AuthRequest;
import ru.hse.user.api.dto.User;
import ru.hse.user.app.exception.UserNotFound;
import ru.hse.user.app.mapper.AuthRequestMapper;
import ru.hse.user.app.mapper.UserMapper;
import ru.hse.user.app.service.UserService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController implements UserApi {
    private final UserService userService;
    private final UserMapper userMapper;
    private final AuthRequestMapper authRequestMapper;

    @Override
    @PostMapping("/register")
    public User Create(@RequestBody User request) {
        request = userMapper.appDto2ApiDto(userService.create(userMapper.apiDto2AppDto(request)));
        return request;
    }

    @Override
    @PostMapping("/token")
    public String createToken(@RequestBody AuthRequest authRequest) {
        return userService.createToken(authRequestMapper.apiDto2AppDto(authRequest));
    }

    @Override
    @GetMapping("/validate")
    public void validateToken(@RequestParam("token") String token) {
        userService.validateToken(token);
    }

    @Override
    @DeleteMapping
    public void Delete(@RequestBody UUID request) {
        userService.delete(request);
    }

    @Override
    @GetMapping
    public User Get(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "UUID", required = false) UUID id) {
        if (name != null)
            return userMapper.appDto2ApiDto(userService.getByName(name));
        if (id != null)
            return userMapper.appDto2ApiDto(userService.getByName(name));
        return null;
    }
}
