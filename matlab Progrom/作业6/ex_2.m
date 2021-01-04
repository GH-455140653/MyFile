function ex_2()
x=[-5:0.1:5];
f1=normpdf(x,0,1);
f2=normpdf(x,0,2);
plot(x,f1,'r*',x,f2,'b--')
legend('X~N(0,1)','X~N(0,2)')