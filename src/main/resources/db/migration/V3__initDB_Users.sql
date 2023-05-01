CREATE TABLE users (
    username VARCHAR(100) PRIMARY KEY NOT NULL,
    password VARCHAR(64) NOT NULL,
    authority VARCHAR(45) NOT NULL,
    enabled Boolean DEFAULT true
);

INSERT INTO
    users (username, password, authority)
VALUES
    (
        'user',
        '$2a$12$HISqeN/6Jpr5uwruPBco7eeV28glFl618wX7RW23xKqG4h.ucXTJq',
        'ROLE_USER'
    ),
    (
        'admin',
        '$2a$12$HISqeN/6Jpr5uwruPBco7eeV28glFl618wX7RW23xKqG4h.ucXTJq',
        'ROLE_ADMIN'
    );