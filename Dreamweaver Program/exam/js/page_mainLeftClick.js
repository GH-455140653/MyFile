$(function () {//构建jq匿名函数
    $('.lists').click(function () {//获取lists下的项目点击事件
        var len = $('.lists').length;//获取列表长度
        var num = $(this).index();//获取列表项的指定索引
        $('#main_right>div').eq(len).css("display", "none");//特殊处理默认的div
        for (var i = 0; i < len; i++) {
            if (i === num) {
                $('#main_right div').eq(i).css("display", "block");//修改指定div的css.display样式，显示div
            } else {
                $('#main_right div').eq(i).css("display", "none");//修改指定div的css.display样式，隐藏div
            }
        }
    })
})