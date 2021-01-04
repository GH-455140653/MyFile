define(function () {
    var PI=3.14;
    function multiple(num1,num2) {
        return num1*num2;
    }
    
    function square(n) {
        return n*n;
    }

    return {
        PI:PI,
        multiple:multiple,
        square:square
    }

})