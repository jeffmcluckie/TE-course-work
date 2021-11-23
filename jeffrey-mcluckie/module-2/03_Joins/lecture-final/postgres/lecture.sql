---------------------------------
-- Review question from Day 2 HW
---------------------------------
-- 20. The state abbreviation, and population of the largest city (name column 'city_population') of all states, territories, 
--     and districts.
-- Order the results from highest to lowest populations.
-- (56 rows)
SELECT state_abbreviation, MAX(population) AS city_population FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

---------------------------------------------------------------------------------
-- New stuff
---------------------------------------------------------------------------------
SELECT * FROM city WHERE state_abbreviation IN ('TX', 'OH', 'NY', 'NM') ORDER BY state_abbreviation;
SELECT * FROM state WHERE state_abbreviation IN ('TX', 'OH', 'NY', 'NM');
SELECT * FROM state WHERE state_abbreviation = 'NM';

-- INNER JOIN

SELECT * FROM state 
JOIN city ON state.capital = city.city_id
WHERE state.state_abbreviation = 'NM';

-- Can go either way with this example...
-- Starting from city table instead of state (above)
SELECT * FROM city
JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE state.state_abbreviation = 'NM';


-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT city_name, state_abbreviation FROM city
WHERE city_name = 'Columbus';

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT city_name, state_name FROM city
JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE city_name = 'Columbus';

-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT park_name, state_abbreviation FROM park
JOIN park_state ON park.park_id = park_state.park_id;

-- We can alias table names too! Woot?
SELECT park_name, state_abbreviation FROM park AS p
JOIN park_state AS ps ON p.park_id = ps.park_id;


-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT park_name, state_name FROM park
JOIN park_state ON park.park_id = park_state.park_id
JOIN state ON park_state.state_abbreviation = state.state_abbreviation
ORDER BY park_name;

-- Modify the previous query to include the name of the state's capital city.
SELECT park_name, state_name, city_name AS state_capital FROM park
JOIN park_state ON park.park_id = park_state.park_id
JOIN state ON park_state.state_abbreviation = state.state_abbreviation
JOIN city ON city_id = capital
ORDER BY park_name;

-- Modify the previous query to include the area of each park.
SELECT park_name, state_name, city_name AS state_capital, park.area FROM park
JOIN park_state ON park.park_id = park_state.park_id
JOIN state ON park_state.state_abbreviation = state.state_abbreviation
JOIN city ON city_id = capital
ORDER BY park_name;

-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT city_name, city.population FROM city
JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE state.census_region = 'Midwest';

-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT state.state_name, COUNT(city_name) FROM city
JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE state.census_region = 'Midwest'
GROUP BY state_name;

-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT state.state_name, COUNT(city_name) AS city_count FROM city
JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE state.census_region = 'Midwest'
GROUP BY state_name
ORDER BY city_count DESC;


-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) 
-- for every record in the state table that has park records associated with it. -- 32 rows
SELECT state.state_name, MIN(park.date_established) FROM state
JOIN park_state AS ps ON state.state_abbreviation = ps.state_abbreviation
JOIN park ON park.park_id = ps.park_id
GROUP BY state_name
ORDER BY state_name;

-- Modify the previous query so the results include entries for all the records in the state table, 
-- even if they have no park records associated with them.
SELECT state.state_name, MIN(park.date_established) FROM state
LEFT JOIN park_state AS ps ON state.state_abbreviation = ps.state_abbreviation
LEFT JOIN park ON park.park_id = ps.park_id
GROUP BY state_name
ORDER BY state_name;

-- Which states don't have parks?
-- Modify the previous query so the results include entries for all the records in the state table, 
-- even if they have no park records associated with them.
SELECT state.state_name, MIN(park.date_established) AS earliest_park_established FROM state
LEFT JOIN park_state AS ps ON state.state_abbreviation = ps.state_abbreviation
LEFT JOIN park ON park.park_id = ps.park_id
WHERE ps.state_abbreviation IS NULL
GROUP BY state_name
ORDER BY state_name;


-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. (Washington is the name of a city and a state--how many times does it appear in the results?)


-- Modify the previous query to include a column that indicates whether the place is a city or state.



-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in DbVisualizer and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres


-- The titles of all the Comedy movies

