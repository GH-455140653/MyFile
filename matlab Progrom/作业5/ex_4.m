function ex_4()
syms x y;
f=dsolve('D2y+4*Dy+10*y=0','y(0)=0','Dy(0)=2','x')