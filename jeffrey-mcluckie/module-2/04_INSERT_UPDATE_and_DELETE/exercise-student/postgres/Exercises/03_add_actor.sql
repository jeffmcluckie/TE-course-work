-- 3. Did you know Eric Stoltz was originally cast as Marty McFly in "Back to the Future"? Add Eric Stoltz to the list of actors for "Back to the Future" (1 row)
SELECT movie_actor.movie_id, actor_id, person_name FROM movie
JOIN movie_actor ON movie_actor.movie_id = movie.movie_id
JOIN person ON person.person_id = movie_actor.actor_id
WHERE title = 'Back to the Future';
SELECT person_id FROM person WHERE person_name = 'Eric Stoltz';
SELECT * FROM movie_actor;
INSERT INTO movie_actor(movie_id, actor_id)
VALUES(105, 7036);
