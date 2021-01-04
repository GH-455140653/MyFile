function showday() { //输出当前时间
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth();
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
    return alert("北京时间：" + year + "年" + month + "月" + day + "日" + " 星期" + week + " " + hour + "时" + min + "分" + seconds + "秒");
}

function JR(elem, attr) { //处理浏览器兼容问题函数
    return elem.currentStyle ? elem.currentStyle[attr] : getComputedStyle(elem)[attr];
}

function setCookies(name, value, day) { //写入cookies
    var oDate = new Date();
    oDate.setDate(oDate.getDate() + day);
    document.cookie = name + "=" + value + ";expires=" + oDate;
}

function getCookies(Name) { //获取cookies
    var str = document.cookie;
    var arr = str.split("; ");//空格不能漏，否则获取失败
    for (var i = 0; i < arr.length; i++) {
        var arr1 = arr[i].split("=");
        if (arr1[0] === Name) return arr1[1];//arr1[0].tirm（）==Name 防止空格占位对返回结果的影响
    }
}

function removeCookies(Name) { //删除cookies
    setCookies(Name, 1, -1);
}

/*是否带有小数*/
function isDecimal(strValue) {
    var objRegExp = /^\d+\.\d+$/;
    return objRegExp.test(strValue);
}

/*校验是否中文名称组成 */
function ischina(str) {
    var reg = /^[\u4E00-\u9FA5]{2,4}$/;   /*定义验证表达式*/
    return reg.test(str);     /*进行验证*/
}

/*校验是否全由8位数字组成 */
function isStudentNo(str) {
    var reg = /^[0-9]{8}$/;   /*定义验证表达式*/
    return reg.test(str);     /*进行验证*/
}

/*校验电话码格式 */
function isTelCode(str) {
    var reg = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
    return reg.test(str);
}

/*校验邮件地址是否合法 */
function IsEmail(str) {
    var reg = /^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,4}){1,3}$/;
    return reg.test(str);
}

/*校验输入内容为中英文*/
function isName(str) {
    var reg = /^[a-zA-Z\u4e00-\u9fa5]+$/;
    return reg.test(str);
}

/*检验文件是否是常见的图片格式*/
function isPhoto(fileName) {
    var reg = /(.*)\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$/;
    return reg.test(fileName);
}