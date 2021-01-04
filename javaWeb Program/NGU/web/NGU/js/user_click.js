var r0 = byId("r0"),
    r1 = byId("r1"),
    r2 = byId("r2"),
    g1 = byId("g1"),
    k1 = byId("k1"),
    // k2 = byId("k2"),
    l1 = byId("l1"),
    l2 = byId("l2"),
    ge1 = byId("ge1");
// gy = byId("gy");


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
    byId("introduce").style.display = "none";
    /*查询员工信息页面隐藏*/
    byId("changeinfo").style.display = "none";
    /*添加员工信息页面隐藏*/
    byId("searchinfo").style.display = "none";
    /*查询工资信息页面隐藏*/
    byId("kdao").style.display = "none";
    /*查询考勤信息页面隐藏*/
    byId("opinion_txt").style.display = "none";
    /*查询留言信息页面隐藏*/
    /*写留言修改留言页面隐藏*/
    byId("mymsg").style.display = "none";
    /*修改密码信息页面隐藏*/
    byId("changepassword").style.display = "none";
    /*------------------*/
    byId("writemsg").style.display = "none";
}

//点击左侧标题 显示相应界面
addHandler(r0, "click", function () {
    hiddenAll();
})

addHandler(r0, "click", function () {
    byId("introduce").style.display = "block";
})

//点击查询员工信息 显示相应界面
addHandler(r1, "click", function () {
    hiddenAll();
})

addHandler(r1, "click", function () {
    byId("changeinfo").style.display = "block";
})

//点击添加员工信息页 显示相应界面
addHandler(r2, "click", function () {
    hiddenAll();
})

addHandler(r2, "click", function () {
    byId("searchinfo").style.display = "block";
})
/**/
addHandler(g1, "click", function () {
    hiddenAll();
})

addHandler(g1, "click", function () {
    byId("kdao").style.display = "block";
})

/**/
addHandler(k1, "click", function () {
    hiddenAll();
})

addHandler(k1, "click", function () {
    byId("opinion_txt").style.display = "block";
})

// addHandler(k2, "click", function () {
//     hiddenAll();
// })
//
// addHandler(k2, "click", function () {
//     byId("opinion_file").style.display = "block";
// })

/**/
addHandler(l1, "click", function () {
    hiddenAll();
})

addHandler(l1, "click", function () {
    byId("mymsg").style.display = "block";
})

/**/
addHandler(l2, "click", function () {
    hiddenAll();
})

addHandler(l2, "click", function () {
    // byId("mymsg").style.display = "block";
    byId("writemsg").style.display = "block";
})


//点击修改密码 显示相应界面
addHandler(ge1, "click", function () {
    hiddenAll();
})

addHandler(ge1, "click", function () {
    byId("changepassword").style.display = "block";
})

byId("introduce").style.display = "block";
