CREATE TABLE person
(
    id            UUID         NOT NULL PRIMARY KEY,
    first_name    VARCHAR(100) NOT NULL,
    second_name   VARCHAR(100) NOT NULL,
    email_address VARCHAR(100) NOT NULL,
    mobile_number VARCHAR(100) NOT NULL
)