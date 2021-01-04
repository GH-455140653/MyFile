function ex_6()
syms a b x1 x2 x3 x4;
s=solve(x1+x2+x3+x4,x2+2*x3+2*x4-1,-x2+(a-3)*x3-2*x4-b,3*x1+2*x2+x3+a*x4+1,a,b);
aa=s.a
bb=s.b