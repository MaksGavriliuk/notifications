CREATE TABLE notifications
(
    id           BIGSERIAL PRIMARY KEY,
    type         VARCHAR(255) NOT NULL,
    text         TEXT         NOT NULL,
    created_at   DATE         NOT NULL,
    is_read      BOOLEAN      NOT NULL DEFAULT false,
    user_mail VARCHAR(255) NOT NULL
);