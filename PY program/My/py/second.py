# 函数的编写与运用
import decimal
import pygame
import pyaudio
import random


##求平方
# def aqu(x):
#     return x*x
# x=int(input("请输入你要求的数："))
# y=aqu(x)
# print("{0}的平方为：{1}".format(x,y))

##递归求阶乘
# def funY(n):
#     if n == 1 or n == 0:
#         return 1
#     else:
#         return n * funY(n - 1)
#
#
# n = int(input("请输入一个正整数："))
# print("%d的阶乘为：%d" % (n, funY(n)))

##迭代求阶乘
# def funX(n):
#     result = n
#     for i in range(1, n):
#         result *= i
#     print("%d的阶乘为：%d" % (n, result))
#
#
# n = int(input("请输入一个正整数："))
# funX(n)


# def prime(num):
#     # for i in num:
#     #     temp = False
#     #     for j in range(2, i):
#     #         if i % j == 0:
#     #             temp = True
#     #     if not temp: print("%d是素数" % i)
#
#     ls = list(filter(lambda x: all(map(lambda p: x % p != 0, range(2, x))), range(2, num)))
#     for item in ls:
#         print(item)
#
#
# prime(int(input("请输入一个正整数：")))

