%����plot���ƺ��� �� ��ͼ�Σ��ֱ��ò�ͬ�����ͣ���ɫ����ǣ����ϱ�עlegend��
function ex_1()
t=-2*pi:pi/40:2*pi;
y1=4*sin(3*t);
y2=4*cos(3*t);
plot(t,y1,'r.-',t,y2,':xm');
%axis([-2.5*pi 2.5*pi,-5,5])
grid
xlabel('variable x')
ylabel('variable y')
title('sin(3t) and cos(3t)')
legend('t-y1','t-y2');
