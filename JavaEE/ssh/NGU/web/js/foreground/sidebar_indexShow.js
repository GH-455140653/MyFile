//实现菜单栏移动到某个位置位置时实现页面相对固定
window.onload = function () {
    var sidebar = document.getElementById("sidebar-main");
    H = 0, Y = sidebar;
    while (Y) {
        H += Y.offsetTop;
        Y = Y.offsetParent;
    }
    window.onscroll = function () {
        var s = document.body.scrollTop || document.documentElement.scrollTop
        if (s > H) {
            sidebar.style = "position:fixed;top:210px;"
        } else {
            sidebar.style = ""
        }
    }
}
