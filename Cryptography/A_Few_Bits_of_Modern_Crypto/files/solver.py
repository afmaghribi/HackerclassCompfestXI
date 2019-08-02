import base64
from itertools import cycle

def decrypt(encrypted, passphrase):
    ciphertext = base64.b64decode(encrypted)
    return "".join(chr(a^b) for a, b in zip(ciphertext, cycle(passphrase.encode())))

great = open("greeting.txt","rb").read()
cipher = open("greeting_encrypted.txt","rb").read()
cipher = bytes(base64.b64decode(cipher))

dic = zip(great,cipher)
key = "".join(chr(a^b) for a,b in dic)
flag = open("flag_encrypted.txt","r").read()
print (decrypt(flag,key))