# -*- coding = utf-8 -*-
# @Time : 2020/9/9 17:24
# @Author : 吴秀芹
# @File : WordCloud.py
# @Software : PyCharm

import random
from wordcloud import WordCloud
from matplotlib import pyplot as plt
from PIL import Image
import numpy as np
import jieba


def GBK2312():
    head = random.randint(0xb0, 0xf7)
    body = random.randint(0xa1, 0xf9)  # 在head区号为55的那一块最后5个汉字是乱码,为了方便缩减下范围
    val = f'{head:x}{body:x}'
    str = bytes.fromhex(val).decode('gb2312')
    return str


def create_word_cloud():
    text = open(r"D:\MyData\MyProgram\PY program\My\data\text\ppp.txt", 'r', encoding="utf-8").read()
    wordlist = jieba.lcut(text)  # jieba分词
    wl = " ".join(wordlist)

    images = Image.open(r"D:\MyData\MyProgram\PY program\My\data\image\sby.jpg")
    maskImages = np.array(images)
    # 设置词云
    w = WordCloud(
        # 设置背景颜色为白色
        background_color="white",
        #  默认collocations=True，会统计搭配词
        collocations=False,
        # 设置最大显示的词云数为2000
        max_words=2000,
        # 字体的一般路径--宋体
        font_path='simsun.ttc',
        height=1200,
        width=1600,
        # 设置字体最大的字体大小
        max_font_size=100,
        # 设置配色方案
        random_state=100,
        mask=maskImages
    )

    w.generate(wl)  # 根据文本生成词云
    plt.imshow(w)  # 接收一张图像，只是画出该图，并不会立刻显示出来
    w.to_file(r"D:\MyData\MyProgram\PY program\My\cash\cloud.png")  # 把词云保存下


if __name__ == '__main__':
    # with open(r"D:\MyData\MyProgram\PY program\My\data\text\file_cloude.txt", 'w')as fp:
    #     for i in range(1000):
    #         fp.write(GBK2312())
    create_word_cloud()
