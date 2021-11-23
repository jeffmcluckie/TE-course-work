-- ORDERING RESULTS

-- Get all parks & sort by date
SELECT * FROM park ORDER BY date_established;

-- Populations of all states from sorted by population 
-- default is "natural order" which is smallest to largest.
SELECT * FROM state ORDER BY population;
SELECT * FROM state ORDER BY population ASC; -- ASC is the default for numbers so not required

-- Populations of all states from largest to smallest.
SELECT * FROM state ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. 
-- The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT * FROM state ORDER BY census_region DESC, state_name;

-- City's sorted by population in descending order (largest first) 
-- grouped up by state. I wanna see which city is biggest within each state.
SELECT * FROM city ORDER BY state_abbreviation, population DESC;


-- The biggest parks by area
SELECT * FROM park ORDER BY area DESC;


-- LIMITING RESULTS

-- Single biggest park
-- LIMIT is used to limit the number of rows returned
SELECT * FROM park ORDER BY area DESC LIMIT 1;

-- The 10 largest cities by populations
SELECT * FROM city ORDER BY population DESC LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
-- Not technically getting the "age" just using the date to sort
SELECT park_name, date_established FROM park ORDER BY date_established ASC, park_name ASC LIMIT 20;

-- Can get CURRENT_DATE (date) or CURRENT_TIMESTAMP (date & time)
SELECT park_name, date_established, (CURRENT_DATE - date_established) / 365 AS age
FROM park ORDER BY date_established ASC, park_name ASC LIMIT 20;



-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT city_name || ', ' || state_abbreviation AS city_state FROM city;

-- The all parks by name and date established.


-- The census region and state name of all states in the West & Midwest sorted in ascending order.



-- AGGREGATE FUNCTIONS

-----------------------------------------------------------------
-- All these queries are looking for a single number as a result
-----------------------------------------------------------------

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS average_state_population FROM state;

-- Total population in the West and South census regions
SELECT * FROM state;
SELECT SUM(population) AS total_population FROM state WHERE census_region = 'West' OR census_region = 'South';

-- The number of cities with populations greater than 1 million
-- First select all the rows you want...
SELECT * FROM city WHERE population > 1000000;
-- THEN do your aggregate function - this helps you to see if you get the right result
SELECT COUNT(*) FROM city WHERE population > 1000000;

-- The number of state nicknames.


-- The area of the smallest and largest parks.



-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT COUNT(city_name), state_abbreviation FROM city GROUP BY state_abbreviation ORDER BY state_abbreviation;

-- Do some aggregates w/ group by's for parks! WOOT!
SELECT * from park;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT * from park ORDER BY has_camping;
SELECT AVG(area), has_camping FROM park GROUP BY has_camping;

-- Show the sum of the park area that allows camping & doesn't allow camping.
SELECT SUM(area), has_camping FROM park GROUP BY has_camping;

-- Show the count of parks that allow camping & don't allow camping.
SELECT COUNT(*), has_camping FROM park GROUP BY has_camping;



-- Sum of the population of cities in each state ordered by state abbreviation.


-- The smallest city population in each state ordered by city population.
SELECT MIN(population) AS min_population, state_abbreviation FROM city 
GROUP BY state_abbreviation
ORDER BY state_abbreviation, min_population;


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)



-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,


-- Include the names of the smallest and largest parks


-- List the capital cities for the states in the Northeast census region.

