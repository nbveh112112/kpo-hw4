package ru.hse.user.api.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class User {
    private UUID id;
    private String name;
    private String email;
    private String password;
}
