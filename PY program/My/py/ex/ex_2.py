# -*- coding = utf-8 -*-
# @Time:2020/10/2 18:39
# @Author:李润霖
# @File:ex_2.py
# @Software:PyCharm
from copy import deepcopy

import numpy as np
import pandas as pd
import os

pd.set_option('display.unicode.ambiguous_as_wide', True)
pd.set_option('display.unicode.east_asian_width', True)
pd.set_option('display.max_rows', 20)
os.chdir(r'D:\MyData\MyProgram\PY program\My')

# # 内置对象range创建
# ser = pd.Series(range(1, 50, 5))
# print(ser)

# # 字典创建
# ser = pd.Series({'语文': 100, '数学': 100, '英语': 100, '综合': 100})
# print(ser)


# print('原始数据'.center(20, '-'))
# print(ser)
#
# print('修改某个索引的某个值'.center(20, '-'))
# ser[2] = 100
# print(ser)
#
# print('对ser求绝对值'.center(20, '-'))
# print(abs(ser))
#
# print('对ser减5'.center(20, '-'))
# print(ser - 5)
#
# print('索引前加！'.center(20, '-'))
# print(ser.add_prefix('!'))
#
# print('索引后加！'.center(20, '-'))
# print(ser.add_suffix('!'))
#
# print('最大索引'.center(20, '-'))
# print(ser.argmax())
#
# print('求出在指定区间的情况'.center(20, '-'))
# print(ser.between(20, 30, inclusive=True))
#
# print('找出在指定区间的值'.center(20, '-'))
# print(ser[ser > 20])
#
# print('求中值'.center(20, '-'))
# print(ser.median())
#
# print('值的运算'.center(20, '-'))
# print((ser ** 2) * 2 + 2)
#
# print('求最小几个数'.center(20, '-'))
# print(ser.nsmallest(3))

# print('间隔10天'.center(30, '='))
# print(pd.date_range(start='20190601', end='20190630', freq='10D'))
#
# print('间隔3小时，3个数据'.center(30, '='))
# print(pd.date_range(start='201906010000', periods=3, freq='3H'))
#
# print('间隔1个月，4个数据，月末最后一天'.center(30, '='))
# print(pd.date_range(start='20190601', periods=4, freq='A'))
#
# print('间隔1个月，4个数据，月初最后一天'.center(30, '='))
# print(pd.date_range(start='20190601', periods=4, freq='AS'))
#
# data = pd.Series(index=pd.date_range(start="20200411", periods=24, freq='H'), data=range(24))
# print('前5条数据'.center(30, '='))
# print(data[:5])
#
# print('3小时取样求均值'.center(30, '='))
# print(data.resample('3H').mean())
#
# print('4小时，OHLC取样'.center(30, '='))
# print(data.resample('4H').ohlc())
#
# print('日期替换'.center(30, '='))
# data.index = data.index + pd.Timedelta('2D')
# print(data)
#
# print('查看指定日期时间是否是闰年'.center(30, '='))
# print(pd.Timestamp('202004112121').is_leap_year)
#
# print('查看指定日期的季度和月份'.center(30, '='))
# print(pd.Timestamp('202004112121').quarter, pd.Timestamp('202004112121').month)

# df = pd.DataFrame(np.random.randint(1, 20, (5, 3)), index=range(5), columns=['A', 'B', 'C'])
# print(df)
#
# df = pd.DataFrame({'语文': [87, 79, 67, 92],
#                    '数学': [93, 89, 80, 77],
#                    '英语': [90, 80, 70, 75]},
#                   index=['张三', '李四', '王五', '赵六'])
# print(df)
#
# # 读取工号、姓名、时段、交易额这四列数据，使用默认索引
# df = pd.read_excel(r'.\data\text\超市营业额.xlsx', usecols=['工号', '姓名', '时段', '交易额'])
#
# # 输出前10行数据
# print(df[:10], end='\n\n')

# df = pd.read_excel(r".\data\text\超市营业额.xlsx", usecols=['工号', '姓名', '时段', '交易额'])
# print(df[:10])
#
# # 读取第一个worksheet中所有列
# # 跳过第1、3、5行，指定下标为1的列中数据为DataFrame的行索引标签
# df = pd.read_excel(r'.\data\text\超市营业额.xlsx', skiprows=[1, 3, 5], index_col=1)
# print(df[:10])

