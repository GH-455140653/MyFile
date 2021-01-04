//alert("66");
//alert(${zsb});
//alert(byId("sessionList").innerHTML);
function find(str,cha,num){
    var x=str.indexOf(cha);
    for(var i=0;i<num;i++){
        x=str.indexOf(cha,x+1);
    }
    return x;
}

var sessionList = byId("sessionList").innerHTML;// 从Action中赋值的session中拿数据
console.log(sessionList);

var userYear = [];
var userMonth = [];
var userDay = [];

for (var i = 0; i < 11; i++) {
	userYear.push(0);
}
for (var i = 0; i < 12; i++) {
	userMonth.push(0);
}
for (var i = 0; i < 31; i++) {
	userDay.push(0);
}

var jsonList = [];// 将session数组转化成可作为echart数据的专有格式数组
var cc=(sessionList.split(',')).length-1;
console.log(cc);
var ccc=cc+1;
console.log(ccc);
var jsonList = [];//将session数组转化成可作为echart数据的专有格式数组
//for (var j = 1,i=0; j < cc; j = j + 1,i=i+1) {
//	console.log(sessionListv.length);
//	console.log(find(sessionListv,',',i));
//	jsonListv.push(sessionListv.slice(find(sessionListv,',',i)+1,find(sessionListv,',',i+1)+1));
//	if(j==cc-1){jsonListv.push(sessionListv.slice(cc,sessionListv.length));}
//}
for (var i=0; i < ccc; i=i+1) {
	console.log(sessionList.length);
	console.log(find(sessionList,',',i));
	if(i==cc){jsonList.push(sessionList.slice(find(sessionList,',',i-1)+2,sessionList.length-1));}
	else if(i==0){
		console.log(find(sessionList,',',i));jsonList.push(sessionList.slice(1,find(sessionList,',',i)));}
	else jsonList.push(sessionList.slice(find(sessionList,',',i)+2,find(sessionList,',',i+1)));
	
}
dataList = jsonList;
console.log(dataList);

for (var j = 0; j < jsonList.length; j++) {// 为用户表所有年份赋值
	var indexY = parseInt(jsonList[j].substr(0, 4)) - 2015;
	userYear.splice(indexY, 1, userYear[indexY] + 1);
}

// for(var j=0;j<userYear.length;j++){
// console.log(userYear[j]);
// }

// setInterval(function() {
// $("#sessionListDIV").load(location.href+" #sessionListDIV>*","");
// }, 1000);
// 每隔1s自动刷新

// function judgeLogin(){
//   
// $.ajax({
// type: 'Post',
// url: 'table_getUserYear.action',//此处的Action要与struts.xml中的action的name对应
// data: { 'text': 1 },//$("#sessionList").innerHTML
// dataType: 'json',
// async:false,
// success: function (r) {
// alert(99999);
// },
// error: function (err) {
// alert("登陆失败，请检查账号密码");
// location.href = "index_background.jsp";
// }
// });
// }

// var jsonList={};
// for(var i=0;i<sessionList.length;i++){
// jsonList[i]=sessionList[i];
// }
// JSON.stringify(jsonList);
// alert(jsonList);
// 初始化echarts实例
var myChart1 = echarts.init(document.getElementById('Reportuser'));

var xData_year = function() {
	var data = [];
	for (var i = 2015; i <= 2025; i++) {
		data.push(i + "年");
	}
	return data;
}();

var xData_month = function() {
	var data = [];
	for (var i = 1; i <= 12; i++) {
		if (i < 10) {
			data.push("0" + i + "月");
		} else
			data.push(i + "月");
	}
	return data;
}();

