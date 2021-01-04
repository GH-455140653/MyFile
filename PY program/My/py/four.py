# 运用pickle对文件进行存储和读取
import os
import pickle


def dataSave(data):
    ##文件写入
    os.chdir(r"C:\MyData\MyProgram\PY program\My")
    # my_list=list(data)
    # my_file=open('./cash/my_file.txt','wb')
    with open('./cash/my_file.txt', 'wb') as my_file:
        pickle.dump(data, my_file)
    # my_file.close()


def dataOutPut():
    ##文件读取
    # pickle_file=open('./cash/my_file.txt','rb')
    with open('./cash/my_file.txt', 'rb') as pickle_file:
        theWbContent = pickle.load(pickle_file)
        print(theWbContent)


data = input("请输入你要储存的数据:")
dataSave(data)
reg = input("请问你要打印你的数据吗？\n[y/n]")
while reg:
    if reg == str('y'):
        dataOutPut()
        break
    elif reg == 'n':
        print('程序已经退出！')
        break
    else:
        reg = input("请正确输入提示符号！\n[y/n]")
