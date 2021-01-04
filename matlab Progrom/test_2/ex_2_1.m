function ex_2_1()
syms x;
f=(2*pi)^(-1)*exp(-(x^2)/2);
int(f,x,0,2)