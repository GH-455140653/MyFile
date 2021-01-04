// $(function () {
//     setInterval("show();", 1000); //每隔一秒运行一次
// })

// function show() {
//     document.getElementById('click').innerHTML = showday();
// }

// function showday() { //输出当前时间
//     var d = new Date();
//     var year = d.getFullYear();
//     var month = d.getMonth() + 1;
//     var day = d.getDate();
//     var week = d.getDay();
//     switch (week) {
//         case 0:
//             week = "日";
//             break;
//         case 1:
//             week = "一";
//             break;
//         case 2:
//             week = "二";
//             break;
//         case 3:
//             week = "三";
//             break;
//         case 4:
//             week = "四";
//             break;
//         case 5:
//             week = "五";
//             break;
//         case 6:
//             week = "六";
//             break;
//     }
//     var hour = d.getHours();
//     var min = d.getMinutes();
//     var seconds = d.getSeconds();
//     // return alert("北京时间：" + year + "年" + month + "月" + day + "日" + " 星期" + week + " " + hour + "时" + min + "分" + seconds + "秒");
//     return ("北京时间：" + year + "年" + month + "月" + day + "日" + " 星期" + week + " " + hour + "时" + min + "分" + seconds + "秒");
// }

/*-------------------------------------------------*/

// var dom=document.getElementById('clock');
// var ctx=dom.getContext('2d');
// var width=ctx.canvas.width;
// var height=ctx.canvas.height;
// var r=width/2;
// function drawBackground(){
// 	ctx.save();
// 	ctx.translate(r,r)
// 	ctx.beginPath();
// 	ctx.lineWidth=10;
// 	ctx.arc(0,0,r-5,0,2*Math.PI,false);
// 	ctx.stroke();
// 	var hourNumbers=[3,4,5,6,7,8,9,10,11,12,1,2];
// 	ctx.font='18px Arial';
// 	ctx.textAlign='center';
// 	ctx.textBaseline='middle';
// 	hourNumbers.forEach(function(number,i){
// 		var rad=2*Math.PI/12*i;
// 		var x=Math.cos(rad)*(r-30);
// 		var y=Math.sin(rad)*(r-30);
// 		ctx.fillText(number,x,y);

// 	});
// 	for(var i=0;i<60;i++){
// 		var rad=2*Math.PI/60*i;
// 		var x=Math.cos(rad)*(r-18);
// 		var y=Math.sin(rad)*(r-18);
// 		ctx.beginPath();
// 		if(i%5==0){
// 			ctx.fillStyle='#000';
// 			ctx.arc(x,y,2,0,2*Math.PI,false);
// 		}else{
// 			ctx.fillStyle='#ccc';
// 			ctx.arc(x,y,2,0,2*Math.PI,false);
// 		}
// 		ctx.fill();
// 	}
// }
// 	function drawHour(hour,minute){
// 		ctx.save();
// 		ctx.beginPath();
// 		var rad=2*Math.PI/12*hour;
// 		var mrad=2*Math.PI/12/60*minute;
// 		ctx.rotate(rad+mrad);
// 		ctx.lineWidth=6;
// 		ctx.lineCap='round';
// 		ctx.moveTo(0,10);
// 		ctx.lineTo(0,-r/2);
// 		ctx.stroke();
// 		ctx.restore();
// 	}
// 	function drawMinute(minute){
// 		ctx.save();
// 		ctx.beginPath();
// 		var rad=2*Math.PI/60*minute;
// 		ctx.rotate(rad);
// 		ctx.lineWidth=3;
// 		ctx.lineCap='round';
// 		ctx.moveTo(0,10);
// 		ctx.lineTo(0,-r+30);
// 		ctx.stroke();
// 		ctx.restore();
// 	}
// 	function drawSecond(second){
// 		ctx.save();
// 		ctx.beginPath();
// 		ctx.fillStyle='#c14543';
// 		var rad=2*Math.PI/60*second;
// 		ctx.rotate(rad);
// 		ctx.moveTo(-2,20);
// 		ctx.lineTo(2,20);
// 		ctx.lineTo(1,-r+18);
// 		ctx.lineTo(-1,-r+18);
// 		ctx.fill();
// 		ctx.restore();
// 	}
// 	function drawDot(){
// 		ctx.beginPath();
// 		ctx.fillStyle="#fff";
// 		ctx.arc(0,0,3,0,2*Math.PI,false);
// 		ctx.fill();
// 	}
//  function draw(){
//  ctx.clearRect(0,0,width,height);
// var now =new Date();
// var hour=now.getHours();
// var minute=now.getMinutes();
// var second=now.getSeconds();
// drawBackground();
// drawHour(hour,minute);
// drawMinute(minute);
// drawSecond(second);
// drawDot();
// ctx.restore();
//  }
//  draw();
//  setInterval(draw,1000);//每秒执行代码

/*-------------------------------------------------*/
// function change() {
//     var myDate = new Date();
//     // 获取JS时间对象
//     var mytime = myDate.toLocaleString();
//     // 将当前时间转换为String值
//     document.getElementById('time').innerHTML=mytime;
//     // 将当前时间（String）写入到HTML中,这个“time”和<h1>中的id一致
// }
// change();
// setInterval("change()", 1000);
// // 定时更新HTML文档，每秒更新一次


var newDate = '';
getLangDate();
function dateFilter(date){ //值小于10时，在前面补0
    if(date < 10){
        return "0"+date;
    }
    return date;
}

function getLangDate(){
    var dateObj = new Date(); //表示当前系统时间的Date对象
    var year = dateObj.getFullYear(); //当前系统时间的完整年份值
    var month = dateObj.getMonth()+1; //当前系统时间的月份值
    var date = dateObj.getDate(); //当前系统时间的月份中的日
    var day = dateObj.getDay(); //当前系统时间中的星期值
    var weeks = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
    var week = weeks[day]; //根据星期值，从数组中获取对应的星期字符串
    var hour = dateObj.getHours(); //当前系统时间的小时值
    var minute = dateObj.getMinutes(); //当前系统时间的分钟值
    var second = dateObj.getSeconds(); //当前系统时间的秒钟值
    var timeValue = "" +((hour >= 12) ? (hour >= 18) ? "晚上" : "下午" : "上午" ); //当前时间属于上午、晚上还是下午
    newDate = dateFilter(year)+"-"+dateFilter(month)+"-"+dateFilter(date)+" "+dateFilter(hour)+":"+dateFilter(minute)+":"+dateFilter(second);
    document.getElementById("nowTime").innerHTML = "现在是北京时间： "+newDate+"　"+week;
    setTimeout(getLangDate,1000);
}