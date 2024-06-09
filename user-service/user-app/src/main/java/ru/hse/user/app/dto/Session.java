package ru.hse.user.app.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class Session {

    private UUID id;
    private UUID user_id;
    private String token;
    private Timestamp expires;
}
