function ex_2()
H=[1/2 0;1/2 0];
c=[-1;-2];
b=[6;5];
vlb=[];
vub=[0,0];
aeq=[];
beq=[];
A=[2 3;1 4];
[x,z]=quadprog(H,c,A,b,aeq,beq,vlb,vub)
