from string import printable
from random import choice

char = printable.strip()
flag = open('flag.txt','r').read()
count = 2

while 1:
	print ''.join(choice(char) for i in range(100))
	if (count % 100000) == 1:
		print flag
	count += 1