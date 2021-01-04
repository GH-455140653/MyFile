# -*- coding = utf-8 -*-
# @Time:2020/10/1 9:38
# @Author:李润霖
# @File:pra_csv.py
# @Software:PyCharm

from csv import reader, writer
from random import randrange
from datetime import date, timedelta
import os

os.chdir(r'D:\MyData\MyProgram\PY program\My')

# 写入csv文件
with open(r".\cash\dataSave.csv", 'w', encoding='utf-8') as fp_w:
    wr = writer(fp_w)
    wr.writerow(['日期', '交易额'])
    startData = date(2020, 1, 1)
    for i in range(100):
        amout = 500 + i * 5 + randrange(5, 50)
        wr.writerow([str(startData), amout])
        startData = startData + timedelta(days=1)

# 读取csv文件
with open(r".\cash\dataSave.csv", 'r', encoding='utf-8') as fp_r:
    for line in reader(fp_r):
        if line:
            print(*line)
