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


var sessionListv = byId("sessionListv").innerHTML;//从Action中赋值的session中拿数据
// alert(sessionListv);
var sessionListc = byId("sessionListc").innerHTML;//从Action中赋值的session中拿数据



console.log(sessionListv);
console.log(sessionListc);


var videoYear = [];
var videoMonth = [];
var videoDay = [];

for (var i = 0; i < 11; i++) {
	videoYear.push(0);
}
for (var i = 0; i < 12; i++) {
	videoMonth.push(0);
}
for (var i = 0; i < 31; i++) {
	videoDay.push(0);
}
var cc=(sessionListv.split(',')).length-1;
console.log(cc);
var ccc=(cc+1)/2;
console.log(ccc);
var jsonListv = [];//将session数组转化成可作为echart数据的专有格式数组
//for (var j = 1,i=0; j < cc; j = j + 1,i=i+1) {
//	console.log(sessionListv.length);
//	console.log(find(sessionListv,',',i));
//	jsonListv.push(sessionListv.slice(find(sessionListv,',',i)+1,find(sessionListv,',',i+1)+1));
//	if(j==cc-1){jsonListv.push(sessionListv.slice(cc,sessionListv.length));}
//}
for (var i=0; i < cc; i=i+2) {
	console.log(sessionListv.length);
	console.log(find(sessionListv,',',i));
	if(i==cc){jsonListv.push(sessionListv.slice(find(sessionListv,',',cc)+2,sessionListv.length-1));}
	else
	jsonListv.push(sessionListv.slice(find(sessionListv,',',i)+2,find(sessionListv,',',i+1)));
	
}
dataListv = jsonListv;
console.log(dataListv);

for (var j = 0; j < jsonListv.length; j++) {//为用户表所有年份赋值
	console.log(jsonListv[j].substr(0, 4));
	var indexY = parseInt(jsonListv[j].substr(0, 4)) - 2015;
	console.log(indexY);
	videoYear.splice(indexY, 1, videoYear[indexY] + 1);
}
console.log(videoYear);

var jsonListvc = [];//将session数组转化成可作为echart数据的专有格式数组

for (var i=0; i < cc; i=i+2) {
	console.log(sessionListv.length);
	console.log(find(sessionListv,',',i));
	if(i==cc){
//		jsonListvc.push(sessionListv.slice(find(sessionListv,',',cc)+2,sessionListv.length-1));
	}else if(i==0){
		jsonListvc.push(sessionListv.slice(1,find(sessionListv,',',i)));
	}else{
		jsonListvc.push(sessionListv.slice(find(sessionListv,',',i-1)+2,find(sessionListv,',',i)));
	}
	
}
//jsonListvc.push(sessionListv.slice(j, j +1));
dataListvc = jsonListvc;
console.log(dataListvc);











var stringResult = sessionListc.split(',');
for(var i =0;i<stringResult.length;i++){
	stringResult[i]=stringResult[i].substr(1);
	if(i==stringResult.length-1){
		stringResult[i]=stringResult[i].substr(0,stringResult[i].length-1);
	}else continue;
}
console.log(stringResult);
var sessionListcid=[]; 
for(var i =0;i<stringResult.length;i++){
	if(i%2==0){
		sessionListcid.push(stringResult[i]);
	}else continue;
}console.log(sessionListcid);
var sessionListcname=[]; 
for(var i =0;i<stringResult.length;i++){
	if(i%2!=0){
		sessionListcname.push(stringResult[i]);
	}else continue;
}console.log(sessionListcname);


var jsonListcid = [];//将session数组转化成可作为echart数据的专有格式数组
for (var j = 0; j < sessionListcid.length; j++) {
	jsonListcid.push(sessionListcid[j]);
}
dataListcid = jsonListcid;
console.log(dataListcid);

var jsonListcname = [];//将session数组转化成可作为echart数据的专有格式数组
for (var j = 0; j < sessionListcname.length; j++) {
	jsonListcname.push(sessionListcname[j]);
}
dataListcname = jsonListcname;
console.log(dataListcname);



var videoEveryDay = [];

for (var i = 0; i < dataListcname.length; i++) {
	videoEveryDay.push(0);
}
//for(var j=0;j<userYear.length;j++){
//	console.log(userYear[j]);
//}

//setInterval(function() { 
//    $("#sessionListDIV").load(location.href+" #sessionListDIV>*",""); 
//}, 1000);
//每隔1s自动刷新

