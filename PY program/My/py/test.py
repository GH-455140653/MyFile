# 文件的分割与获取
import os
os.chdir(r"D:\MyData\MyProgram\PY program\My")
         
def save (name,work):
    name_file=open("./cash/names.txt",'a')
    work_file=open("./cash/works.txt",'a')
    name_file.writelines(name)
    work_file.writelines(work)
    name_file.close()
    work_file.close()

    
f=open("./data/text/ls.txt",'r',encoding='utf-8')
name=[]#中文
work=[]#英文
for each in f:
    (left,right)=each.split(':',1)
    work.append(left+'\n')
    name.append(right)
    save(name,work)
    name=[]
    work=[]
f.close()
