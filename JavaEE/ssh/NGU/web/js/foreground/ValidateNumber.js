//验证码生成

var code_box = document.getElementById("verifyNum");

function refreshCode() {
    var code = '0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM',//62个字符 随机选择4位
        char = '',
        result = '';
    for (var i = 0; i < 4; i++) {
        //随机选择一位  （0,61） 写出0到61的随机的索引数字
        var code_index = Math.round(Math.random() * 61);
        //得到随机的索引  取出随机地字符
        char = code[code_index];
        //随机取出的字符 存在几个相同重复的问题 ，而且对于字母，不能区分大小写。
        // 避免重复的思路是：取出字符之后,和最后的result对比一下，看看里边是不是已经存在了，如果存在本次循环就终止，进行下一次
        if (result.toUpperCase().indexOf(char.toUpperCase()) > -1)
            //indexOf() == -1 说明结果里边没有要找的字符 那么 > -1 就是 里边有重复的字符
        {
            i--;
            //为什么会 --？ 因为如果条件成立，那么本轮循环就结束进行下一轮循环（自然i就加1了），那么本轮本应该取出的字符就没有了
            //到最后会少一个字符 缺席
            continue;//终止本轮循环 进行下一轮
        }
        result += char;
    }
    code_box.innerHTML = result;
    document.getElementById("number").value = result;
}

//点击事件
code_box.onclick = refreshCode;