# 运用easygui实现简单的账号密码表单
import easygui as eg

msg = "请填写以下联系方式"
title = "账号中心"
fieldNames = ['*用户名', '*真实姓名', '固定电话', '手机号码', 'QQ', '*email']
fieldValues = []
fieldValues = eg.multenterbox(msg, title, fieldNames)
while 1:
    if fieldValues is None:
        break
    errmsg = ""
    for i in range(len(fieldNames)):
        option = fieldNames[i].strip()
        if fieldValues[i].strip() == "" and option[0] == "*":
            errmsg += ('【%s】为必填项。\n\n' % fieldNames[i])
    if errmsg == "":
        break
    fieldValues = eg.multenterbox(errmsg, title, fieldNames, fieldValues)
print("用户资料如下：%s" % str(fieldValues))
x = input("按任意键结束")
