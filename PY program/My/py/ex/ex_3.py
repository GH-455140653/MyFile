# -*- coding = utf-8 -*-
# @Time:2020/10/9 18:00
# @Author:李润霖
# @File:ex_3.py
# @Software:PyCharm


import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
import os
from wordcloud import WordCloud
from PIL import Image
import numpy as np
import jieba
from csv import reader, writer
from random import randrange
from datetime import date, timedelta
import json

os.chdir(r'D:\MyData\MyProgram\PY program\My')
font = fm.FontProperties(fname=r"C:\Windows\Fonts\simsun.ttc")


# 7.

with open(r".\data\text\商场一楼手机信号强度.txt")as fp:
    for line in fp:
        x, y, z = map(int, line.split(","))
        if z < 40:
            color = 'r'
        elif z < 70:
            color = 'b'
        else:
            color = 'g'
        plt.scatter(x, y, z, c=color, marker='*')

plt.title('商场内信号强度',fontproperties=font,  fontsize=14)
plt.show()

# 6.
# inPrice, salePrice = 49, 75
#
#
# def com(num):
#     return salePrice * (1-0.01*num)
#
#
# num = list(range(1, 31))
# earns = []
# saves = []
# ccost = []
# for i in num:
#     perPrice = com(i)
#     earns.append(round(i * (perPrice - inPrice), 2))
#     ccost.append(round(i * perPrice, 2))
#     saves.append(round(i * (salePrice - perPrice), 2))
#
# plt.plot(num, earns, label='顾客总消费')
# plt.plot(num, ccost, label="顾客总消费")
# plt.plot(num, saves, label="顾客节省的金额")
# plt.xlabel('顾客购买数量（件）', fontproperties='simhei')
# plt.ylabel('金额（元）', fontproperties='simhei')
# plt.title('数量-金额关系图', fontproperties='stkaiti', fontsize=20)
#
# # plt.legend(pop=font)
# maxEarn = max(earns)
# bestNum = num[earns.index(maxEarn)]
# plt.scatter([bestNum], [maxEarn], marker='*', color='red', s=120)
# # 使用annotate()函数在指定位置进行文本标注
# plt.annotate(xy=(bestNum, maxEarn),  # 箭头终点坐标
#              xytext=(bestNum - 1, maxEarn + 200),  # 箭头起点坐标
#              s=str(maxEarn),  # 显示的标注文本
#              arrowprops=dict(arrowstyle="->"))  # 箭头样式
# plt.show()

# 5.
# month = list(range(1, 13))
# money = [5.2, 2.7, 5.8, 5.7, 7.3, 9.2, 18.7, 15.6, 20.5, 18.0, 7.8, 6.9]
#
# for x, y in zip(month, money):
#     color = '#%02x' % int(y * 10) + '6666'
#     plt.bar(x, y, color=color, width=0.6, edgecolor='g', linestyle="--", linewidth="1.2")
#     plt.text(x - 0.3, y + 0.2, '%.1f' % y)
# plt.xlabel('月份', fontproperties='simhei')
# plt.ylabel('营业额（万元）', fontproperties='simhei')
# plt.title('烧烤店营业额', fontproperties='simhei', fontsize=14)
# plt.xticks(month)
# plt.ylim(0, 22)
# plt.show()

# 4.
# month = list(range(1, 13))
# money = [5.2, 2.7, 5.8, 5.7, 7.3, 9.2, 18.7, 15.6, 20.5, 18.0, 7.8, 6.9]
# plt.plot(month,money,"r-v")
# plt.xlabel('月份', fontproperties=font, fontsize=14)
# plt.ylabel('营业额（万元）', fontproperties=font, fontsize=14)
# plt.title('烧烤店2019年营业额变化趋势图',fontproperties=font, fontsize=18)
# plt.tight_layout()# 紧缩四周空白，扩大绘图区域可用面积
# plt.show()

# 3.
# with open(r".\cash\ex3_3.csv", "w")as fp:
#     write = writer(fp)
#     write.writerow(['日期', '营业额'])
#     startDate = date(2020, 1, 1)
#     for i in range(1000):
#         amount = 1000 + i * 10 + randrange(100, 1000)
#         write.writerow([str(startDate), amount])
#         startDate += timedelta(days=5)
#
# with open(r".\cash\ex3_3.csv")as fp:
#     for i in fp:
#         if i:
#             print(*i)

# 2.
# msg = [{'小区名称': '小区A', '均价': 8000, '月交易量': 20},
#        {'小区名称': '小区B', '均价': 8500, '月交易量': 35},
#        {'小区名称': '小区C', '均价': 7800, '月交易量': 50},
#        {'小区名称': '小区D', '均价': 12000, '月交易量': 18}]
#
# with open(r".\cash\ex3_2.json", "w")as fp:
#     json.dump(msg, fp, indent=4, ensure_ascii=False)
#
# with open(r".\cash\ex3_2.json")as fp:
#     infors = json.load(fp)
#     for i in infors:
#         print(i)

# 1.
# def addMsg(textFile):
#     with open(r".\cash\result.txt", "w")as fp:
#         with open(textFile[0])as fp1, open(textFile[1])as fp2:
#             while True:
#                 line1 = fp1.readline()
#                 if line1:
#                     fp.write(line1)
#                 else:
#                     flag = False
#                     break
#                 line2 = fp2.readline()
#                 if line2:
#                     fp.write(line2)
#                 else:
#                     flag = True
#                     break
#             fp3 = fp1 if flag else fp2
#             for line in fp3:
#                 fp.write(line)
#
# addMsg([r".\data\text\gs.txt",r".\data\text\dys.txt"])