var xData_day = function() {
	var data = [];
	for (var i = 1; i <= 31; i++) {
		if (i < 10) {
			data.push("0" + i + "日");
		} else
			data.push(i + "日");
	}
	return data;
}();
// 用户报表年份
var optionuser_year = {
	backgroundColor : "#FFFFFF",
	"title" : {
		"text" : "各年度登录人数",
		x : "4%",

		textStyle : {
			color : '#000000',
			fontSize : '22'
		},
	},
	"tooltip" : {
		"trigger" : "axis",
		"axisPointer" : {
			"type" : "shadow",
			textStyle : {
				color : "#fff"
			}

		},
	},
	"grid" : {
		"borderWidth" : 0,
		"top" : 110,
		"bottom" : 95,
		textStyle : {
			color : "#fff"
		}
	},
	"legend" : {
		x : '4%',
		top : '8%',
		textStyle : {
			color : '#90979c',
		},
		"data" : [ '上半年', '下半年', '平均' ]
	},

	"calculable" : true,
	"xAxis" : [ {
		"type" : "category",
		"axisLine" : {
			lineStyle : {
				color : '#90979c'
			}
		},
		"splitLine" : {
			"show" : false
		},
		"axisTick" : {
			"show" : false
		},
		"splitArea" : {
			"show" : false
		},
		"axisLabel" : {
			"interval" : 0,

		},
		"data" : xData_year,
	} ],
	"yAxis" : [ {
		"type" : "value",
		"splitLine" : {
			"show" : false
		},
		"axisLine" : {
			lineStyle : {
				color : '#90979c'
			}
		},
		"axisTick" : {
			"show" : false
		},
		"axisLabel" : {
			"interval" : 0,

		},
		"splitArea" : {
			"show" : false
		},

	} ],
	"dataZoom" : [
			{
				"show" : true,
				"height" : 30,
				"xAxisIndex" : [ 0 ],
				bottom : 30,
				"start" : 10,
				"end" : 80,
				handleIcon : 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
				handleSize : '110%',
				handleStyle : {
					color : "#d3dee5",

				},
				textStyle : {
					color : "#fff"
				},
				borderColor : "#90979c"

			}, {
				"type" : "inside",
				"show" : true,
				"height" : 15,
				"start" : 1,
				"end" : 35
			} ],
	"series" : [

	{
		"name" : "总数",
		"type" : "bar",
		"stack" : "总量",
		"itemStyle" : {
			"normal" : {
				"color" : "rgba(0,191,183,1)",
				"barBorderRadius" : 0,
				"label" : {
					"show" : true,
					"position" : "inside",
					formatter : function(p) {
						return p.value > 0 ? (p.value) : '';
					}
				}
			}
		},
		"data" : userYear
	/*
	 * [ 327, 1776, 507, 1200, 800, 482, 204, 1390, 1001, 951, 381, 220 ]
	 */
	}, {
		"name" : "总数",
		"type" : "line",
		symbolSize : 10,
		symbol : 'circle',
		"itemStyle" : {
			"normal" : {
				"color" : "rgba(252,230,48,1)",
				"barBorderRadius" : 0,
				"label" : {
					"show" : true,
					"position" : "top",
					formatter : function(p) {
						return p.value > 0 ? (p.value) : '';
					}
				}
			}
		},
		"data" : userYear
	/*
	 * [ 1036, 3693, 2962, 3810, 2519, 1915, 1748, 4675, 6209, 4323, 2865, 4298 ]
	 */
	}, ]
}

// 用户报表月份
var optionuser_month = {
	backgroundColor : "#FFFFFF",
	"title" : {
		"text" : "各月份登录人数",
		x : "4%",

		textStyle : {
			color : '#000000',
			fontSize : '22'
		},
		subtextStyle : {
			color : '#90979c',
			fontSize : '16',

		},
	},
	"tooltip" : {
		"trigger" : "axis",
		"axisPointer" : {
			"type" : "shadow",
			textStyle : {
				color : "#fff"
			}

		},
	},
	"grid" : {
		"borderWidth" : 0,
		"top" : 110,
		"bottom" : 95,
		textStyle : {
			color : "#fff"
		}
	},
	"legend" : {
		x : '4%',
		top : '8%',
		textStyle : {
			color : '#90979c',
		},
		"data" : [ '女', '男', '平均' ]
	},

	"calculable" : true,
	"xAxis" : [ {
		"type" : "category",
		"axisLine" : {
			lineStyle : {
				color : '#90979c'
			}
		},
		"splitLine" : {
			"show" : false
		},
		"axisTick" : {
			"show" : false
		},
		"splitArea" : {
			"show" : false
		},
		"axisLabel" : {
			"interval" : 0,

		},
		"data" : xData_month,
	} ],
	"yAxis" : [ {
		"type" : "value",
		"splitLine" : {
			"show" : false
		},
		"axisLine" : {
			lineStyle : {
				color : '#90979c'
			}
		},
		"axisTick" : {
			"show" : false
		},
		"axisLabel" : {
			"interval" : 0,

		},
		"splitArea" : {
			"show" : false
		},

	} ],
	"dataZoom" : [
			{
				"show" : true,
				"height" : 30,
				"xAxisIndex" : [ 0 ],
				bottom : 30,
				"start" : 10,
				"end" : 80,
				handleIcon : 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
				handleSize : '110%',
				handleStyle : {
					color : "#d3dee5",

				},
				textStyle : {
					color : "#fff"
				},
				borderColor : "#90979c"

			}, {
				"type" : "inside",
				"show" : true,
				"height" : 15,
				"start" : 1,
				"end" : 35
			} ],
	"series" : [

	{
		// "name": "总量",
		"type" : "bar",
		// "stack": "总量",
		"itemStyle" : {
			"normal" : {
				"color" : "rgba(0,191,183,1)",
				"barBorderRadius" : 0,
				"label" : {
					"show" : true,
					"position" : "inside",
					formatter : function(p) {
						return p.value > 0 ? (p.value) : '';
					}
				}
			}
		},
		"data" : userMonth
	/*
	 * [ 103, 369, 296, 381, 251, 191, 174, 467, 620, 432, 286, 429 ]
	 */
	}, {
		"name" : "总数",
		"type" : "line",
		symbolSize : 10,
		symbol : 'circle',
		"itemStyle" : {
			"normal" : {
				"color" : "rgba(252,230,48,1)",
				"barBorderRadius" : 0,
				"label" : {
					"show" : true,
					"position" : "top",
					formatter : function(p) {
						return p.value > 0 ? (p.value) : '';
					}
				}
			}
		},
		"data" : userMonth
	/*
	 * [ 103, 369, 296, 381, 251, 191, 174, 467, 620, 432, 286, 429 ]
	 */
	}, ]
}

