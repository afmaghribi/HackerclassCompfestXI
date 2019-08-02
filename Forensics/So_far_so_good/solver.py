import zipfile
import os
import base64
count = 0
path = '/mnt/i/All_Of_Mine/Ctf/CTF_Yang_Ikut/Compfest11/Hackerclass/BankSOAL/Forensics/So_far_so_good'
folder =''
flag = ''
for i in range(150):
	pathnew = path + '/' + folder
	for file in os.listdir(pathnew):
		if '.zip' in file:
			zipp = zipfile.ZipFile(pathnew+'/'+file)
			flag += file[:1]
			zipp.extractall()
			folder = 'unzip'+str(count)
			os.rename(file[:1],folder)
			print "[+]Extracting =>",file
			count += 1
os.system('rm -rf '+path+'/unzip*')
print base64.b64decode(flag)