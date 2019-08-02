from string import printable
from pwn import *
from random import choice

#s = "abcdefghijklmnopqrstuvwxyz"
#payload = "".join(choice(s) for i in range(100))


while True:
	s = "abcdefghijklmnopqrstuvwxyz"
	payload = "".join(choice(s) for i in range(100))
	cek = choice(s)
	r = remote("152.118.201.254",18009)
	r.recvuntil("string: ")
	r.sendline(payload)
	r.recvuntil(": ")
	r.sendline(cek)
	print (r.recvline())