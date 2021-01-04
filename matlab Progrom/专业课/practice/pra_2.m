clear,clc;
f=-[3100 3100 3100 3800 3800 3800 3500 3500 3500 2850 2850 2850];
intcon=1:12;
Aeq=[8 -5 0 8 -5 0 8 -5 0 8 -5 0;8 0 -10 8 0 -10 8 0 -10 8 0 -10];
beq=[0 0];
A=[1 1 1 0 0 0 0 0 0 0 0 0;
    0 0 0 1 1 1 0 0 0 0 0 0;
    0 0 0 0 0 0 1 1 1 0 0 0;
    0 0 0 0 0 0 0 0 0 1 1 1;
    1 0 0 1 0 0 1 0 0 1 0 0;
    0 1 0 0 1 0 0 1 0 0 1 0;
    0 0 1 0 0 1 0 0 1 0 0 1;
    480 0 0 650 0 0 580 0 0 390 0 0;
    0 480 0 0 650 0 0 580 0 0 390 0;
    0 0 480 0 0 650 0 0 580 0 0 390];
b=[18 15 23 12 10 16 8 6800 8700 5300];
lb=zeros(12,1);
[x,fval]=intlinprog(f,intcon,A,b,Aeq,beq,lb,[])