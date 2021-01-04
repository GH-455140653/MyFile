# -*- coding = utf-8 -*-
# @Time:2020/10/1 10:04
# @Author:李润霖
# @File:pra_matplotlib.py
# @Software:PyCharm

import os
import matplotlib as mpl
import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
from mpl_toolkits.mplot3d import Axes3D

from random import randint
import numpy as np
import pandas as pd
from math import sin, cos

os.chdir(r'D:\MyData\MyProgram\PY program\My')

# #折线图
# _x=range(10)
# _y=[randint(2,20) for i in range(10)]
# plt.plot(_x,_y,'r-+')
# plt.show()

# _x=range(10)
# _y=[randint(2,20) for i in range(10)]
# plt.plot(_x,_y,'r+')
# plt.show()

# _x = range(10)
# _y = [randint(2, 20) for i in range(10)]
# plt.plot(_x, _y, ' r+')
# plt.savefig(r'.\cash\111.jpg')  # 图片保存
# plt.show()

# #闪点图
# x = np.random.random(100)
# y = np.random.random(100)
# plt.scatter(x, y, marker='*', c='r', s=100)
# plt.show()

# #柱状图
# month = list(range(1, 13))
# money = [5.2, 2.7, 5.8, 5.7, 7.3, 9.2, 18.7, 15.6, 20.5, 18.0, 7.8, 6.9]
# # 绘制每个月份的营业额
# for x, y in zip(month, money):
#     plt.bar(x, y, color='r', width=0.6, edgecolor='b', linestyle='--', linewidth=1.5)
#     plt.text(x - 0.3, y + 0.2, '%0.1f' % y)
#     # 设置x、y轴标签和字体
#     plt.xlabel('月份', fontproperties='simhei')
#     plt.ylabel('营业额（万元）', fontproperties='simhei')
#     plt.title('烧烤店营业额', fontproperties='simhei', fontsize=14)
#     # 设置x轴刻度
#     plt.xticks(month)
#     # 设置y轴跨度
#     plt.ylim(0, 22)
# plt.show()
# data = pd.DataFrame({'月份': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12],
#                      '男装': [51, 32, 58, 57, 30, 46, 38, 38, 40, 53, 58, 50],
#                      '女装': [70, 30, 48, 73, 82, 80, 43, 25, 30, 49, 79, 60],
#                      '餐饮': [60, 40, 46, 50, 57, 76, 70, 33, 70, 61, 49, 45],
#                      '化妆品': [110, 75, 130, 80, 83, 95, 87, 89, 96, 88, 86, 89],
#                      '金银首饰': [143, 100, 89, 90, 78, 129, 100, 97, 108, 152, 96, 87]})
# # 绘制柱状图，指定月份数据作为x轴
# data.plot(x='月份', kind='bar')
# # 设置x、y轴标签和字体
# plt.xlabel('月份', fontproperties='simhei')
# plt.ylabel('营业额（万元）', fontproperties='simhei')
# # 设置图例字体
# myfont = fm.FontProperties(fname=r'C:\Windows\Fonts\STKAITI.ttf')
# plt.legend(prop=myfont)
# plt.show()

# # 饼状图
# plt.rcParams['font.sans-serif'] = ['SimHei']  # 用来正常显示中文标签
#
# labels = ['娱乐', '育儿', '饮食', '房贷', '交通', '其它']
# sizes = [2, 5, 12, 70, 2, 9]
# explode = (0, 0, 0, 0.1, 0, 0)
# plt.pie(sizes, explode=explode, labels=labels, autopct='%1.1f%%', shadow=False, startangle=150)
# plt.title("饼图示例-8月份家庭支出")
# plt.show()

# #顶点图
# r = 20
# # 绘制4个圆周
# theta = np.arange(0, 8 * np.pi, 0.1)
# for t in theta:
#     x = r * cos(t)
#     y = r * sin(t)
#     # 只绘制顶点
#     plt.plot(x, y, 'ro')
#     # 增加半径
#     r = r + 1
#
# plt.show()

# #三维螺旋图
mpl.rcParams['legend.fontsize'] = 10  # 图例字号
fig = plt.figure()
ax = fig.gca(projection='3d')  # 三维图形
theta = np.linspace(-4 * np.pi, 4 * np.pi, 100)
z = np.linspace(-4, 4, 100) * 0.3  # 测试数据
r = z ** 3 + 1
x = r * np.sin(theta)
y = r * np.cos(theta)
ax.plot(x, y, z, label='parametric curve')
ax.legend()
plt.show()
