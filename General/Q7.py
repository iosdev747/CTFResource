#!/usr/bin/env python3
import socket
import _thread
import random

HOST = '127.0.0.1'
PORT = 3334

def on_new_client(clientsocket,addr):
    try:
        a=random.randrange(1000000,10000000)
        b=random.randrange(1000000,10000000)
        c=random.randrange(1000000,10000000)
        eq = str(a)+'-'+str(b)+'+'+str(c)+'\n'
        clientsocket.sendall(eq.encode())
        #clientsocket.settimeout(0.5)
        msg = clientsocket.recv(1024)
        print(addr, ' >> ', msg)
        if int(eval(eq))==int(msg):
            msg = 'Flag{!_Kn0W_M4THS_LOL}'
            #msg = 'Flag{WOW_What_4_Sp33D}'
        else:
            msg = 'Wrong answer, Learn basic maths'
        clientsocket.sendall(msg.encode())
    except socket.timeout:
        msg = 'Too Slow .....'
        clientsocket.sendall(msg.encode())
    except:
        msg = 'I want an integer not garbage'
        clientsocket.sendall(msg.encode())
    finally:
        clientsocket.close()

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    try:
        s.bind((HOST, PORT))
    except:
        print("Error binding port to "+Host+str(PORT))
        exit(0);
    s.listen()
    while True:
        conn, addr = s.accept()
        _thread.start_new_thread(on_new_client,(conn,addr))