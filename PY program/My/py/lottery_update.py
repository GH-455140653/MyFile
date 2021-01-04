import random


def depart(paraX):
    symbol = random.choice([True, False])
    if symbol:
        print(paraX.pop(0))
    else:
        print(paraX.pop(1))


# 执墨凝霜 前女友B真嫩 被淡忘的方程式 永不复行 微光丶落影成歌 真心丶玖爱 丿MIN丶铁魂 jhgjhk 丿小胜灬 凹凸镘专打小怪兽 饥渴难耐丿 AceYgs 风清空 COmbine | Mac丶 升天中勿打扰SS 要死要活的名字 胡静老公回家过 JoanGfy ws禽兽三
a = ["执墨凝霜", "前女友B真嫩", "永不复行", "丿小胜灬", "饥渴难耐丿", "被淡忘的方程式","那一次撕心裂肺","mile逆天"]
b = ["丿MIN丶铁魂", "前女友B真嫩"]
#c = ["丿MIN丶铁魂", "前女友B真嫩"]
# 左右随机
select = random.choice([True, False])
if select:
    print("下列人员进入左边队列：\n")
else:
    print("下列人员进入右边队列：\n")

# 人员随机
num = 0  # 控制人数
flag_1 = False  # 控制是否输出数组b
flag_2 = False  # 控制是否输出数组b
flag_b = False  # 控制数组b是否已经输出
flag_c = False  # 控制数组c是否已经输出
while num < 4:
    if not flag_b:
        flag_1 = random.choice([True, False])
        if flag_1:
            depart(b)
            flag_b = True
    #if not flag_c:
       # flag_2 = random.choice([True, False])
        #if flag_1:
          #  depart(c)
           # flag_c = True
    keys = random.randint(0, len(a) - num - 1)
    who = a.pop(keys)
    print(who)
    num += 1
if not flag_b:
    depart(b)
#if not flag_c:
    depart(c)

# 固定控制台
x = input("\n按任意键结束")


