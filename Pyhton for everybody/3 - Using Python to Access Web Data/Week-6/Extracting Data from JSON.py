'''
In this assignment you will write a Python program somewhat similar to http://www.pythonlearn.com/code/json2.py. The program will prompt for a URL, read the JSON data from that URL using urllib and then parse and extract the comment counts from the JSON data, compute the sum of the numbers in the file and enter the sum below:
We provide two files for this assignment. One is a sample file where we give you the sum for your testing and the other is the actual data you need to process for the assignment.

Sample data: http://python-data.dr-chuck.net/comments_42.json (Sum=2553)
Actual data: http://python-data.dr-chuck.net/comments_353540.json (Sum ends with 71)
You do not need to save these files to your folder since your program will read the data directly from the URL. Note: Each student will have a distinct data url for the assignment - so only use your own data url for analysis.
'''
import json
import urllib.parse, urllib.request, urllib.error

url = input ('Give url: ')

uh = urllib.request.urlopen(url)
data = uh.read().decode()
info = json.loads(data)

overall = 0

for person in info['comments']:
    overall += int(person['count'])

print (overall)


# serviceurl = 'http://maps.googleapis.com/maps/api/geocode/json?'
# address = input('Enter location: ')

# url = serviceurl + urllib.parse.urlencode({'address': address})
# print ('url done')

# uh = urllib.request.urlopen(url)
# data = uh.read().decode()

# print(data)

# data = '''{
#     "name" : "Chuck",
#     "phone": {
#         "type" : "intl",
#         "number" : "+1 734 303 4456"
#     },
#     "email" : {
#         "hide" : "yes"
#     }
# }'''

# data = [ "Glenn", "Sally", "Jen" ]

# info = json.loads(data)
# print (data)
# print ('Name:', info['name'])
# print('phone:', info['phone'])
# print('email', info ['email'])