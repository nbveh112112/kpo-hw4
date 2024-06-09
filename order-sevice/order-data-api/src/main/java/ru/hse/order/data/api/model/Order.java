package ru.hse.order.data.api.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class Order {
    private UUID id;
    private UUID user_id;
    private UUID from_station_id;
    private UUID to_station_id;
    private Timestamp created;
    private int status;
}
