'''
Following Links in Python

In this assignment you will write a Python program that expands on http://www.pythonlearn.com/code/urllinks.py. The program will use urllib to read the HTML from the data files below, extract the href= vaues from the anchor tags, scan for a tag that is in a particular position relative to the first name in the list, follow that link and repeat the process a number of times and report the last name you find.

We provide two files for this assignment. One is a sample file where we give you the name for your testing and the other is the actual data you need to process for the assignment

Sample problem: Start at http://python-data.dr-chuck.net/known_by_Fikret.html 
Find the link at position 3 (the first name is 1). Follow that link. Repeat this process 4 times. The answer is the last name that you retrieve.
Sequence of names: Fikret Montgomery Mhairade Butchi Anayah 
Last name in sequence: Anayah
Actual problem: Start at: http://python-data.dr-chuck.net/known_by_Blanka.html 
Find the link at position 18 (the first name is 1). Follow that link. Repeat this process 7 times. The answer is the last name that you retrieve.
Hint: The first character of the name of the last page that you will load is: L
'''
import urllib.request, urllib.parse, urllib.error
from bs4 import BeautifulSoup
import re

# url = 'http://py4e-data.dr-chuck.net/known_by_Fikret.html'
url =  'http://py4e-data.dr-chuck.net/known_by_Amelia.html'
print (url)



pageCount = 0
while pageCount < 7:
    html = urllib.request.urlopen(url).read()
    soup = BeautifulSoup(html, 'html.parser')
    tags = soup('a')
    inPageCount = 0
    for tag in tags:
        inPageCount += 1
        print('tag: ', tag)
        if inPageCount == 18:
            url = tag.get('href', None)
            print ('\n new url: ',url)
    pageCount += 1

name = re.findall('http:\/\/py4e-data.dr-chuck.net\/known_by_([a-zA-Z]+).html', url)
print(name)
print (name[0])