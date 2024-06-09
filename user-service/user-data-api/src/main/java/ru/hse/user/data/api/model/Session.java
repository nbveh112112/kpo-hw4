package ru.hse.user.data.api.model;

import lombok.Data;
import java.util.UUID;
import java.sql.Timestamp;

@Data
public class Session {

    private UUID id;
    private UUID user_id;
    private String token;
    private Timestamp expires;
}
