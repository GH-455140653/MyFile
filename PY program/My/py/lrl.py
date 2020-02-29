##失败zhe
def save(Class, name, number):
    Class_file = open(r"C:\MyData\MyProgram\PY program\My\Class.txt", 'a')
    name_file = open(r"C:\MyData\MyProgram\PY program\My\names.txt", 'a')
    number_file = open(r"C:\MyData\MyProgram\PY program\My\numbers.txt", 'a')
    Class_file.writelines(Class)
    name_file.writelines(name)
    number_file.writelines(number)
    Class_file.close()
    name_file.close()
    number_file.close()


f = open(r"C:\MyData\MyProgram\PY program\My\ls.txt", 'r', encoding='utf-8')
Class = []  # 班级
name = []  # 姓名
number = []  # 学号
for each in f:
    (left, mid, right) = each.split(':', 2)
    print(left)
    Class.append(left+'\n')
    name.append(mid+'\n')
    number.append(number)
    save(Class, name, number)
    Class = []
    name = []
    number = []
f.close()
