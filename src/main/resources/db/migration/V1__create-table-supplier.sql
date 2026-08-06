CREATE TABLE IF NOT EXISTS supplier (
    id INTEGER,
    name VARCHAR(40) NOT NULL,
    street VARCHAR(40) NOT NULL,
    city VARCHAR(20) NOT NULL,
    state CHAR(2) NOT NULL,
    zip CHAR(5),
    PRIMARY KEY (id)
);
