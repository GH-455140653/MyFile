function exam_2()
x=0:pi/15:pi/2;
y1=sin(x);
y2=log(x);
y3=x.^2;
y4=exp(x);

plot(x,y1,'r.-',x,y2,'--*b',x,y3,'-mo',x,y4,':kh')
legend('sin(x)','log(x)','x^2','e^x')
