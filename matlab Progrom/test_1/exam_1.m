function exam_1()
syms a b;
A=[1,1,1,1;0,1,2,2;0,-1,a-3.-2;3,2,1,a];
B=[0,1,b,-1];
x=solve(A)*B
%x=inv(A)*B

