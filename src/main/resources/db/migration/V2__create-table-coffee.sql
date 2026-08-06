CREATE TABLE IF NOT EXISTS coffee (
    name VARCHAR(32) NOT NULL,
    sup_id INT NOT NULL,
    price NUMERIC(10,2) NOT NULL,
    sales INTEGER NOT NULL,
    total INTEGER NOT NULL,
    PRIMARY KEY (name),
    FOREIGN KEY (sup_id) REFERENCES supplier (id)
);