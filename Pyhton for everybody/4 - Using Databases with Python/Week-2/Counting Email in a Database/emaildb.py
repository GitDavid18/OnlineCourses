"""PROBLEM DESCRIPTION:
COUNTING ORGANIZATIONS
This application will read the mailbox data (mbox.txt) count up the number email
messages per organization (i.e. domain name of the email address) using a database
with the following schema to maintain the counts:
CREATE TABLE Counts (org TEXT, count INTEGER)
When you have run the program on mbox.txt upload the resulting database file 
above for grading. If you run the program multiple times in testing or with dfferent files, make
sure to empty out the data before each run.
You can use this code as a starting point for your application: 
http://www.pythonlearn.com/code/emaildb.py.
The data file for this application is the same as in previous assignments:
http://www.pythonlearn.com/code/mbox.txt.
Because the sample code is using an UPDATE statement and committing the results
to the database as each record is read in the loop, it might take as long as a 
Few minutes to process all the data. The commit insists on completely writing 
all the data to disk every time it is called.
The program can be speeded up greatly by moving the commit operation outside of
the loop. In any database program, there is a balance between the number of 
operations you execute between commits and the importance of not losing the 
results of operations that have not yet been committed. 
"""

"""PERSONAL COMMENTS:
As we can see, this exercise is identical as the email-counting database 
example that we've just seen, with the only difference that we have to count the
organizations and not the individual email adresses. However, we can use the 
code provided as example and only add a few modifications.
What we're going to do is, after getting the email, separate it using the .split()
method and taking into account that in an email address the separator is the "@"
symbol.
Besides, instead of reading directly a previously-downloaded mbox.txt file, we'll
obtain its information directly from internet, using urllib and the knowledge we 
got from the previous course. 
"""

import urllib.request, urllib.parse
import sqlite3
import re

# url not working 
url = ' http://www.py4e.com/code3/mbox.txt'
user_agent = 'Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.0.7) Gecko/2009021910 Firefox/3.0.7'
headers={'User-Agent':user_agent,} 
request = urllib.request.Request(url, None, headers)
uh = urllib.request.urlopen(request)
data = uh.read().decode()

# data = open('D:\Dokumente\Programming\OnlineCourses\Pyhton for everybody\Textfiles\mbox.txt')

conn = sqlite3.connect('D:\\Dokumente\\Programming\\OnlineCourses\\Pyhton for everybody\\4 - Using Databases with Python\\Week-2\\Counting Email in a Database\\emaildb.sqlite')
cur = conn.cursor()

cur.execute('DROP TABLE IF EXISTS Counts')

cur.execute('CREATE TABLE Counts (org TEXT, count INTEGER)')

# print(data)

data = data.rstrip()
# print ('==================================')

# print(data)

# print (type(data))

print('Writing to database')

for line in data.splitlines(True):
    # print(line)
    # line = line.rstrip()
    org = re.findall('From .*@([a-zA-Z.]+)', line)

    if len(org) < 1: continue
    # add org to database
    org = org[0]
    # print (org)

    cur.execute('SELECT count FROM Counts WHERE org = ?', (org,))
    row = cur.fetchone()

    if row is None:
        cur.execute('INSERT INTO Counts (org, count) VALUES (?,1)', (org,))
    else:
        cur.execute('UPDATE Counts SET count = count + 1 WHERE org = ?', (org,))
    
print('committing to database')
conn.commit()

sqlstr = 'SELECT org, count FROM Counts ORDER BY count DESC LIMIT 10'

for row in cur.execute(sqlstr):
    print(row[0], row[1])

cur.close()