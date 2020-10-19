"""
10.2 Write a program to read through the mbox-short.txt and
figure out the distribution by hour of the day for each of the messages.
You can pull the hour out from the 'From ' line by finding the time
and then splitting the string a second time using a colon.
From stephen.marquard@uct.ac.za Sat Jan  5 09:14:16 2008
Once you have accumulated the counts for each hour, print out the counts,
sorted by hour as shown below. Note that the autograder
does not have support for the sorted() function.
"""

path = input('Give path sir: ')

lines = open (path, 'r')

wordcount = dict()

for line in lines:
    if line.startswith('From '):
        words = line.split()
        hour = words[5].split(':')
        wordcount[hour[0]] =  wordcount.get(hour[0], 0) + 1

wordList = list()

for key, value in wordcount.items():
    newTup = (value, key)
    wordList.append(newTup)

wordList.sort(reverse=True)

for val, key in wordList:
    print (key, val)
