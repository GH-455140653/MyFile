function $(id) {
    return document.getElementById(id);
}

function showTime() {/*文字时钟*/
    var now = new Date();
    var y = now.getFullYear();
    var m = now.getMonth() + 1;
    var d = now.getDate();
    var h = now.getHours();
    var mi = now.getMinutes();
    if (mi < 10) {
        mi = "0" + mi;
    }
    var s = now.getSeconds();
    var str = y + "年" + m + "月" + d + "日 " + h + ":" + mi + ":" + s;
    document.getElementById("showtime").innerHTML = str;
    document.getElementById("showtime2").innerHTML = str;
    setTimeout('showTime()', 1000);
}