import xlwt #导入xlwt模块
file = xlwt.Workbook()#创建一个Workbook对象，即创建一个Excel工作簿
#创建学生信息表
#sheet1表示Excel文件中的一个表
#创建一个sheet对象，命名为“学生信息”，cell_overwrite_ok表示是否可以覆盖单元格，是Worksheet实例化的一个参数，默认值是False
sheet1 = file.add_sheet(u'疫情数据', cell_overwrite_ok=True)
#标题信息行集合
rowTitle = [u'日期',u'大洲',u'国家',u'新增确诊',u'累计确诊',u'治愈',u'死亡']
#学生信息行集合
rowDatas = '日期:' + d['date'] + '--' + d['continent'] + '--' + d['name'] + '--' + '新增确诊:' + str(d['confirmAdd']) + '累计确诊:' + str(d['confirm']) + '治愈:' + str(d['heal']) + '死亡:' + str(d['dead'])
#遍历向表格写入标题行信息
for i in range(0,len(rowTitle)):
# 其中的'0'表示行, 'i'表示列，0和i指定了表中的单元格，'rowTitle[i]'是向该单元格写入的内容
    sheet1.write(0,i,rowTitle[i])
#遍历向表格写入学生信息
for k in range(0,len(rowDatas)):    #先遍历外层的集合，即每行数据
    for j in range(0,len(rowDatas[k])): #再遍历内层集合，j表示列数据
        sheet1.write(k+1,j,rowDatas[k][j]) #k+1表示先去掉标题行，j表示列数据，rowdatas[k][j] 插入单元格数据
#保存文件的路径及命名
file.save('D:/WriteToExcel.xlsx')