//function judgeLogin(){
//   
//    $.ajax({
//            type: 'Post',
//            url: 'table_getUserYear.action',//此处的Action要与struts.xml中的action的name对应
//            data: { 'text': 1 },//$("#sessionList").innerHTML
//            dataType: 'json',
//            async:false,
//            success: function (r) {
//            	alert(99999);
//            },
//            error: function (err) {
//                alert("登陆失败，请检查账号密码");
//                location.href = "index_background.jsp";
//            }
//        });
//}

//var jsonList={};
//for(var i=0;i<sessionList.length;i++){
//	jsonList[i]=sessionList[i];
//}
//JSON.stringify(jsonList);
//alert(jsonList);
// 初始化echarts实例
var myChart2 = echarts.init(document.getElementById('Reportvideo'));

var Reporvideo = document.getElementById('video-report');

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

//视频报表年份
var optionvideo_year = {
	backgroundColor : "#FFFFFF",
	"title" : {
		"text" : "各年度视频上传个数",
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
		"data" : videoYear
	/*[0, 4, 0, 0, 0, 1, 0, 0, 0, 0, 2]*//*[ 1036, 3693, 2962, 3810, 2519, 1915, 1748, 4675,
							6209, 4323, 2865, 4298 ]*/

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
		"data" : videoYear
	/*[0, 4, 0, 0, 0, 1, 0, 0, 0, 0, 2]*//*[ 1036, 3693, 2962, 3810, 2519, 1915, 1748, 4675,
							6209, 4323, 2865, 4298 ]*/
	}, ]
}


//视频报表月份
var optionvideo_month = {
	backgroundColor : "#FFFFFF",
	"title" : {
		"text" : "各月份视频上传个数",
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
		"data" : videoMonth
	/*[ 103, 369, 296, 381, 251, 191, 174, 467,
							620, 432, 286, 429 ]*/
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
		"data" : videoMonth
	/*[ 103, 369, 296, 381, 251, 191, 174, 467,
								620, 432, 286, 429 ]*/
	}, ]
}

//视频报表天份
var optionvideo_day = {
	backgroundColor : "#FFFFFF",
	"title" : {
		"text" : "每天视频上传个数",
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
		"data" : videoDay
	/*[ 10, 36, 29, 38, 25, 19, 17, 46,
						62, 43, 28, 42 ]*/
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
		"data" : videoDay
	/*[ 10, 36, 29, 38, 25, 19, 17, 46,
							62, 43, 28, 42 ]*/
	}, ]
}

//视频报表每天
var legend = dataListcname/*['特色产业扶贫', '生态补偿扶贫', '劳务协助扶贫', '社会保障兜底扶贫',
              '危房改造脱贫', '医疗保障与社会保障扶贫', '教育助学扶贫', '异地搬迁扶贫', '金融扶贫', '饮水安全'
          ]*/;

          var data = [];//videoEveryDay
          for (var i = 0; i < videoEveryDay.length; i++) {
              data.push({
                  name: legend[i],
                  value: videoEveryDay[i]//(Math.random() * 100000).toFixed(0)
              });
              console.log(videoEveryDay[i]);
          }
          console.log(data);

          optionvideo_everyday = {
              backgroundColor: '#FFFFFF',
              color: ['#2AC9FD', '#76FBC0', '#35C96E', '#FCC708', '#48B188', '#5957C2', '#4A5D73'],
              tooltip: { //提示框
                  trigger: "item",
                  triggerOn: "mousemove",
                  backgroundColor: "rgba(1,70,86,1)",
                  borderColor: "rgba(0,246,255,1)",
                  borderWidth: 0.5,
                  textStyle: {
                      fontSize: 14
                  }
              },
              title: [{
                  text: 18653,
                  subtext: '救助人口',
                  textStyle: {
                      fontSize: 20,
                      color: "#fff"
                  },
                  subtextStyle: {
                      fontSize: 20,
                      color: '#fff'
                  },
                  textAlign: "center",
                  x: '50%',
                  y: '47%',
              }],
              series: [{
                      color: ['#2AC9FD', '#76FBC0', '#35C96E', '#FCC708', '#48B188', '#5957C2'],
                      type: 'pie',
                      radius: ['62', '100'],
                      labelLine: {
                          normal: {
                              length: 25,
                              length2: 120,
                              lineStyle: {
                                  type: 'solid'
                              }
                          }
                      },
                      label: {
                          normal: {
                              formatter: (params) => {
                                  console.log(params);
                                  return '{b| ' + params.name + '}  ' + '{c|' + params.percent.toFixed(0) + '%}'
                              },
                              borderWidth: 0,
                              borderRadius: 4,
                              padding: [0, -86],
                              height: 70,
                              fontSize: 13,
                              align: 'center',
                              color: '#3494BD',
                              rich: {
                                  b: {
                                      fontSize: 12,
                                      lineHeight: 20,
                                      color: '#41B3DC',
                                      padding: [0, 0, 5, 0]
                                  },
                                  c: {
                                      fontSize: 20,
                                      lineHeight: 20,
                                      color: 'orange'
                                  }

                              }
                          }
                      },
                      data: data,
                  },
                  {
                      type: 'pie',
                      radius: ['50', '51'],
                      data: [100],
                      label: {
                          show: false
                      }
                  }
              ]
          };
          
          
          
          
