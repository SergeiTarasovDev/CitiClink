--liquibase formatted sql

--changeset starasov:1
CREATE TABLE PUBLIC.ctl_product
(
    id              bigint auto_increment primary key,
    type_id         bigint,
    name            varchar(70),
    serias_number   varchar(30),
    vendor_id       bigint,
    price           numeric,
    stock           int
);

CREATE TABLE ctl_product_type
(
    id              bigint auto_increment primary key,
    type            varchar(20)
);

CREATE TABLE ctl_vendor
(
    id              bigint auto_increment primary key,
    name            varchar(40)
);

CREATE TABLE ctl_additional_option
(
    id              bigint auto_increment primary key,
    name            varchar(30),
    type_id         bigint
);

CREATE TABLE ctl_product_option
(
    id              bigint auto_increment primary key,
    product_id      bigint,
    option_id       bigint
);