from random import randint

# ex1_1
# str = input('请输入数字：')
# print(sum(map(int, str)))

# ex1_2
# def fee(income, num):
#     pre = 800 + (income - 800) * 0.8
#     last = num * 800;
#     if income <= last:
#         return (income, income - pre)
#     else:
#         now = last + (income - last) * 0.8
#         return (now, now - pre)
#
#
# print(fee(2450, 3))

# ex1_3
# 猜数字小游戏
#
# print('the first program'.center(30,"-"))
# secret = random.randint(0, 100)
# try:
#     temp = int(input('请从0-100猜一个数字：'))
#     num = 1
#     while int(temp):
#         if temp == secret:
#             print("你真棒，猜对了!")
#             print("本次猜测共用了{0}次。".format(num))
#             break
#         else:
#             if temp > secret:
#                 num = num + 1
#                 temp = int(input("大了大了！\n请继续猜一个数字："))
#             else:
#                 num = num + 1
#                 temp = int(input("小了小了！\n请继续猜一个数字："))
# except:
#     print("请正确输入数字！！！")
# x = input("按任意键结束")


# def guess(start, end, max):
#     value = randint(start, end)
#     for i in range(max):
#         if i == 0:
#             prompt = '游戏开始！\n请输入你猜测的数字：'
#         else:
#             prompt = '请重新猜测！'
#         try:
#             x = int(input(prompt))
#         except:
#             print('游戏的次数只能为数字！')
#         else:
#             if x == value:
#                 print('猜对了！')
#                 break;
#             elif x > value:
#                 print('大了大了！')
#             else:
#                 print('小了小了')
#     else:
#         print('次数用完，游戏结束！\n结果是：'.format(value))
#
#
# start = int(input('请输入开始范围：'))
# end = int(input('请输入结束范围：'))
# times = int(input('请输入游戏次数：'))
# guess(start, end, times)

# ex1_4
# sum = 0
# for i in range(1, 7):
#     for j in range(1, 7):
#         for k in range(1, 7):
#             for t in range(1, 7):
#                 if (i != k) and (i != j) and (i != k) and (i != t) and (j != k) and (j != t) and (k != t):
#                     print("{0}{1}{2}{3}".format(i, j, k, t))
#                     sum += 1
# else:
#     print("符合段位的四位数总数为：{0}".format(sum))

# ex1_5
products = [["iphone", 6888], ["MacPro", 14800], ["小米6", 2499], ["Coffee", 31], ["Book", 60], ["Nike", 699]]
index = 0
menu = {}
# 构建字典
for item in products:
    menu[str(index)] = item
    index += 1

print("商品列表".center(40, "-"))
# 遍历字典
for key, value in menu.items():
    print(key, ':', value[0], value[1], sep=" ")

# 循环构建购物车
print("开始购物".center(40, "-"))
car = []
while True:
    num = input("请输入你要购买的商品编号，结束请按q键：")
    if num.isdigit():
        if num in menu.keys():
            car.append(num)
        else:
            print("输入错误，请重新输入正确的商品编号！")
    elif num.isalpha() and num == "q":
        print("商品选择结束!")
        break
    else:
        print("输入错误，请重新输入正确的商铺编号！")

# 购物车列表清单
print("购物车商品清单".center(40, "-"))
for i in car:
    print(i, menu[i][0], menu[i][1], sep=" ")

# 购物车价格总和
price = 0
print("购物价格".center(40, "-"))
for i in car:
    price += menu[i][1]
print("购物车内商品的总价为：{0}".format(price))

# ex1_6
# def singleLine():
#     print("---")
#
#
# def lineNum(i):
#     for j in range(i): singleLine()
#
#
# def sumOfThree():
#     str = input("请输入三个数字，用逗号隔开：\n")
#     lis = str.split(",")
#     lis = list(map(int, lis))
#     sum = 0
#     for i in range(3):
#         sum = sum + lis.pop()
#     print("三数求和结果为{0}".format(sum))
#
#
# def aveOfThree():
#     str = input("请输入三个数字，用逗号隔开：")
#     lis = str.split(",")
#     sum = 0
#     ave = 0
#     for i in range(len(lis)):
#         sum = sum + int(lis.pop())
#     ave = sum / 3
#     print("三数平均数结果为:{0}".format(ave))
#
#
# print("打印一条直线".center(30, "-"))
# singleLine()
#
# print("打印多条直线".center(30, "-"))
# num = input("请输入需要打印直线的条数：")
# lineNum(int(num))
#
# sumOfThree()
#
# aveOfThree()
