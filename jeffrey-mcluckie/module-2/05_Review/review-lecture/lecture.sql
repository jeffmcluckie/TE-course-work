----------------------------------------
-- Review HW 7
----------------------------------------

-- 7. Remove the actor appearances in "Avengers: Infinity War" (14 rows)
-- Note: Don't remove the actors themeselves, just make it so it seems no one appeared in the movie.

-- Start by getting the movie info (want to see columns to do join)
SELECT * FROM movie WHERE title = 'Avengers: Infinity War';

-- Get all the actor's (id's) from infinity war
-- Need to join movie & movie_actor
SELECT * FROM movie_actor 
JOIN movie ON movie.movie_id = movie_actor.movie_id
WHERE title = 'Avengers: Infinity War';

-- INSERT a duplicate movie_actor row
-- Can't do this because the key to the table is both the movie_id and actor_id combined
-- Keys must be unique, so fails
-- INSERT INTO movie_actor (movie_id, actor_id) VALUES (299536, 3223);

-- Can't just set the actor_id to null, because it is part of a key
-- UPDATE movie_actor SET actor_id = NULL WHERE movie_id = 299536;

-- Need to delete the rows here from the movie actor table instead
DELETE FROM movie_actor WHERE movie_id = 299536;

-- Using a subquery to get the id
DELETE FROM movie_actor WHERE movie_id = (SELECT movie_id FROM movie WHERE title = 'Avengers: Infinity War');

------------------------------------------------------------
-- Extra topics from earlier in the week
-- __ You may need to switch database connections __
------------------------------------------------------------

-- From Tuesday 02_Aggregates (missing lecture stuff)
-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT COUNT(city_name), state_name FROM city 
JOIN state ON state.state_abbreviation = city.state_abbreviation
GROUP BY state_name
ORDER BY state_name;

-- Original query w/ state abbreviation
SELECT COUNT(city_name), state_abbreviation FROM city GROUP BY state_abbreviation ORDER BY state_abbreviation;


-- Using a subquery to do the same thing
SELECT COUNT(city_name), 
  (
    SELECT state_name FROM state WHERE state.state_abbreviation = city.state_abbreviation
   ) 
FROM city GROUP BY state_abbreviation ORDER BY state_abbreviation;


-- 12. Create a "Bill Murray Collection" in the collection table. 
-- For the movies that have Bill Murray in them, set their collection ID to the "Bill Murray Collection". (1 row, 6 rows)
SELECT * FROM collection;
INSERT INTO collection (collection_name) VALUES ('Bill Murray Collection');

-- Select to see the stuff first
SELECT movie.title, person_name, movie.collection_id FROM movie 
JOIN movie_actor ON movie.movie_id = movie_actor.movie_id
JOIN person ON movie_actor.actor_id = person.person_id
WHERE person_name = 'Bill Murray';

-- Subquery to get the collection id
(SELECT collection_id FROM collection WHERE collection_name = 'Bill Murray Collection')

-- Subquery to get the movie ids for the movies w/ Bill Murray
SELECT movie_id FROM movie_actor 
JOIN person ON movie_actor.actor_id = person.person_id
WHERE person_name = 'Bill Murray';

UPDATE movie SET collection_id  = (SELECT collection_id FROM collection WHERE collection_name = 'Bill Murray Collection')
WHERE movie_id IN 
  (
     SELECT movie_id FROM movie_actor 
     JOIN person ON movie_actor.actor_id = person.person_id
     WHERE person_name = 'Bill Murray'
  );


-- TRANSACTIONS

-- General transaction format
BEGIN; -- Starts a transaction
-- START TRANSACTION; -- ALSO starts...
-- BEGIN TRANSACTION; -- Yet another way to start

-- Do your things - whatever you need to do (adding rows, updating, deleting, etc)

ROLLBACK; -- Undo your changes
COMMIT;   -- Save your changes

-- Delete the record for Smallville, KS within a transaction.

-- Select first to make sure query is correct
SELECT * FROM city WHERE city_name = 'Smallville';

BEGIN;
DELETE FROM city WHERE city_name = 'Smallville';

ROLLBACK; -- Undo

-- Try again and make it stick!
BEGIN;
DELETE FROM city WHERE city_name = 'Smallville';
COMMIT; -- Finalize


-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. 
-- (Washington is the name of a city and a state--how many times does it appear in the results?)

SELECT city_name as place_name FROM city WHERE city_name LIKE 'W%'
UNION
SELECT state_name  FROM state WHERE state_name LIKE 'W%'
ORDER BY place_name;


-- Modify the previous query to include a column that indicates whether the place is a city or state.



