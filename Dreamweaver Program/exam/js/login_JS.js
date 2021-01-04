function $(id) {
    return document.getElementById(id);
}

window.onload = function () {
    //页面打开时检查是否存在记录的账号和密码
    if (getCookies("loginAN")) {
        $("account").value = getCookies("loginAN");
        if (getCookies("loginPW")) $("password").value = getCookies("loginPW");
    }

    //检查并询问用户是否退出登录
    if(getCookies("loginAN")){
        var quest=confirm("你已经登录了！\n请问你要重新登录吗？");
        if (quest===true){
            mouseOnclickRemove();//清除cookies数据
        }
        else{
            window.location="./index.html";//页面跳转
        }
    }
    //焦点聚焦
    $('account').focus();
};

function mouseOnclickLogin() {
    var checkBox = $("psw_checked");
    var aN = $("account").value;
    var pW = $("password").value;

    if (pW && aN) {
        if (checkBox.checked) {
            setCookies("loginAN", aN, 7);//保存账号7天
            setCookies("loginPW", pW, 7);//保存密码7天
        } else {
            setCookies("loginAN", aN, 1); //只保存账号，保存时间为1天，用于页面数据传递。
        }
    }
}

function mouseOnclickRemove() {
    removeCookies("loginAN");
    $("account").value = "";
    removeCookies("loginPW");
    $("password").value = "";
}

function formSubmit() {
    var Act = $('account');
    var Pwd = $('password')
    if (Act.value !== "" && Pwd.value !== "") {
        if (isChinese(Act.value)) {
            alert("账号不能含有中文！");
            Act.select();
            return false
        } else {
            if (Act.value !== "llllllllll") {
                alert("账号输入错误！")
                Act.focus();
                return false;
            } else if (Pwd.value !== "1234567890") {
                alert("密码输入错误！")
                Pwd.focus();
                return false;
            } else {
                mouseOnclickLogin();
                alert("登录成功！")
                return true;
            }
        }
    } else {
        alert("账号或密码未填写！")
        if (Act.value === "") {
            Act.focus();
        } else {
            Pwd.focus();
        }
        return false;
    }
}

function formReset() {
    var flag = confirm("请问你要清空目前表单数据吗？")
    if (flag) {
        mouseOnclickRemove();
        alert("表单数据已经清空！")
        $('account').focus();
        return true;
    } else {
        return false;
    }
}