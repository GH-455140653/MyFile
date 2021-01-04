import requests, json, jsonpath
import xlwt

# 创建会话对象
session = requests.session()
# 请求接口
result = session.get('https://api.inews.qq.com/newsqa/v1/automation/foreign/country/ranklist')
# 打印结果
print(result.text)
# 解析json结果
resJson = json.loads(result.text)
data = jsonpath.jsonpath(resJson, '$.data.*')
for d in data:
    res = '日期:' + d['date'] + '--' + d['continent'] + '--' + d['name'] + '--' + '新增确诊:' + str(
        d['confirmAdd']) + '累计确诊:' + str(d['confirm']) + '治愈:' + str(d['heal']) + '死亡:' + str(d['dead'])
    # res = '日期:' + d['date'] + '--' + d['name'] + '--' + ' 新增确诊:' + str(
    #     d['confirmAdd']) + ' 累计确诊:' + str(d['confirm'])
    # 保存数据路径
    file = 'D:/study/大三上/大数据基础/global-yq.txt'
    with open(file, 'a+', encoding='utf-8') as f:
        f.write(res + '\n')  # 加\n换行显示
