function ex_4()
syms x y;
f=exp(2*x)*(x+y^2+2*y);
z1=diff(f,'x')
z2=diff(f,'y')
z3=diff(f,'x',2)
z4=diff(f,'y',2)
z5=diff(f,'x','y')