//点击视频柱状图弹窗
myChart2
		.on(
				'click',
				function(params) {
					//	alert("点击了"+xData[params.dataIndex]);
					switch (byId("reportback").innerHTML) {
					case "年度报表":
						//		alert("66");
						//		byId("sessionListFORM").action = "http://localhost:8080/ssh_NGU/Table/table_getUserMonth?uyear=2011";
						//		alert(989979);
						//		byId("sessionList").innerHTML=${userYearR};
						for (var j = 0; j < jsonListv.length; j++) {//为用户表所有月份赋值
							if (parseInt(jsonListv[j].substr(0, 4)) == xData_year[params.dataIndex]
									.substr(0, 4)) {
								var indexM = parseInt(jsonListv[j].substr(5, 7)) - 1;
								videoMonth.splice(indexM, 1,
										videoMonth[indexM] + 1);
								//				alert(parseInt(jsonList[j].substr(0,4)));  2015
								//				alert(xData_year[params.dataIndex].substr(0,4));
							}
						}
						//		console.log(optionvideo_month.title);
						//		optionvideo_month.title=xData_year[params.dataIndex].substr(0,4)+"各月份视频上传数";
						//		console.log(optionvideo_month.title);
						myChart2.clear();
						//		vmt=xData_year[params.dataIndex].substr(0,4)+"年"+vmt;
						//		console.log(option_month.title.text);
						myChart2.setOption(optionvideo_month);
						for (var j = 0; j < videoMonth.length; j++) {//用完之后数组归零
							videoMonth.splice(j, 1, 0);
						}
						byId("vy").innerHTML = xData_year[params.dataIndex]
								.substr(0, 4);

						byId("reportback").style.display = "inline-block";
						byId("reportback").innerHTML = "返回视频年度报表";
						break;
					case "返回视频年度报表":
						//		alert("66");
						for (var j = 0; j < jsonListv.length; j++) {//为用户表所有月份赋值
							if (parseInt(jsonListv[j].substr(5, 7)) == xData_month[params.dataIndex]
									.substr(0, 2)
									&& parseInt(jsonListv[j].substr(0, 4)) == byId("vy").innerHTML) {
								//				alert(parseInt(jsonList[j].substr(5,7)));
								//				alert(xData_month[params.dataIndex].substr(0,2));
								var indexD = parseInt(jsonListv[j]
										.substr(8, 10)) - 1;
								videoDay
										.splice(indexD, 1, videoDay[indexD] + 1);
								//				alert(parseInt(jsonList[j].substr(0,4)));  2015
								//				alert(xData_year[params.dataIndex].substr(0,4));
							}
						}
						myChart2.setOption(optionvideo_day);

						for (var j = 0; j < videoDay.length; j++) {//用完之后数组归零
							videoDay.splice(j, 1, 0);
						}
						byId("vm").innerHTML = xData_month[params.dataIndex]
								.substr(0, 2);
						//		console.log(byId("um").innerHTML+"*/*/-*/-/-*/-*/-*/-/-*/-/-*/-*/-*/-*/-*");

						byId("reportback").style.display = "inline-block";
						byId("reportback").innerHTML = "返回视频月度报表";
						break;
					case "返回视频月度报表":
						//		alert("66");
						for (var j = 0; j < jsonListv.length; j++) {//为用户表所有月份赋值
							if (parseInt(jsonListv[j].substr(8, 10)) == xData_day[params.dataIndex].substr(0, 2)
									&& parseInt(jsonListv[j].substr(0, 4)) == byId("vy").innerHTML
									&& parseInt(jsonListv[j].substr(5, 7)) == byId("vm").innerHTML) {
//												alert(6);
								console.log(j)
								console.log(jsonListv[j]);
								var indexED =dataListvc[j]-1;
								console.log(j);	
								console.log(dataListcid[j]);
								videoEveryDay
										.splice(dataListcid.indexOf(dataListvc[j]), 1, videoEveryDay[dataListcid.indexOf(dataListvc[j])] + 1);
								console.log(dataListcid.indexOf(dataListvc[j]));
								console.log(videoEveryDay)
								//				alert(parseInt(jsonList[j].substr(0,4)));  2015
								//				alert(xData_year[params.dataIndex].substr(0,4));
							}
						}
						  data.length=0;
				          for (var i = 0; i < videoEveryDay.length; i++) {
				              data.push({
				                  name: legend[i],
				                  value: videoEveryDay[i]//(Math.random() * 100000).toFixed(0)
				              });
				              console.log(videoEveryDay[i]+"*"+i);
				          }
				          console.log(data);
						myChart2.clear();
						myChart2.setOption(optionvideo_everyday);
						for (var j = 0; j < videoEveryDay.length; j++) {//用完之后数组归零
							videoEveryDay.splice(j, 1, 0);
						}
						byId("vd").innerHTML = xData_day[params.dataIndex]
						.substr(0, 2);
						byId("reportback").style.display = "inline-block";
						byId("reportback").innerHTML = "返回视频天度报表";
						break;
					default:
						break;
					}

				});