df = pd.read_excel(r".\data\text\超市营业额.xlsx")

# print('输出指定区域的行数据'.center(30, "+"))
# print(df[2:5])
#
# print('查看指定列数据'.center(30, "+"))
# print(df[['交易额']])
#
# print('查看指定行指定列的数据(行列顺序随意)'.center(30, "+"))
# print(df[['交易额', '姓名']][:5])
#
# print('iloc查询'.center(30, "+"))
# print(df.iloc[[3, 4, 5, 7]])
#
# print('loc查询数据'.center(30, "+"))
# print(df.loc[[2, 3, 7, 8]])
#
# print('at单个查询'.center(30, "+"))
# print(df.at[3, '姓名'])
#
# print('交易额高于1500的数据'.center(30, "+"))
# print(df[df['交易额'] > 1500])
#
# print('张晓霞和李思思下午班交易总额'.center(30, "+"))
# print(df[(df['姓名'].isin(['张晓霞', '李思思'])) & (df['时段'] == '14：00-21：00')]["交易额"].sum())
#
# print('交易额范围前n条数据'.center(30, "+"))
# print(df[df['交易额'].between(1000, 1500)][:10])

# 6.
# print('查看交易额统计信息'.center(30, "+"))
# print(df['交易额'].describe())
#
# print('交易额中值'.center(30, "+"))
# print(df['交易额'].median())
#
# print('交易额最大行下标'.center(30, "+"))
# print(df.交易额.idxmax())
#
# print('交易额最小行下标'.center(30, "+"))
# print(df.交易额.idxmin())
#
# print('第一个最大交易额'.center(30, "+"))
# print(df.loc[df.交易额.idxmax(), '交易额'])


# print('按交易额和工号降序排序'.ljust(20, '='))
# print(df.sort_values(by=['交易额', '工号'], ascending=False)[:12])
#
# print('按交易额降序、工号升序排序'.ljust(20, '='))
# print(df.sort_values(by=['交易额', '工号'], ascending=[False, True])[:12])
#
# print('按交易额排序、缺失值放在最前面'.ljust(20, '='))
# print(df.sort_values(by='交易额', na_position='first')[:10])
#
# print('交易额升序，工号降序，缺失放前面进行排序,展示前10个'.center(30, "+"))
# print(df.sort_values(by=['交易额', '工号'], ascending=[True, False], na_position='first')[:10])

# print('不同时段的销售总额'.ljust(30, '='))
# print(df.groupby(by='时段')['交易额'].sum())
#
# print('每个员工交易额平均值'.ljust(30, '='))
# print(df.groupby(by='姓名')['交易额'].mean().round(2).sort_values())
#
# print('每个员工上班的次数'.ljust(30, '='))
# dff = df.groupby(by='姓名')['日期'].count()
# dff.name = '上班次数'
# print(dff)
#
# print('使用agg()方法对交易额进行聚合'.ljust(30, '='))
# print(df.agg({'交易额': ['sum', 'mean', 'min', 'max', 'median'], '日期': ['min', 'max']}))
#
# print('按姓名分组和agg()方法对交易额进行聚合'.ljust(30, '='))
# print(df.groupby(by='姓名').agg({'交易额': ['sum', 'mean', 'min', 'max', 'median']}))

# 9.
# print('查看交易额低于200的数据'.ljust(20, '='))
# print(df[df['交易额'] < 200])
#
# print('把低于200的交易额都替换为固定的200'.center(30, "+"))
# df.loc[df.交易额 < 200, '交易额'] = 200
# print(df[df['交易额'] < 200])

df = pd.read_excel(r".\data\text\超市营业额.xlsx")

print('原'.center(30, '+'))
print(df)

# 扩展1
print('单日交易总额最小的3天的交易数据'.center(30, '+'))
df2 = df.groupby(by='日期', as_index=False).agg({'交易额': 'sum'}).nsmallest(3, '交易额')
print(df2)
print('这3天是周几'.center(30, '='))
print(pd.to_datetime(df2.日期).dt.dayofweek)

# 扩展2
print('把所有员工的工号前面增加一位数字'.center(30, '='))
df2 = deepcopy(df)
df2['工号'] = df['工号'].map(lambda s: str(s)[-1] + str(s))
df2.to_excel(r".\cash\超市营业额_修改工号.xlsx", index=False)
print(df2)
