# Module 2 Review

## Getting Started

### Setup Database

Create a database called `module2_review`.
```
createdb -U postgres module2_review
```
Run the `database/databaseSetup.sql` file to initialize your database.

## Updated to get song lyrics

1. Added a LyricsService interface and implementation to use the REST API at
[lyrics.ovh](https://lyricsovh.docs.apiary.io/#reference/0/lyrics-of-a-song/search)
to bring back song lyrics. 

2. Updated the SongController to first get the song from the database & then get the lyrics from the service. 
   This is currently only done when getting a song by id.