// 用户报表天份
var optionuser_day = {
	backgroundColor : "#FFFFFF",
	"title" : {
		"text" : "各天份登录人数",
		x : "4%",

		textStyle : {
			color : '#000000',
			fontSize : '22'
		},
		subtextStyle : {
			color : '#90979c',
			fontSize : '16',

		},
	},
	"tooltip" : {
		"trigger" : "axis",
		"axisPointer" : {
			"type" : "shadow",
			textStyle : {
				color : "#fff"
			}

		},
	},
	"grid" : {
		"borderWidth" : 0,
		"top" : 110,
		"bottom" : 95,
		textStyle : {
			color : "#fff"
		}
	},
	"legend" : {
		x : '4%',
		top : '8%',
		textStyle : {
			color : '#90979c',
		},
		"data" : [ '女', '男', '平均' ]
	},

	"calculable" : true,
	"xAxis" : [ {
		"type" : "category",
		"axisLine" : {
			lineStyle : {
				color : '#90979c'
			}
		},
		"splitLine" : {
			"show" : false
		},
		"axisTick" : {
			"show" : false
		},
		"splitArea" : {
			"show" : false
		},
		"axisLabel" : {
			"interval" : 0,

		},
		"data" : xData_day,
	} ],
	"yAxis" : [ {
		"type" : "value",
		"splitLine" : {
			"show" : false
		},
		"axisLine" : {
			lineStyle : {
				color : '#90979c'
			}
		},
		"axisTick" : {
			"show" : false
		},
		"axisLabel" : {
			"interval" : 0,

		},
		"splitArea" : {
			"show" : false
		},

	} ],
	"dataZoom" : [
			{
				"show" : true,
				"height" : 30,
				"xAxisIndex" : [ 0 ],
				bottom : 30,
				"start" : 10,
				"end" : 80,
				handleIcon : 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
				handleSize : '110%',
				handleStyle : {
					color : "#d3dee5",

				},
				textStyle : {
					color : "#fff"
				},
				borderColor : "#90979c"

			}, {
				"type" : "inside",
				"show" : true,
				"height" : 15,
				"start" : 1,
				"end" : 35
			} ],
	"series" : [

	{
		// "name": "总量",
		"type" : "bar",
		// "stack": "总量",
		"itemStyle" : {
			"normal" : {
				"color" : "rgba(0,191,183,1)",
				"barBorderRadius" : 0,
				"label" : {
					"show" : true,
					"position" : "inside",
					formatter : function(p) {
						return p.value > 0 ? (p.value) : '';
					}
				}
			}
		},
		"data" : userDay
	/*
	 * [ 10, 36, 29, 38, 25, 19, 17, 46, 62, 43, 28, 42 ]
	 */
	}, {
		"name" : "总数",
		"type" : "line",
		symbolSize : 10,
		symbol : 'circle',
		"itemStyle" : {
			"normal" : {
				"color" : "rgba(252,230,48,1)",
				"barBorderRadius" : 0,
				"label" : {
					"show" : true,
					"position" : "top",
					formatter : function(p) {
						return p.value > 0 ? (p.value) : '';
					}
				}
			}
		},
		"data" : userDay
	/*
	 * [ 10, 36, 29, 38, 25, 19, 17, 46, 62, 43, 28, 42 ]
	 */
	}, ]
}

