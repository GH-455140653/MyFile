function hw2_2()
x=0:pi/15:2*pi;
y1=0.5*x.^2;
y2=10*sin(x);
plot(x,y1,'r.-',x,y2);
grid
xlabel('variable x')
ylabel('variable y')
title('x^2 and sin(x)');
text(6.2,-5.5,'sin(x)');
text(6.2,'x^2');