addHandler(
		byId("reportback"),
		"click",
		function() {
			var buttonText = byId("reportback").innerHTML;
			//	alert(buttonText);
			switch (buttonText) {
			case "返回视频年度报表":
				data.length=0;
				byId("vy").innerHTML ="";
				//			alert("66");
				myChart2.setOption(optionvideo_year);
				byId("reportback").innerHTML = "年度报表";
				byId("reportback").style.display = "none";
				byId("user-report").style.display = "inline-block";
				byId("video-report").style.display = "inline-block";
				
				break;
			case "返回视频月度报表":
				data.length=0;
				//			alert("66");
				for (var j = 0; j < jsonListv.length; j++) {
					if (parseInt(jsonListv[j].substr(0, 4)) == byId("vy").innerHTML) {
						var indexM = parseInt(jsonListv[j].substr(5, 7)) - 1;
						videoMonth.splice(indexM, 1, videoMonth[indexM] + 1);
						//					alert(parseInt(jsonList[j].substr(0,4)));  2015
						//					alert(xData_year[params.dataIndex].substr(0,4));
					}
				}
				myChart2.clear();
				myChart2.setOption(optionvideo_month);

				for (var j = 0; j < videoMonth.length; j++) {//用完之后数组归零
					videoMonth.splice(j, 1, 0);
				}

				byId("reportback").innerHTML = "返回视频年度报表";
				byId("vm").innerHTML ="";
				break;
			case "返回视频天度报表":
				//			alert("66");
				data.length=0;
				for (var j = 0; j < jsonListv.length; j++) {
					if (parseInt(jsonListv[j].substr(0, 4)) == byId("vy").innerHTML
							&& parseInt(jsonListv[j].substr(5, 7)) == byId("vm").innerHTML) {
						//					alert(9);
						var indexM = parseInt(jsonListv[j].substr(8, 10)) - 1;
						videoDay.splice(indexM, 1, videoDay[indexM] + 1);
						//					alert(parseInt(jsonList[j].substr(0,4)));  2015
						//					alert(xData_year[params.dataIndex].substr(0,4));
					}
				}
				myChart2.clear();
				myChart2.setOption(optionvideo_day);
				for (var j = 0; j < videoDay.length; j++) {//用完之后数组归零
					videoDay.splice(j, 1, 0);
				}
				byId("reportback").innerHTML = "返回视频月度报表";
				byId("vd").innerHTML ="";
				break;

			default:
				break;
			}
		})

// 使用刚指定的配置项和数据显示图表。
myChart2.setOption(optionvideo_year);
byId("Reportuser").style.display = "none";
document.getElementById('ReportContral').style.display = "none";

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

//下面是图片下载

//base64转blob
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
	var content = myChart2.getDataURL();
	console.log(myChart2.getDataURL());
	var aLink = document.createElement('a');
	var blob = this.base64ToBlob(content);

	var evt = document.createEvent("HTMLEvents");
	evt.initEvent("click", true, true);
	aLink.download = byId("vy").innerHTML+byId("vm").innerHTML+byId("vd").innerHTML+"视频上传数报表.png";
	
	aLink.href = URL.createObjectURL(blob);
	aLink.dispatchEvent(new MouseEvent('click', {
		bubbles : true,
		cancelable : true,
		view : window
	}));
}
