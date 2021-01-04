# -*- coding = utf-8 -*-
# @Time:2020/9/30 14:52
# @Author:李润霖
# @File:pra_pandas.py
# @Software:PyCharm

import pandas as pd
import os

pd.set_option('display.unicode.ambiguous_as_wide', True)
pd.set_option('display.unicode.east_asian_width', True)

os.chdir(r'D:\MyData\MyProgram\PY program\My')
df = pd.read_excel(r".\data\text\超市营业额.xlsx", usecols=['工号', '姓名', '时段', '交易额'])
# print(df[:10])

kd=df.sort_values(by='交易额', axis=0, ascending=False)
# print(kd)
print(df.groupby(by='工号')['交易额'].sum())
