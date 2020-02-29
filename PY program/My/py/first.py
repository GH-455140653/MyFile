import random

print('------------the first program-----------------')
# 留意：从input内获取到的数据全为字符串，尽管你在外输入的是数字！！！
secret = random.randint(0, 100)##
# print(secret)
try:
    temp = int(input('请从0-100猜一个数字：'))
    num = 1
    while int(temp):
        if temp == secret:
            print("你真棒，猜对了!")
            print("本次猜测共用了{0}次。".format(num))
            break
        else:
            if temp > secret:
                num = num + 1
                temp = int(input("大了大了！\n请继续猜一个数字："))
            else:
                num = num + 1
                temp = int(input("小了小了！\n请继续猜一个数字："))
except:
    print("请正确输入数字！！！")
