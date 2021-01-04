

// var Cmodify1=byId("Cmodify1");   //修改按钮
// var Ccancel1=byId("Ccancel1");   //取消按钮
//
// var Cmodify2=byId("Cmodify2");   //修改按钮
// var Ccancel2=byId("Ccancel2");   //取消按钮
//
// var Cmodify3=byId("Cmodify3");   //修改按钮
// var Ccancel3=byId("Ccancel3");   //取消按钮
//
// //右侧下拉框js
// function ClassChange()
// {
//    var x = document.getElementById("ClassFirst");
//    var y = document.getElementById("ClassSecond");
//    y.options.length = 0; // 清除second下拉框的所有内容
//    if(x.selectedIndex == 0)
//    {
//
// 		y.options.add(new Option("无上级分类", "1", false, true));  // 默认选中省会城市
//    }
//
//    if(x.selectedIndex == 1)
//    {
//         y.options.add(new Option("综艺", "0"));
//         y.options.add(new Option("电视剧", "0"));
// 		y.options.add(new Option("电影", "0"));
// 		y.options.add(new Option("动漫", "1", false, true));  // 默认选中省会城市
//    }
// }
//
//
// //封装getElementById()
// function byId(id) {
//    return typeof (id) == "string" ? document.getElementById(id) : id;
// }
//
// function addHandler(element, type, handler) {
//    //非IE浏览器
//    if (element.addEventListener) {
//        element.addEventListener(type, handler, true);
//    }
//    //IE浏览器支持DOM2级
//    else if (element.attachEvent) {
//        element.attachEvent("on" + type, handler);
//    }
//    //IE浏览器不支持DOM2级
//    else {
//        element["on" + type] = handler;
//    }
// }
//
//
// //点击第一个二级分类的修改按钮
// addHandler(Cmodify1, "click", function () {
//    byId('Classname1').removeAttribute('disabled') ;
//
//    byId("Cmodify1").style.display = "none";   //修改按钮隐藏
//    byId("Cdelet1").style.display = "none";    //删除按钮隐藏
//
//    byId("Cconfirm1").style.display = "inline"; //确认按钮显示
//    byId("Ccancel1").style.display = "inline";  //取消按钮显示
// })
//
// //点击第一行取消按钮
// addHandler(Ccancel1, "click", function () {
//    byId('Classname1').setAttribute('disabled', 'disabled')
//
//    byId("Cmodify1").style.display = "inline";   //修改按钮显示
//    byId("Cdelet1").style.display = "inline";    //删除按钮显示
//
//    byId("Cconfirm1").style.display = "none"; //确认按钮隐藏
//    byId("Ccancel1").style.display = "none";  //取消按钮隐藏
//    /*---重点--在这里重新导入一下数据*/
// })
//
//
//
//
// //点击第二个二级分类的修改按钮
// addHandler(Cmodify2, "click", function () {
//    byId('Classname2').removeAttribute('disabled') ;
//
//    byId("Cmodify2").style.display = "none";   //修改按钮隐藏
//    byId("Cdelet2").style.display = "none";    //删除按钮隐藏
//
//    byId("Cconfirm2").style.display = "inline"; //确认按钮显示
//    byId("Ccancel2").style.display = "inline";  //取消按钮显示
// })
//
// //点击第二行取消按钮
// addHandler(Ccancel2, "click", function () {
//    byId('Classname2').setAttribute('disabled', 'disabled')
//
//    byId("Cmodify2").style.display = "inline";   //修改按钮显示
//    byId("Cdelet2").style.display = "inline";    //删除按钮显示
//
//    byId("Cconfirm2").style.display = "none"; //确认按钮隐藏
//    byId("Ccancel2").style.display = "none";  //取消按钮隐藏
//    /*---重点--在这里重新导入一下数据*/
// })
//
// //点击第三个二级分类的修改按钮
// addHandler(Cmodify3, "click", function () {
//    byId('Classname3').removeAttribute('disabled') ;
//
//    byId("Cmodify3").style.display = "none";   //修改按钮隐藏
//    byId("Cdelet3").style.display = "none";    //删除按钮隐藏
//
//    byId("Cconfirm3").style.display = "inline"; //确认按钮显示
//    byId("Ccancel3").style.display = "inline";  //取消按钮显示
// })
//
// //点击第三行取消按钮
// addHandler(Ccancel3, "click", function () {
//    byId('Classname3').setAttribute('disabled', 'disabled')
//
//    byId("Cmodify3").style.display = "inline";   //修改按钮显示
//    byId("Cdelet3").style.display = "inline";    //删除按钮显示
//
//    byId("Cconfirm3").style.display = "none"; //确认按钮隐藏
//    byId("Ccancel3").style.display = "none";  //取消按钮隐藏
//    /*---重点--在这里重新导入一下数据*/
// })
//
//
// //点击第四个二级分类的修改按钮
// addHandler(Cmodify4, "click", function () {
//    byId('Classname4').removeAttribute('disabled') ;
//
//    byId("Cmodify4").style.display = "none";   //修改按钮隐藏
//    byId("Cdelet4").style.display = "none";    //删除按钮隐藏
//
//    byId("Cconfirm4").style.display = "inline"; //确认按钮显示
//    byId("Ccancel4").style.display = "inline";  //取消按钮显示
// })
//
// //点击第四行取消按钮
// addHandler(Ccancel4, "click", function () {
//    byId('Classname4').setAttribute('disabled', 'disabled')
//
//    byId("Cmodify4").style.display = "inline";   //修改按钮显示
//    byId("Cdelet4").style.display = "inline";    //删除按钮显示
//
//    byId("Cconfirm4").style.display = "none"; //确认按钮隐藏
//    byId("Ccancel4").style.display = "none";  //取消按钮隐藏
//    /*---重点--在这里重新导入一下数据*/
// })
//
