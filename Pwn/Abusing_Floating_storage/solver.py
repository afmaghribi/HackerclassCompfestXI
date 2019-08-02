#! /usr/bin/python
#flag = COMPFEST11{1mportStructF0rTheWin}

from pwn import *
import struct


def float_to_hex(f):
	return str(struct.unpack("<I",struct.pack("<f",f))[0])

def main():
   #p = process("./a.out")
   r = remote("152.118.201.254",18015) 
   r.recvuntil("Clue: ")
   clued = float(r.recvline().decode())
   payload = float_to_hex(clued)
   r.recvuntil("anda:")
   r.sendline(payload)
   print (r.recvline())
   #1936311911

if __name__ == '__main__':
   main()
