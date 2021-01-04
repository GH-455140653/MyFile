# easygui的基本用法尝试
import easygui as eg

# eg.msgbox("hello world", '打招呼', '同意', image='../data/image/img_small.jpg')  # messagebox
# eg.egdemo()
#
# d=eg.ccbox('hello world','打招呼',['agree','disagree'],)#continue/cancel box
# print(d)#True/False
#
# d=eg.ynbox('hello world','打招呼')#yes/no box
# print(d)#True/False
#
# d=eg.buttonbox('hello world','打招呼',["ok","no","@#@#$$"])#button box
# print(d)#return parameters
#
# d=eg.indexbox('hello world','打招呼')#index box
# print(d)#return index form left to right(0,1,2,3,....)
#
# d=eg.boolbox('hello world','打招呼')#True/False box
# print(d)#return True/False
#
# d=eg.choicebox('what do you like best?','选择',['ooxx','69','观音坐莲'])
# print(d)#return boxlist what you choice/None
#
# d=eg.multchoicebox('what do you like best?','选择',['ooxx','69','观音坐莲'])
# print(d)#return the list of select/None
#
# d=eg.enterbox('please input something what you want to said:','输入框')
# print(d)#return what you input/None
#
# d=eg.integerbox('please input something what you want to said:','输入框',lowerbound=5,upperbound=10)
# print(d)#return the number between lowerbound to upperbound
#
# d=eg.multenterbox('lll','ppp',['a','b','c'])
# print(d)#return the list of what you input in de box/None
#
# d=eg.passwordbox('请输入你的密码:','密码')
# print(d)#return what you input/None
#
# d=eg.multpasswordbox('请输入你的账号和密码','密码',('用户名：','密码：'))
# print(d)#return None/the list of what you input
#
# file=open('../data/text/ls.txt',encoding='utf-8')#将文件按路径打开
# d=eg.textbox('你要打开的文件内容：','文件',file.read())#将文件在文本框中读出来
#
# d=eg.diropenbox(default='../../')#default设置默认打开路径，前提是该路径存在
# print(d)#return the file URL
#
# d=eg.fileopenbox(default=r'C:\Users\45514\Desktop\study\*',filetypes=['*.doc','*.docx'])#default是默认路径，filetypes设置选择文件类型
# print(d)#return the URL what you select
#
# d=eg.filesavebox()save the file in the URL what you select
# print(d)return URl
#
