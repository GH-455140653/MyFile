function ex_3()
syms x a b;
f=pi*(b^2)/(a^2)*(a^2-x^2);
int(f,x,-a,a)