-- 21. For every person in the person table with the first name of "George", 
--       list the number of movies they've been in--include all Georges, 
--       even those that have not appeared in any movies. 
--     Display the names in alphabetical order. (59 rows)
--     Name the count column 'num_of_movies'

SELECT person_name, COUNT(movie_id) AS num_of_movies FROM person 
LEFT JOIN movie_actor ON person_id = actor_id
WHERE person_name LIKE 'George %'
GROUP BY person_id
ORDER BY person_name;

-- We'll talk about this part later! ^.^
INSERT INTO collection (collection_name) VALUES ('Mary''s Bogus Collection');

SELECT collection_name, movie.title FROM collection AS c
FULL OUTER JOIN movie ON movie.collection_id = c.collection_id;


------------------------------------------------------
-- CRUD 
--  - Create:  INSERT  - Adds new things to the DB
--  - Read:    SELECT  - See things that are in the DB 
--  - Upate:   UPDATE  - Change values in a DB row
--  - Delete:  DELETE  - Removes things from the DB
------------------------------------------------------


-- INSERT
SELECT * FROM park;
-- Add Disneyland to the park table. (It was established on 7/17/1955, has an area of 0.78 square miles and does not offer camping.)
INSERT INTO park (park_name, date_established, area, has_camping) 
  VALUES ('Disneyland', '7/17/1955', 0.78, false); 

-- Add Disney World to the park table. (It was established on 10/01/1971, has an area of 40 square miles 
--     and does offer camping.)
INSERT INTO park (park_name, date_established, area, has_camping)
  VALUES ('Disney World', '10/01/1971', 40, true);

SELECT * FROM park WHERE park_name = 'Disney World';

-- Add Hawkins, IN (with a population of 30,000 and an area of 14.71 square miles) and 
-- Cicely, AK (with a popuation of 839 and an area of 4.39 square miles) to the city table.
SELECT * FROM city;

INSERT INTO city (city_name, state_abbreviation, population, area)
  VALUES ('Hawkins', 'IN', 30000, 14.71), 
         ('Cicely', 'AK', 839, 4.39);

-- Since Disneyland is in California (CA), add a record representing that to the park_state table.
-- Also Disney World in FL...
-- DL is 64 & DW is 65
SELECT * FROM park WHERE park_name IN ('Disneyland', 'Disney World');

INSERT INTO park_state (park_id, state_abbreviation) 
VALUES (64, 'CA'), (65, 'FL');

-- Select the 2 Disney parks and show which state (by name) they are in...
SELECT park_name, state_name FROM park
JOIN park_state AS ps ON ps.park_id = park.park_id
JOIN state ON state.state_abbreviation = ps.state_abbreviation
WHERE park_name IN ('Disneyland', 'Disney World');

-- UPDATE

-- Change the state nickname of Minnesota to "The Happiest Place on Earth."

-----------------------------------------------------------------------
-- WRITE A SELECT FOR THE EXACT THING(S) YOU WANT TO UPDATE OR DELETE 
-- __BEFORE__ YOU DO THE UPDATE OR DELETE STATEMENT!!!
-----------------------------------------------------------------------
SELECT * FROM state;
 WHERE state_abbreviation = 'MN';

UPDATE state SET state_nickname = 'The Happiest Place on Earth'
WHERE state_abbreviation = 'MN';

-- Increase the population of California by 1,000,000.
SELECT * FROM state WHERE state_abbreviation = 'CA';
UPDATE state SET population = population + 1000000 WHERE state_abbreviation = 'CA';

-- Change the capital of California to Anaheim.
SELECT * FROM city WHERE city_name = 'Anaheim';      -- SELECT here allows me to see the correct key to use later
SELECT * FROM state WHERE state_abbreviation = 'CA'; -- SELECT to bring back ONLY the thing to update/delete
-- Only really need a UPDATE to change the data, BUT we do a select first to make sure we have the WHERE correct
UPDATE state SET capital = 9 WHERE state_abbreviation = 'CA';

-- Change Minnesota's nickname back to "The Land of 10,000 Lakes"
UPDATE state SET state_nickname = 'The Land of 10,000 Lakes' WHERE state_abbreviation = 'MN';
SELECT * FROM state
 WHERE state_abbreviation = 'MN';
 
-- For CA: reduce the population by 1,000,000, and change the capital back to Sacramento.
UPDATE state SET population = population - 1000000 WHERE state_abbreviation = 'CA';
UPDATE state SET capital = 264 WHERE state_abbreviation = 'CA';

SELECT * FROM state WHERE state_abbreviation = 'CA';

-- DELETE

-- Delete Hawkins, IN from the city table.
SELECT * FROM city WHERE city_name = 'Hawkins' AND state_abbreviation = 'IN'; -- SELECT to bring back ONLY the thing to update/delete

-- Delete ALWAYS removes the whole row so no column names or * in the query
DELETE FROM city WHERE city_name = 'Hawkins' AND state_abbreviation = 'IN';

-- Delete all cities with a population of less than 1,000 people from the city table.
SELECT * FROM city WHERE population < 1000;
DELETE FROM city WHERE population < 1000;


-- REFERENTIAL INTEGRITY

-- Try adding a city to the city table with "XX" as the state abbreviation.
SELECT * FROM city;
INSERT INTO city (city_name, state_abbreviation, population, area)
VALUES ('Junk', 'XX', 0, 0);


-- Try deleting California from the state table.
SELECT * FROM state WHERE state_abbreviation = 'CA';
DELETE FROM state WHERE state_abbreviation = 'CA';

-- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.
SELECT * FROM park WHERE park_name = 'Disneyland';
DELETE FROM park WHERE park_name = 'Disneyland';

-- Remove from park_state first
SELECT * FROM park_state WHERE park_id = 64;
DELETE FROM park_state WHERE park_id = 64;

-- CONSTRAINTS

-- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its population or area.
INSERT INTO city (city_name, state_abbreviation) VALUES ('Smallville', 'KS');

-- DEFAULT constraint - if you don't specify a default constraint, the value will be null if not explicitly added
-- Try adding Smallville, KS again, specifying an area but not a population.
INSERT INTO city (city_name, state_abbreviation, area) VALUES ('Smallville', 'KS', 10);

-- Retrieve the new record to confirm it has been given a default, non-null value for population.
SELECT * FROM city WHERE city_name = 'Smallville';

-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" (which is already the nickname of Maine).
SELECT * FROM state WHERE state_abbreviation = 'CA';
UPDATE state SET state_nickname = 'Vacationland' WHERE state_abbreviation = 'CA';

-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" (which is not a valid census region).
SELECT * FROM state WHERE state_abbreviation = 'FL';
UPDATE state SET census_region = 'Southeast' WHERE state_abbreviation = 'FL';

-- TRANSACTIONS

-- Delete the record for Smallville, KS within a transaction.


-- Delete all of the records from the park_state table, but then "undo" the deletion by rolling back the transaction.


-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.


-- Demonstrate two different SQL connections trying to access the same table where one is inside of a transaction but hasn't committed yet.
