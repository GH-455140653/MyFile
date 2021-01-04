function ex_2_2()
syms x y r;
f=(r^2-x^2)^(1/2);
int(int(f,y,0,f),x,0,r)