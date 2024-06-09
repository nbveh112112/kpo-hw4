package ru.hse.order.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private UUID id;
    private UUID user_id;
    private UUID from_station_id;
    private UUID to_station_id;
    private Timestamp created;
    private int status;
}
