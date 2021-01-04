function getStyle(el, property) {//处理浏览器对获取节点的style的兼容性问题
    if (getComputedStyle) {
        return getComputedStyle(el)[property];//获取当前属性，IE8以前不可用
    } else {
        return el.currentStyle[property];
    }
}

function animate(el, properties) {//el是为修改节点，properties为节点对象
    clearInterval(el.timerId);
    el.timerId = setInterval(function () {
        for (var property in properties) {//通过极小的时间20ms实现人眼看不到的延时达到动态效果
            var current;
            var target = properties[property];
            if (property === 'opacity') {
                current = Math.round(parseFloat(getStyle(el, 'opacity')) * 100);//*100为了计算数据可观，后期还是要/100的
            } else {
                current = parseInt(getStyle(el, property));
            }

            var speed = (target - current) / 30;//实现由快到慢
            //地板取值避免speed为小于1的小数导致结果永远不能相等，天花取值则是对speed的负数操作
            speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);
            if (property === 'opacity') {
                el.style.opacity = (current + speed) / 100;
            } else {
                el.style[property] = current + speed + 'px';
            }
        }
    }, 20)
}