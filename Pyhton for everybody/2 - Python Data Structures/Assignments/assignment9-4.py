# 9.4 Write a program to read through the mbox-short.txt and figure out who has the sent the greatest number of mail messages.
# The program looks for 'From ' lines and takes the second word of those lines as the person who sent the mail. The program creates a Python dictionary that maps the sender's mail address to a count of the number of times they appear in the file. After the dictionary is produced, the program reads through the dictionary using a maximum loop to find the most prolific committer.

path = input('Give path sir: ')

lines = open (path, 'r')

namecount = dict()

for line in lines:
    if line.startswith('From '):
        words = line.split()

        namecount[words[1]] = namecount.get(words[1], 0) + 1

# print (namecount)

maxVal = 0
maxKey = ''

for key, value in namecount.items():
    if value > maxVal:
        maxVal = value
        maxKey = key

print(maxKey, ': ', namecount[maxKey])