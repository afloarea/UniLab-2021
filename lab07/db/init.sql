use db1

CREATE TABLE theatres (
    id varchar(255) NOT NULL,
    name varchar(255),
    city varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE plays (
    id varchar(255) NOT NULL,
    title varchar(255),
    genre varchar(255),
    duration varchar(255),
    theatre_id varchar(255),
    PRIMARY KEY (id),
    FOREIGN KEY (theatre_id) REFERENCES theatres(id)
);