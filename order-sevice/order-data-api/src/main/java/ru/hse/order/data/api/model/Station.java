package ru.hse.order.data.api.model;

import lombok.Data;
import java.util.UUID;

@Data
public class Station {

    private UUID id;
    private String name;
}
