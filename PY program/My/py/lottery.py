import random

# 执墨凝霜 梦撕碎只剩泪n  mile逆天 微光丶落影成歌 真心丶玖爱 丿MIN丶铁魂 jhgjhk
# 前女友B真嫩 被淡忘的方程式 永不复行 丿小胜灬 凹凸镘专打小怪兽 饥渴难耐丿 AceYgs 
# 风清空 COmbine | Mac丶 升天中勿打扰SS 要死要活的名字 胡静老公回家过 JoanGfy 
a = ["执墨凝霜", "梦撕碎只剩泪n", "永不复行", "丿MIN丶铁魂", "凹凸镘专打小怪兽", "AceYgs", "微光丶落影成歌", "mile逆天", "饥渴难耐丿", "前女友B真嫩"]
# 左右随机
select = random.choice([True, False])
if select:
    print("下列人员进入左边队列：\n")
else:
    print("下列人员进入右边队列：\n")

# 人员随机
num = 0  # 控制人数
while num < 5:
    keys = random.randint(0, len(a) - num - 1)
    who = a.pop(keys)
    print(who)
    num += 1
# 固定控制台
x = input("\n按任意键结束")
