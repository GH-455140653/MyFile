// window.onload=function (){
//     $('#HomePage').show();
//     $('#Role').hidden();
//     $('#Classified').hidden();
//     $('#usercontral').hidden();
//     $('#resourcescontral').hidden();
//     $('#CommentContral').hidden();
//     $('#ReportContral').hidden();
// }

window.onload=function (){
    hiddenAll();
    byId("HomePage").style.display = "";
}


var userM = byId("user-mean"),          //用户管理
    ClassifiedM = byId("Classified-mean"),  //分类管理
    VideoM = byId("Video-mean"),        //视频管理
    CommenM = byId("Comment-mean"),     //评论管理
    ReportM = byId("Report-mean"),      //报表管理
    RoleM = byId("Role-mean")          //权限管理
    // VideoUp = byId("VideoUp")          //上传视频

    // addvideo = byId("addvideo"),          //添加视频按钮
    // Videoclose = byId("Videoclose"),      //关闭视频按钮
    //
    // Authority1 = byId("Authority1"),          //五个权限分配按钮
    // Authority2 = byId("Authority2"),
    // Authority3 = byId("Authority3"),
    // Authority4 = byId("Authority4"),
    // Authority5 = byId("Authority5"),
    //
    // UdperAutho = byId("UdperAutho")        //更新权限按钮

    // Reportuser = byId("user-report"),    //用户报表
    // Reporvideo = byId("video-report")    //视频报表

;


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
    /*主页面隐藏*/
    byId("HomePage").style.display = "none";
    /*权限管理页面隐藏*/
    byId("Role").style.display = "none";
    /*分类管理页面隐藏*/
    byId("Classified").style.display = "none";
    /*用户管理页面隐藏*/
    byId("usercontral").style.display = "none";
    // /*视频管理页面隐藏*/
    byId("resourcescontral").style.display = "none";
    /*评论管理页面隐藏*/
    byId("CommentContral").style.display = "none";
    /*报表管理页面隐藏*/
    byId("ReportContral").style.display = "none";
    // /*添加视频页面隐藏*/
    // byId("VideoUp").style.display = "none";
}

//点击左侧标题 显示用户管理界面
addHandler(userM, "click", function () {
    hiddenAll();
    byId("usercontral").style.display = "block";
})

//点击左侧标题 显示分类管理
addHandler(ClassifiedM, "click", function () {
    hiddenAll();
    byId("Classified").style.display = "block";
})

//点击左侧标题 显示视频管理界面
addHandler(VideoM, "click", function () {
    hiddenAll();
    byId("resourcescontral").style.display = "block";
})

//点击左侧标题 显示评论管理界面
addHandler(CommenM, "click", function () {
    hiddenAll();
    byId("CommentContral").style.display = "block";
})

//点击左侧标题 显示报表管理界面
addHandler(ReportM, "click", function () {
    hiddenAll();
    byId("ReportContral").style.display = "block";
})

//点击左侧标题 显示权限管理界面
addHandler(RoleM, "click", function () {
    hiddenAll();
    byId("Role").style.display = "block";
})

// //点击添加视频 显示界面
// addHandler(addvideo, "click", function () {
//     hiddenAll();
//     byId("VideoUp").style.display = "block";
// })

// //点击关闭 显示界面
// addHandler(Videoclose, "click", function () {
//     hiddenAll();
//     byId("resourcescontral").style.display = "block";
// })

// //点击权限分配 显示权限管理界面
// addHandler(Authority1, "click", function () {
//     byId("Authority-ul").style.display = "block";
// })
// addHandler(Authority2, "click", function () {
//     byId("Authority-ul").style.display = "block";
// })
// addHandler(Authority3, "click", function () {
//     byId("Authority-ul").style.display = "block";
// })
// addHandler(Authority4, "click", function () {
//     byId("Authority-ul").style.display = "block";
// })
// addHandler(Authority5, "click", function () {
//     byId("Authority-ul").style.display = "block";
// })
// //点击更新权限 隐藏权限管理界面
// addHandler(UdperAutho, "click", function () {
//     byId("Authority-ul").style.display = "none";
//     alert("权限已分配");
// })


/*---------------------------------------------------------------- */
//点击用户报表 
// addHandler(Reportuser, "click", function () {
//     byId("Reportuser").style.display = "block";
//     byId("Reportvideo").style.display = "none";

// })


// //点击视频报表 
// addHandler(Reporvideo, "click", function () {

//     byId("Reportuser").style.display = "none";
//     byId("Reportvideo").style.display = "block";
// })


