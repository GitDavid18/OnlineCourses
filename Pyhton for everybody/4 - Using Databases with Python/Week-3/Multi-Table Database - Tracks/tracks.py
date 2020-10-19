"""Musical Track Database
This application will read an iTunes export file in XML and produce a properly 
normalized database with this structure:
CREATE TABLE Artist (
    id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
    name    TEXT UNIQUE
);
CREATE TABLE Genre (
    id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
    name    TEXT UNIQUE
);
CREATE TABLE Album (
    id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
    artist_id  INTEGER,
    title   TEXT UNIQUE
);
CREATE TABLE Track (
    id  INTEGER NOT NULL PRIMARY KEY 
        AUTOINCREMENT UNIQUE,
    title TEXT  UNIQUE,
    album_id  INTEGER,
    genre_id  INTEGER,
    len INTEGER, rating INTEGER, count INTEGER
);
If you run the program multiple times in testing or with different files, make
sure to empty out the data before each run.
You can use this code as a starting point for your application: 
http://www.pythonlearn.com/code/tracks.zip. The ZIP file contains the Library.xml
file to be used for this assignment. You can export your own tracks from iTunes
and create a database, but for the database that you turn in for this assignment,
only use the Library.xml data that is provided.
To grade this assignment, the program will run a query like this on your uploaded
database and look for the data it expects to see:
SELECT Track.title, Artist.name, Album.title, Genre.name 
    FROM Track JOIN Genre JOIN Album JOIN Artist 
    ON Track.genre_id = Genre.ID and Track.album_id = Album.id 
        AND Album.artist_id = Artist.id
    ORDER BY Artist.name LIMIT 3
The expected result of this query on your database is:
Track   Artist  Album   Genre
Chase the Ace   AC/DC   Who Made Who    Rock
D.T.    AC/DC   Who Made Who    Rock
For Those About To Rock (We Salute You) AC/DC   Who Made Who    Rock
"""

import sqlite3
import xml.etree.ElementTree as ET

def lookup(d, key):
    found = False
    for child in d:
        if found : return child.text
        if child.tag == 'key' and child.text == key :
            found = True
    return None

# file paths
path = 'D:\\Dokumente\\Programming\\OnlineCourses\\Pyhton for everybody\\4 - Using Databases with Python\\Week-3\\Multi-Table Database - Tracks\\'
dbLoc = path + 'trackdb.sqlite'
xmlLoc = path + 'Library.xml'

conn = sqlite3.connect(dbLoc)
cur = conn.cursor()

cur.executescript(''' DROP TABLE IF EXISTS Artist;
                DROP TABLE IF EXISTS Genre;
                DROP TABLE IF EXISTS Album;
                DROP TABLE IF EXISTS Track;
''')

cur.executescript('''CREATE TABLE Artist (
                id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
                name    TEXT UNIQUE
            );
            CREATE TABLE Genre (
                id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
                name    TEXT UNIQUE
            );
            CREATE TABLE Album (
                id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
                artist_id  INTEGER,
                title   TEXT UNIQUE
            );
            CREATE TABLE Track (
                id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
                title TEXT  UNIQUE,
                album_id  INTEGER,
                genre_id  INTEGER,
                len INTEGER,
                rating INTEGER,
                count INTEGER
            );
''')

tree = ET.parse(xmlLoc)

allTracks = tree.findall('dict/dict/dict')
print (len(allTracks))

for entry in allTracks:
    if (lookup(entry, 'Track ID') is None): continue

    name = (lookup(entry, 'Name'))
    artist = (lookup(entry, 'Artist'))
    album = (lookup(entry, 'Album'))
    genre = (lookup(entry, 'Genre'))
    length = lookup(entry, 'Total Time')
    rating = lookup(entry, 'Rating')
    count = lookup(entry, 'Play Count')

    if name is None or artist is None or album is None or genre is None: continue
    print(name,', ', artist, ', ', genre, ', ', album)
    
    # add song to db
    cur.execute('INSERT OR IGNORE INTO Artist (name) VALUES (?)',(artist,) )
    cur.execute('SELECT id FROM Artist WHERE name = ?', (artist,))
    artist_id = cur.fetchone()[0] 

    cur.execute('INSERT OR IGNORE INTO Genre (name) VALUES (?)',(genre,) )
    cur.execute('SELECT id FROM Genre WHERE name = ?', (genre,))
    genre_id = cur.fetchone()[0]

    cur.execute('INSERT OR IGNORE INTO Album (title, artist_id) VALUES (?,?)', (album, artist_id))
    cur.execute('SELECT id FROM Album WHERE title = ?', (album,))
    album_id = cur.fetchone()[0]

    cur.execute('INSERT OR REPLACE INTO Track (title, album_id, genre_id, len, rating, count) VALUES (?,?,?,?,?,?)', (name, album_id, genre_id, length, rating, count))


conn.commit()

cur.execute('''SELECT Track.title, Artist.name, Album.title, Genre.name 
    FROM Track JOIN Genre JOIN Album JOIN Artist 
    ON Track.genre_id = Genre.ID and Track.album_id = Album.id 
        AND Album.artist_id = Artist.id
    ORDER BY Artist.name LIMIT 3''')
res = cur.fetchall()
print (res)

cur.close()
