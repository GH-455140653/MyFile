# -*- coding = utf-8 -*-
# @Time:2020/10/2 18:18
# @Author:李润霖
# @File:hw_2.py
# @Software:PyCharm

import numpy as np

# x = np.arange(30).reshape(5, 6)
# print(*x)
# x[[0, 3], :] = 0
# print(*x)

# print(np.zeros((3,4)))
# print(np.ones((3,4)).sum())
# print(np.random.randint(0, 50, 5))
# print(np.eye(5))
# print(np.eye(5).shape)
# print(np.eye(5).size)

x = np.array((1, 2, 3, 4, 5))
# x = np.array([3, 5, 1, 9, 6, 3])
# print(np.argmax(x))
print((x ** 2).max())
print((2**x).max())
