$(function () {
    setInterval("show();", 1000); //每隔一秒运行一次
})

function show() {
    document.getElementById('time').innerHTML = showday();
}

function showday() { //输出当前时间
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth() + 1;
    var day = d.getDate();
    var week = d.getDay();
    switch (week) {
        case 0:
            week = "日";
            break;
        case 1:
            week = "一";
            break;
        case 2:
            week = "二";
            break;
        case 3:
            week = "三";
            break;
        case 4:
            week = "四";
            break;
        case 5:
            week = "五";
            break;
        case 6:
            week = "六";
            break;
    }
    var hour = d.getHours();
    var min = d.getMinutes();
    var seconds = d.getSeconds();
    // return alert("北京时间：" + year + "年" + month + "月" + day + "日" + " 星期" + week + " " + hour + "时" + min + "分" + seconds + "秒");
    return ("北京时间：" + year + "年" + month + "月" + day + "日" + " 星期" + week + " " + hour + "时" + min + "分" + seconds + "秒");
}