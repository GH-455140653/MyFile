# -*- coding = utf-8 -*-
# @Time:2020/10/1 9:59
# @Author:李润霖
# @File:pra_docx.py
# @Software:PyCharm

import sys
import importlib
import os

from docx import Document
from docx.shared import Inches

os.chdir(r'D:\MyData\MyProgram\PY program\My')


def main():
    # 创建文档对象
    document = Document()

    # 设置文档标题，中文要用unicode字符串
    document.add_heading(u'我的一个新文档', 0)



    # 保存文档
    document.save(r'.\cash\1.docx')


main()
