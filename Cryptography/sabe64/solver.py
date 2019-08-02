from pwn import *
from string import printable
from random import choice

char = printable.strip()
tmp = ''.join(choice(char) for i in range(1000))
string = tmp.encode('base64').replace('\n','')

def kirim(isi):
	r.recvuntil(': ')
	r.sendline('ENCODE' + isi)
	return r.recvline().strip('\n')

cmpr = lambda x,y : dict(zip(x,y))
r = remote('127.0.0.1', 6000)
#r = process('python app.py')
flag = kirim('FLAG')
enc = kirim(' ' + tmp)
dic = cmpr(enc,string)

print ''.join(dic[i] for i in flag).decode('base64')