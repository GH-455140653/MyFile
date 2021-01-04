# -*- coding = utf-8 -*-
# @Time:2020/10/1 9:31
# @Author:李润霖
# @File:pra_json.py
# @Software:PyCharm

import json
import os

information = [
    {'小区名称': '小区A', '均价': 8000, '月交易量': 20},
    {'小区名称': '小区B', '均价': 8500, '月交易量': 35},
    {'小区名称': '小区C', '均价': 7800, '月交易量': 50},
    {'小区名称': '小区D', '均价': 12000, '月交易量': 18}]

# json格式写入文件
os.chdir(r'D:\MyData\MyProgram\PY program\My')
with open(r'.\cash\message.json', 'w') as fp:
    json.dump(information, fp, indent=4, ensure_ascii=False)

# json格式在python中读出
with open(r'.\cash\message.json', 'r') as fp:
    informations = json.load(fp)
    for info in informations:
        print(info)
