function ex_2()
syms x;
f=((cos(x)).^3)/exp(x);
'微分结果：'
f1=diff(f,x)
'不定积分结果：'
f2=int(f,x)