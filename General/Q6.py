#!/usr/bin/env python3
import socket
import _thread

HOST = '127.0.0.1'
PORT = 3333

def on_new_client(clientsocket,addr):
    #msg = clientsocket.recv(1024)
    #print(addr, ' >> ', msg)
    msg = 'Flag{I_L34RN3D_n3TC4T}'
    clientsocket.sendall(msg.encode())
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