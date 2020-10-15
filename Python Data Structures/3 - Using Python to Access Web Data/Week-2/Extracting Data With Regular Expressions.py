'''
In this assignment you will read through and parse a file with text and numbers.
You will extractall the numbers in the file and compute the sum of the numbers.
'''

import re
filename = input('File?')

lines = open (filename , 'r')

count = 0
sumUp = 0.0

for line in lines:
    # This only finds floats. If ints are wanted it is [0-9]+
    matches = re.findall('\s([0-9]+[.][0-9]+)\s', line)
    if len(matches) == 0: continue
    for match in matches:
        sumUp += float(match)
        count += 1
    # print (line, matches)
print('Sum: ', sumUp)
print('Count: ', count)
