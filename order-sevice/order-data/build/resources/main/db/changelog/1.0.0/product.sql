--liquibase formatted sql

--changeset Timur:stations
create table stations
(
    id   uuid primary key,
    name varchar(255) not null
);
--rollback drop table stations;

--changeset Timur:orders
create table orders
(
    id           uuid primary key,
    owner_id     uuid,
    from_station_id uuid references stations(id),
    to_station_id uuid references stations(id),
    status      integer,
    created_at timestamp
);
--rollback drop table product;




