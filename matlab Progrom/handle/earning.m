function y = earning(x,t)
%司机决策函数子函数
%输入里程x，时间t，计算收费
Base=13;%基础收费
a1=2.3;
a2=2.3*1.5;
a3=a1*1.2;
a4=a2*1.2;
if(t>5 && t<23)%每天5-23时的收费标准
    if x<=3
        y=Base;
    elseif x>3 && x<=15
        y=Base+a1*(x-3);
    else
        y=Base+a1*12+a2*(x-15);
    end
else%每天23时-第二天5时的收费标准
    if x<=3
        y=Base;
    elseif x>3 && x<=15
        y=Base+a3*(x-3);
    else
        y=Base+a3*12+a4*(x-15);
    end
end