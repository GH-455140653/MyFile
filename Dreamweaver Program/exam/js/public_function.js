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
        if (arr1[0] == Name) return arr1[1];//arr1[0].tirm（）==Name 防止空格占位对返回结果的影响
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

/*校验是否含有中文组成 */
function isChinese(str) {
    var reg = /.*[\u4e00-\u9fa5]+.*$/;   /*定义验证表达式*/
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