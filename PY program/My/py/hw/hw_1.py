# hw_1_1
# sum = [2 ** i for i in range(65) if i == 64]
# print("一共需要{0}粒米".format("".join(map(str, sum))))

# hw1_2
s = input('请输入你要的数字，用逗号隔开：')
lis = s.split(",")
lis = list(map(int, lis))
lis = [i for i in lis if i % 2 == 1]
print(lis)

# hw1_3
# str = input('请输入字符串：')
# if (list(reversed(list(str)))==list(str)):
#     print("True")
# else:
#     print("False")

# s = input('')
# if not s:
#     print('请不要输入空字符串！')
#     s = input('请重新输入一个字符串：')
# a = reversed(list(s))
# if list(a) == list(s):
#     print('是回文')
# else:
#     print('不是回文')
