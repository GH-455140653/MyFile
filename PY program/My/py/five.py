# 类与对象
class Animal:
    def __init__(self, name):
        self.name = name

    def eat(self):
        print('%s能吃！' % self.name)


class Cat(Animal):
    def __init__(self, name):
        super().__init__(name)  # 继承父类

    def play(self):
        print('%s能够玩球球！' % self.name)


class Dog(Animal):
    def __init__(self, name):
        super().__init__(name)  # 继承父类

    def play(self):
        print('%s能够接飞碟！' % self.name)


a = Cat('加菲猫')
a.eat()
a.play()
b = Dog('哈帕狗')
b.play()
