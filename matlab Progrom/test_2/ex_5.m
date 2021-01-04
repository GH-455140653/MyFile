function ex_5()
syms x;
y=dsolve('D2y-cos(2*x)+y=0','y(0)=1','Dy(0)=0','x')