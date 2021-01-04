%利用subplot绘制函数tan(x)、arctan(x)的图形。
function ex_2()
x1=-pi/2+pi/100:pi/50:pi/2-pi/100;
x2=-pi:pi/100:pi;
y1=tan(x1);
y2=atan(x2);
subplot(2,1,1);
plot(x1,y1,'--*r')
ylabel('variable y')
legend('arctan(x)');
subplot(2,1,2);
title('arctan(x)')
plot(x2,y2)
xlabel('variable x')
ylabel('variable y')
legend('arctan(x)');

