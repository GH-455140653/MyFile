// 初始化echarts实例
var myChart1 = echarts.init(document.getElementById('Reportuser'));
var myChart2 = echarts.init(document.getElementById('Reportvideo'));

var Reportuser= document.getElementById('user-report');
var Reporvideo= document.getElementById('video-report');

// 指定图表的配置项和数据
optionuser = {
    xAxis: {
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun','八月','九月','十月','十一月','十二月']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: [120, 200, 150, 80, 70, 110, 130,22,22,22,22,22],
        type: 'bar'
    }]
};

optionvideo = {
    xAxis: {
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun','八月','九月','十月','十一月','十二月']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: [20, 20, 50, 80, 70, 10, 30,22,22,22,22,22],
        type: 'bar'
    }]
};
// 使用刚指定的配置项和数据显示图表。
myChart1.setOption(optionuser);
myChart2.setOption(optionvideo);
byId("Reportvideo").style.display = "none";
document.getElementById('ReportContral').style.display="none";


function addHandler(element, type, handler) {
//非IE浏览器
if (element.addEventListener) {
        element.addEventListener(type, handler, true);
}
//IE浏览器支持DOM2级
else if (element.attachEvent) {
    element.attachEvent("on" + type, handler);
}
//IE浏览器不支持DOM2级
else {
    element["on" + type] = handler;
}
}

//封装getElementById()
function byId(id) {
    return typeof (id) == "string" ? document.getElementById(id) : id;
}

// 点击用户报表 
addHandler(Reportuser, "click", function () {
    byId('Report-text').innerHTML = '用户报表';
    byId("Reportuser").style.display = "block";
    byId("Reportvideo").style.display = "none";
})

//点击视频报表 
addHandler(Reporvideo, "click", function () {
    byId('Report-text').innerHTML = '视频报表';
    byId("Reportuser").style.display = "none";
    byId("Reportvideo").style.display = "block";
})