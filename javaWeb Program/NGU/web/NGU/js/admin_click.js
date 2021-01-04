var r0 = byId("r0"),
    r1 = byId("r1"),
    r2 = byId("r2"),
    g1 = byId("g1"),
    k1 = byId("k1"),
    l1 = byId("l1"),
    l2 = byId("l2"),
    ge1 = byId("ge1"),
    suggestion = byId("suggestion");

//封装getElementById()
function byId(id) {
    return typeof (id) == "string" ? document.getElementById(id) : id;
}


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

//隐藏所有右边界面
function hiddenAll() {
    /*程序打开时的页面隐藏*/
    byId("right0").style.display = "none";
    /*查询员工信息页面隐藏*/
    byId("right1").style.display = "none";
    /*添加员工信息页面隐藏*/
    byId("right2").style.display = "none";
    /*查询工资信息页面隐藏*/
    byId("searchwage").style.display = "none";
    /*查询考勤信息页面隐藏*/
    byId("searchkdao").style.display = "none";
    /*留言信息页面隐藏*/
    byId("mymsg").style.display = "none";
    /*修改密码信息页面隐藏*/
    byId("psw_Aupdate").style.display = "none";
    /*发布留言隐藏*/
    byId("writemsg").style.display = "none";
    /*建议查询*/
    byId("suggest").style.display = "none";
}


//点击左侧标题 显示相应界面
addHandler(r0, "click", function () {
    hiddenAll();
})

addHandler(r0, "click", function () {
    byId("right0").style.display = "block";
})


//点击查询员工信息 显示相应界面
addHandler(r1, "click", function () {
    hiddenAll();
})

addHandler(r1, "click", function () {
    byId("right1").style.display = "block";
})


//点击添加员工信息页 显示相应界面
addHandler(r2, "click", function () {
    hiddenAll();
})

addHandler(r2, "click", function () {
    byId("right2").style.display = "block";
})


//工资管理界面的显示和隐藏
addHandler(g1, "click", function () {
    hiddenAll();
})

addHandler(g1, "click", function () {
    byId("searchwage").style.display = "block";
})


//考勤管理界面的显示和隐藏
addHandler(k1, "click", function () {
    hiddenAll();
})

addHandler(k1, "click", function () {
    byId("searchkdao").style.display = "block";
})

//意见查询界面的显示和隐藏
addHandler(suggestion, "click", function () {
    hiddenAll();
})

addHandler(suggestion, "click", function () {
    byId("suggest").style.display = "block";
})

//留言界面管理的显示和隐藏
addHandler(l1, "click", function () {
    hiddenAll();
})

addHandler(l1, "click", function () {
    byId("mymsg").style.display = "block";
})


//点击发布新留言,显示相应界面
addHandler(l2, "click", function () {
    hiddenAll();
})

addHandler(l2, "click", function () {
    byId("writemsg").style.display = "block";
})


//修改密码的显示和隐藏
addHandler(ge1, "click", function () {
    hiddenAll();
})

addHandler(ge1, "click", function () {
    byId("psw_Aupdate").style.display = "block";
})

byId("right0").style.display = "block";