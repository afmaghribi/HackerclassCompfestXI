from pwn import *

flag = ''
flag += p64(0x54534546504d4f43)
flag += p64(0x63697361627b3131)
flag += p64(0x6c626d657373615f)
flag += p64(0x7372657665725f79)
flag += p64(0x343332315f676e69)
flag += p64((0x1010101 ^ 0x7d35)^0x1010101)
print flag