function exam_4()
t=0:pi/6:4*pi;
y=exp(-t).*cos(t);
plot(t,y,':r*')
legend('e^(-t)*cos(t)')
syms b
dy=diff(y) %Î¢·Ö
syms k;
int(exp(-k)*cos(k),[0,4*pi]) %»ý·Ö