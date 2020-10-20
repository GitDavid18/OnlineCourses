"""
INSTRUCTIONS
This application will read roster data in JSON format, parse the file, and 
then produce an SQLite database that contains a User, Course, and Member 
table and populate the tables from the data file.
You can base your solution on this code: 
http://www.pythonlearn.com/code/roster.py - this code is incomplete as you
need to modify the program to store the role column in the Member table to
complete the assignment.
Each student gets their own file for the assignment. Download this file 
(https://pr4e.dr-chuck.com/tsugi/mod/sql-intro/roster_data.php?PHPSESSID=ac66d3b8dbd59e2dcfee8c24b15c25b9)
and save it as roster_data.json. Move the downloaded file into the same 
folder as your roster.py program.
Once you have made the necessary changes to the program and it has been run 
successfully reading the above JSON data, run the following SQL command:
SELECT hex(User.name || Course.title || Member.role ) AS X FROM 
    User JOIN Member JOIN Course 
    ON User.id = Member.user_id AND Member.course_id = Course.id
    ORDER BY X
Find the first row in the resulting record set and enter the long string that
looks like 53656C696E613333. 
"""
import sqlite3
import json

path = 'D:\\Dokumente\\Programming\\OnlineCourses\\Pyhton for everybody\\4 - Using Databases with Python\\Week-4\\'
dbfile = path + 'rosterdb.sqlite'
fname = path + 'roster_data.json'

data = open(fname).read()
info = json.loads(data)

conn = sqlite3.connect(dbfile)
cur = conn.cursor()

cur.executescript('''
    DROP TABLE IF EXISTS User;
    DROP TABLE IF EXISTS Course;
    DROP TABLE IF EXISTS Member; 
''')

cur.executescript('''
    CREATE TABLE User(
        id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
        name TEXT UNIQUE
    );

    CREATE TABLE Course(
        id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
        title TEXT UNIQUE
    );
    
    CREATE TABLE Member(
        id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
        user_id INTEGER,
        course_id INTEGER,
        role INTEGER
    )
''')

for person in info:
    name = person[0]
    cur.execute('INSERT OR IGNORE INTO User (name) VALUES (?)', (name, ))
    cur.execute('SELECT id FROM User WHERE name = ?', (name,))
    user_id = cur.fetchone()[0] 

    course = person[1]
    cur.execute('INSERT OR IGNORE INTO Course (title) VALUES (?)', (course, ))
    cur.execute('SELECT id FROM Course WHERE title = ?', (course,))
    course_id = cur.fetchone()[0] 

    role = person[2]
    cur.execute('INSERT OR IGNORE INTO Member (user_id, course_id, role) VALUES (?,?,?)', (user_id, course_id, role))

conn.commit()
cur.close()