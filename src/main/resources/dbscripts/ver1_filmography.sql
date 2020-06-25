CREATE SEQUENCE IF NOT EXISTS films_seq;
CREATE TABLE IF NOT EXISTS films (
    id      INTEGER NOT NULL PRIMARY KEY,
    title   VARCHAR(100),
    years   INTEGER,
    genre   VARCHAR(100),
    watched VARCHAR(100)
);

--------------------------------------------------------
--  Insert data
--------------------------------------------------------
INSERT INTO films (id, title, years, genre, watched)
       VALUES   (films_seq.nextval, 'film1', 2020, 'genre1', 'watched1'),
                (films_seq.nextval, 'film2', 2121, 'genre2', 'watched1'),
                (films_seq.nextval, 'film3', 2222, 'genre3', 'watched1'),
                (films_seq.nextval, 'film4', 2021, 'genre4', 'watched1');
COMMIT;