// 点击用户柱状图弹窗
myChart1
		.on(
				'click',
				function(params) {
					switch (byId("reportback").innerHTML) {
					case "年度报表":
						// alert("66");
						for (var j = 0; j < jsonList.length; j++) {// 为用户表所有月份赋值
							if (parseInt(jsonList[j].substr(0, 4)) == xData_year[params.dataIndex]
									.substr(0, 4)) {
								var indexM = parseInt(jsonList[j].substr(5, 7)) - 1;
								userMonth.splice(indexM, 1,
										userMonth[indexM] + 1);
								// alert(parseInt(jsonList[j].substr(0,4)));
								// 2015
								// alert(xData_year[params.dataIndex].substr(0,4));
							}
						}

						myChart1.clear();

						myChart1.setOption(optionuser_month);

						for (var j = 0; j < userMonth.length; j++) {// 用完之后数组归零
							userMonth.splice(j, 1, 0);
						}
						byId("uy").innerHTML = xData_year[params.dataIndex]
								.substr(0, 4);
						// alert(byId("uy").innerHTML);

						byId("reportback").style.display = "inline-block";
						byId("reportback").innerHTML = "返回用户年度报表";
						break;
					case "返回用户年度报表":
						// alert("66");
						for (var j = 0; j < jsonList.length; j++) {// 为用户表所有月份赋值
							if (parseInt(jsonList[j].substr(5, 7)) == xData_month[params.dataIndex]
									.substr(0, 2)
									&& parseInt(jsonList[j].substr(0, 4)) == byId("uy").innerHTML) {
								// alert(parseInt(jsonList[j].substr(5,7)));
								// alert(xData_month[params.dataIndex].substr(0,2));
								var indexD = parseInt(jsonList[j].substr(8, 10)) - 1;
								userDay.splice(indexD, 1, userDay[indexD] + 1);
								// alert(parseInt(jsonList[j].substr(0,4)));
								// 2015
								// alert(xData_year[params.dataIndex].substr(0,4));
							}
						}
						myChart1.clear();
						myChart1.setOption(optionuser_day);

						for (var j = 0; j < userDay.length; j++) {// 用完之后数组归零
							userDay.splice(j, 1, 0);
						}
						byId("um").innerHTML = xData_month[params.dataIndex]
						.substr(0, 2);

						byId("reportback").style.display = "inline-block";
						byId("reportback").innerHTML = "返回用户月度报表";
						break;
					default:
						break;
					}
				});

addHandler(byId("reportback"), "click", function() {
	var buttonText = byId("reportback").innerHTML;
	// alert(buttonText);
	switch (buttonText) {

	case "返回用户年度报表":
		// alert("66");
		byId("uy").innerHTML ="";
		myChart1.clear();
		myChart1.setOption(optionuser_year);
		byId("reportback").innerHTML = "年度报表";
		byId("reportback").style.display = "none";
		byId("video-report").style.display = "inline-block";
		byId("user-report").style.display = "inline-block";
		break;
	case "返回用户月度报表":
		byId("um").innerHTML ="";
		for (var j = 0; j < jsonList.length; j++) {
			if (parseInt(jsonList[j].substr(0, 4)) == byId("uy").innerHTML) {
				var indexM = parseInt(jsonList[j].substr(5, 7)) - 1;
				userMonth.splice(indexM, 1, userMonth[indexM] + 1);
				// alert(parseInt(jsonList[j].substr(0,4))); 2015
				// alert(xData_year[params.dataIndex].substr(0,4));
			}
		}
		myChart1.clear();
		// alert("66");
		myChart1.setOption(optionuser_month);

		for (var j = 0; j < userMonth.length; j++) {// 用完之后数组归零
			userMonth.splice(j, 1, 0);
		}

		byId("reportback").innerHTML = "返回用户年度报表";
		break;
	default:
		break;
	}
})

// 使用刚指定的配置项和数据显示图表。
myChart1.setOption(optionuser_year);

function addHandler(element, type, handler) {
	// 非IE浏览器
	if (element.addEventListener) {
		element.addEventListener(type, handler, true);
	}
	// IE浏览器支持DOM2级
	else if (element.attachEvent) {
		element.attachEvent("on" + type, handler);
	}
	// IE浏览器不支持DOM2级
	else {
		element["on" + type] = handler;
	}
}

// 封装getElementById()
function byId(id) {
	return typeof (id) == "string" ? document.getElementById(id) : id;
}

// 下面是图片下载

// base64转blob
function base64ToBlob(code) {
	var parts = code.split(';base64,');
	var contentType = parts[0].split(':')[1];
	var raw = window.atob(parts[1]);
	var rawLength = raw.length;

	var uInt8Array = new Uint8Array(rawLength);

	for (var i = 0; i < rawLength; ++i) {
		uInt8Array[i] = raw.charCodeAt(i);
	}
	return new Blob([ uInt8Array ], {
		type : contentType
	});
}
function saveAsImage() {
	var content = myChart1.getDataURL();
	console.log(myChart1.getDataURL());
	var aLink = document.createElement('a');
	var blob = this.base64ToBlob(content);

	var evt = document.createEvent("HTMLEvents");
	evt.initEvent("click", true, true);
	aLink.download = byId("uy").innerHTML+byId("um").innerHTML+"用户登录数报表.png";
	aLink.href = URL.createObjectURL(blob);
	aLink.dispatchEvent(new MouseEvent('click', {
		bubbles : true,
		cancelable : true,
		view : window
	}));
}
