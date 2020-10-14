'''

You are to retrieve the following document using the HTTP protocol
in a way that you can examine the HTTP Response headers.

http://data.pr4e.org/intro-short.txt
'''
import socket

mysocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
mysocket.connect(('data.pr4e.org', 80))
cmd = 'GET http://data.pr4e.org/intro-short.txt HTTP/1.0\r\n\r\n'.encode()

mysocket.send(cmd)

while True:
    data = mysocket.recv(1024)
    if(len(data) < 1):
        break
    print(data.decode())
mysocket.close()
