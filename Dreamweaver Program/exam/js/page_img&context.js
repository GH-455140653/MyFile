(function () {
    var currentIndex;
    var lis;//图片集
    var lisWidth;
    var len;
    var id;

    init();

    function init() {
        currentIndex = 1;
        var li_1 = document.querySelector('.slider .list .item:first-of-type');
        var copy_1 = li_1.cloneNode(true);
        var li_last = document.querySelector('.slider .list .item:last-of-type');
        var copy_last = li_last.cloneNode(true);

        var list = document.querySelector('.slider .list');
        list.appendChild(copy_1);
        list.insertBefore(copy_last, li_1);

        lis = document.querySelectorAll('.list .item');
        lisWidth = lis[0].offsetWidth;
        len = lis.length;

        list.style.width = lisWidth * len + 'px';
        list.style.left = -lisWidth + 'px';

        document.querySelector('.prev').onclick = function () {
            sliderPrev();
        };
        document.querySelector('.next').onclick = function () {
            sliderNext();
        };

        var bullets = document.querySelectorAll('.slider .pageination .bullet');//图片分页
        for (var i = 0; i < bullets.length; i++) {
            bullets[i].index = i;
            bullets[i].onclick = function () {
                currentIndex = this.index + 1;
                sliderTo(currentIndex);
            }
        }
        var slider = document.querySelector('.slider');
        slider.onmouseover = function () {
            stop();
        };
        slider.onmouseout = function () {
            auto();
        };
        auto();
    }

    function sliderPrev() {
        currentIndex--;
        sliderTo(currentIndex);
    }

    function sliderNext() {
        currentIndex++;
        sliderTo(currentIndex);
    }

    function sliderTo(index) {
        var list = document.querySelector('.slider .list');
        if (index === len) {
            currentIndex = index = 2;
            list.style.left = -lisWidth + 'px';
        }
        if (index === -1) {
            currentIndex = index = len - 3;
            list.style.left = -(len - 2) * lisWidth + 'px';
        }

        var focusIndex;
        var bullets = document.querySelectorAll('.pageination .bullet');
        if (index === 0) {
            focusIndex = bullets.length - 1;
        } else if (index === len - 1) {
            focusIndex = 0;
        } else {
            focusIndex = index - 1;
        }

        switch (focusIndex) {
            case 0:
                document.getElementById('page_context').innerHTML = "现代软件工程创造了一种文化、工具和实践，专注于开发高质量、安全和功能丰富的软件服务，以实现微软的数字化转型。微软核心服务和工程（CSEO，前身为微软内部IT，服务微软内部客户）团队正在实施现代软件工程愿景，以创建一种文化、工具和实践，致力于开发高质量、安全和功能丰富的服务，来实现微软的数字化转型。现代软件工程计划正在帮助CSEO痴迷于客户，加快新功能的交付，并提高工程效率。";
                break;
            case 1:
                document.getElementById('page_context').innerHTML = "世界是缤纷复杂的，要把真实世界映射到虚拟软件注定不会是一件容易的事，软件开发是权衡抉择的艺术，譬如快速交付和安全生产常常背道而驰，开发效率和运行效率总是难以一致。所以在软件发展的历史长河中，人们发明一种方法解决一个问题，而几乎总是会引入另一个问题，软件工程师不得不面对混沌不堪的世界。";
                break;
            case 2:
                document.getElementById('page_context').innerHTML = "对于软件工程师来说，在学习技术的过程中，总是会面对深度和广度的问题，至于如何安排具体的学习计划，应该考虑到三方面因素，其一是自身的发展规划，其二是行业发展趋势，其三是自身的能力特点。";
                break;
            case 3:
                document.getElementById('page_context').innerHTML = "软件工程是个很大的筐，任何跟软件相关的东西都可以放入。从软件的形成来说，有需求分析、设计和开发、测试和销售、运营和维护。从软件的处理的对象来说，有移动端、主机端、嵌入式端。还可以按照软件功能来分，比如游戏软件、媒体软件、企业ERP软件或者信息管理系统等。这些都是软件工程毕业生的就业方向。";
                break;
        }

        document.querySelector('.focus').className = 'bullet';
        bullets[focusIndex].className = 'bullet focus';

        var left = -index * lisWidth;
        animate(list, {
            left: left
        })
    }

    function auto() {
        clearInterval(id);
        id = setInterval(function () {
            sliderNext()
        }, 4000);
    }

    function stop() {
        clearInterval(id);
    }
})()