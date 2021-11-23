DROP TABLE IF EXISTS song;

CREATE TABLE song (
 id SERIAL PRIMARY KEY,
 artist VARCHAR(80),
 title VARCHAR(80)
);

INSERT INTO song (artist, title) VALUES
('BTS', 'Permission to Dance'),
('Smashmouth', 'All Star'),
('Rebecca Black', 'Friday'),
('Rick Astley', 'Never Gonna Give You Up');
