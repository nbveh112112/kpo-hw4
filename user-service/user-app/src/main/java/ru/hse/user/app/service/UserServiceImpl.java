package ru.hse.user.app.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.hse.user.app.dto.AuthRequest;
import ru.hse.user.app.dto.Session;
import ru.hse.user.app.dto.User;
import ru.hse.user.app.exception.IncorrectPassword;
import ru.hse.user.app.exception.NotFoundById;
import ru.hse.user.app.exception.TokenExpiredOrInvalid;
import ru.hse.user.app.exception.UserNotFound;
import ru.hse.user.app.mapper.UserMapper;
import ru.hse.user.data.api.repository.UserRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final SessionService sessionService;

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userMapper.dataModel2AppDto(
                userRepository.save(userMapper.appDto2DataModel(user)));
        return user;
    }

    @Override
    public String createToken(AuthRequest authRequest) {
        //TODO: Implement password validation
        User user = userMapper.dataModel2AppDto(userRepository.findByUserName(authRequest.getName()));
        if (user == null) {
            throw new UserNotFound(authRequest.getName());
        }
        if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            throw new IncorrectPassword();
        }
        Session session = new Session();
        session.setUser_id(user.getId());
        session.setToken(jwtService.generateToken(user.getName()));
        session.setExpires(new Timestamp(System.currentTimeMillis() + 1000 * 60 * 60 * 10));
        sessionService.create(session);

        return session.getToken();
    }

    @Override
    public void validateToken(String token) {
        try{
            jwtService.validateToken(token);
        }
        catch (Exception e){
            throw new TokenExpiredOrInvalid(token);
        }
    }

    @Override
    public void delete(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundById(id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public User getById(UUID id) {
        if(!userRepository.existsById(id)) {
            throw new NotFoundById(id);
        }
        return userMapper.dataModel2AppDto(userRepository.findById(id));
    }

    @Override
    public User getByName(String name) {
        return userMapper.dataModel2AppDto(userRepository.findByUserName(name));
    }
}
