# -*- coding = utf-8 -*-
# @Time:2020/9/23 20:44
# @Author:李润霖
# @File:practice.py
# @Software:PyCharm

from PIL import Image
import numpy as np
import os



# #设置路径
# os.chdir(r"D:\MyData\MyProgram\PY program\My")
# #读取文件
# a=np.array(Image.open(r"D:\MyData\MyProgram\PY program\My\data\image\img_small.jpg"))
# #shape:ndarray对象的尺度  dtype:元素类型
# print(a.shape,a.dtype)
# b=[255,255,255]-a
# #astype()方法一定会创建新的数组（原始数据的一个拷贝）
# im=Image.fromarray(b.astype('uint8'))
# im.save(r"D:\MyData\MyProgram\PY program\My\data\image\img_small_1.jpg") #保存
# #读取图像，并转换成Lab颜色
# a=np.array(Image.open(r"D:\MyData\MyProgram\PY program\My\data\image\img_small.jpg").convert('L'))
# c=255-a
# im=Image.fromarray(c.astype('uint8'))
# im.save(r"D:\MyData\MyProgram\PY program\My\data\image\img_small_2.jpg")
