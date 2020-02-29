import pickle
import easygui as eg


def dataSave(myData):
    eg.msgbox('请选择你要存储的磁盘位置：', '提示', )
    file_url = eg.filesavebox(default='../cash/my_file', filetypes=['*.txt', '*.docx'])
    with open(file_url, 'wb') as my_file:
        pickle.dump(myData, my_file)
    return file_url


def dataOutPut(myurl):
    with open(myurl, 'rb') as pickle_file:
        theWbContent = pickle.load(pickle_file)
        print(theWbContent)


data = input('请输入你要存储的数据：')
myUrl = dataSave(data)
reg = input("请问你要打印你的数据吗？\n[y/n]")
while reg:
    if reg == str('y'):
        dataOutPut(myUrl)
        break
    elif reg == 'n':
        print('程序已经退出！')
        break
    else:
        reg = input("请正确输入提示符号！\n[y/n]")
