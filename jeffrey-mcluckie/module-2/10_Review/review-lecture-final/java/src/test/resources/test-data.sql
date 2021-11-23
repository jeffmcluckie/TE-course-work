-- Drop tables before load
DROP TABLE IF EXISTS hobby_person;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS hobby;

-- Transaction to create all tables & the test data together
-- or none of it at all
BEGIN TRANSACTION;

-- Create tables
CREATE TABLE person (
  id SERIAL,
  first_name VARCHAR(80) NOT NULL,
  last_name VARCHAR(80) NOT NULL,

  CONSTRAINT pk_person PRIMARY KEY (id)
);
CREATE TABLE hobby (
  id SERIAL,
  name VARCHAR(80) NOT NULL,

  CONSTRAINT pk_hobby PRIMARY KEY (id)
);
CREATE TABLE hobby_person (
  id SERIAL,
  hobby_id int NOT NULL,
  person_id int NOT NULL,
  rating int DEFAULT 0 CHECK (rating <=5),

  CONSTRAINT pk_hobby_person PRIMARY KEY (id),
  CONSTRAINT fk_hobby FOREIGN KEY (hobby_id) REFERENCES hobby(id),
  CONSTRAINT fk_person FOREIGN KEY (person_id) REFERENCES person(id)
);

-- INSERT test people
INSERT INTO person (first_name, last_name) VALUES
('Mary', 'Mosman'), -- id 1
('Ryan', 'Fox'),    -- id 2
('Thwin', 'Zan');   -- id 3

-- INSERT test hobbies
INSERT INTO hobby (name) VALUES
('Anime Watching'),  -- id 1
('Dance'),           -- id 2
('Video Games'),     -- id 3
('Wine'),            -- id 4
('Playing Guitar'),  -- id 5
('Movie Watching');  -- id 6

-- INSERT person-hobby ratings
INSERT INTO hobby_person (person_id, hobby_id, rating) VALUES
(1, 1, 5), -- Mary/Anime 5
(2, 1, 4), -- Ryan/Anime 5
(3, 1, 4), -- Thwin/Anime 5
(1, 2, 1), -- Mary/Dance 1
(2, 3, 4), -- Ryan/Games 4
(2, 4, 4), -- Ryan/Wine 5
(3, 5, 3), -- Thwin/Guitar 3
(3, 6, 4); -- Thwing/Movies 4

COMMIT;