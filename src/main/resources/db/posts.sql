create table posts (
    id SERIAL PRIMARY KEY,
    title varchar(255) NOT NULL,
    body varchar(255) NOT NULL,
    date date
);