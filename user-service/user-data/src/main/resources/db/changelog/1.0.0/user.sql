--liquibase formatted sql

--changeset Timur:sessions
create table sessions
(
    id          uuid primary key,
    user_id     uuid,
    token       varchar(255) not null unique,
    expires_at  timestamp
);
--rollback drop table sessions;

--changeset Timur:users
create table users
(
    id           uuid primary key,
    name         varchar(255) not null unique,
    email        varchar(255) not null unique,
    password     varchar(255) not null,
    created_at   timestamp
);
--rollback drop table user;

--changeset Timur:admin
insert into users (id, name, email, password, created_at)
values ('f9e2c6f0-4f8c-4f5a-9d2d-0e3f5b4c5d6e', 'admin', '123@example.com', 'admin', '2022-10-10 10:10:10');
--rollback delete from users where id = 'f9e2c6f0-4f8c-4f5a-9d2d-0e3f5b4c5d6e';



