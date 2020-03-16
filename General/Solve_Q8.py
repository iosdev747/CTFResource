from socket import socket
from telnetlib import Telnet

sock = socket()
sock.connect(('hackthisfor.me', 4002))

s=str(sock.recv(1024))
a=eval(s[2:-3])
print(s)
print(a)
sock.send(str(a).encode())
s=str(sock.recv(1024))
print(s)