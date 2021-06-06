import socket
import pykeyboard
from ahk import AHK
import time

ahk = AHK(executable_path="C:\\Program Files\\AutoHotkey\\AutoHotkey.exe")

serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
serversocket.bind(("192.168.0.7", 4004))
serversocket.listen(10) # become a server socket, maximum 10 connections

def exit_condition_reached():
    buf == "OffButtonA"
def wtf():
    if buf == "OnButtonW":
        print(buf)
        ahk.key_down('w')
    if buf == "OffButtonW":
        print(buf)
        ahk.key_up('w')
    if buf == "OnButtonS":
        print(buf)
        ahk.key_down('s')
    if buf == "OffButtonS":
        print(buf)
        ahk.key_up('s')
    if buf == "OnButtonA":
        print(buf)
        ahk.key_down('a')
    if buf == "OffButtonA":
        print(buf)
        ahk.key_up('a')
    if buf == "OnButtonD":
        print(buf)
        ahk.key_down('d')
    if buf == "OffButtonD":
        print(buf)
        ahk.key_up('d')
        
    if buf == "OnButtonUp":
        print(buf)
        ahk.key_down('Up')
    if buf == "OffButtonUp":
        print(buf)
        ahk.key_up('Up')
    if buf == "OnButtonDown":
        print(buf)
        ahk.key_down('Down')
    if buf == "OffButtonDown":
        print(buf)
        ahk.key_up('Down')
    if buf == "OnButtonLeft":
        print(buf)
        ahk.key_down('Left')
    if buf == "OffButtonLeft":
        print(buf)
        ahk.key_up('Left')
    if buf == "OnButtonRight":
        print(buf)
        ahk.key_down('Right')
    if buf == "OffButtonRight":
        print(buf)
        ahk.key_up('Right')
print("Start Server")
while True:
    connection, address = serversocket.accept()
    buf = connection.recv(64).decode()
    if len(buf) > 0:
        wtf()
    if exit_condition_reached():
        break

