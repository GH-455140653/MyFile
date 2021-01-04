# -*- coding = utf-8 -*-
# @Time:2020/10/1 9:15
# @Author:李润霖
# @File:pra_file.py
# @Software:PyCharm

import os


def saveFileWithTwo(txtfiles):
    os.chdir(r'D:\MyData\MyProgram\PY program\My')
    with open(r".\cash\result.txt", 'w')as fp:
        with open(txtfiles[0], encoding='utf-8') as fp1, open(txtfiles[1], encoding='utf-8') as fp2:
            while True:
                # 交替读取文件1和文件2中的行，写入结果文件
                line1 = fp1.readline()
                if line1:
                    fp.write(line1)
                else:  # 如果文件1结束，结束循环
                    flag = False
                    break
                line2 = fp2.readline()
                if line2:
                    fp.write(line2)
                else:  # 如果文件2结束，结束循环
                    flag = True
                    break
            fp3 = fp1 if flag else fp2  # 获取尚未结束的文件对象
            for line in fp3:  # 把剩余内容写入结果文件
                fp.write(line)


os.chdir(r'D:\MyData\MyProgram\PY program\My')
saveFileWithTwo([r'.\data\text\gs.txt', r'.\data\text\dys.txt'])
