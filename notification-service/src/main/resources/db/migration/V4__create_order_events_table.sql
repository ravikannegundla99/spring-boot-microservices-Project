--create sequence order_event_id_seq start with 1 increment by 50;

CREATE SEQUENCE IF NOT EXISTS order_event_id_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS order_events
(
    id           BIGINT DEFAULT nextval('order_event_id_seq') NOT NULL,
    event_id     TEXT NOT NULL UNIQUE,
    created_at   TIMESTAMP NOT NULL,
    updated_at   TIMESTAMP,
    PRIMARY KEY (id)
);