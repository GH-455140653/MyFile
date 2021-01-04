%SEIR模型
clear;clc;
%参数设置
N=1400000000;%人口数
I=1;%传染者
R=0;%康复者
D=0;%死亡患者数量
E=0;%潜伏者
S=N-I;%易感染者
r=1;%接触病患的人数
a=0.125;%潜伏者患病概率
B=0.5;%感染概率
y=0.143;%康复概率
k=0.025373;%日死亡率
T=20:1000;%日期
for x =1:length(T)-1
    S(x+1)=S(x)-r*B*I(x)*S(x)/N;%易感人数迭代
    E(x+1)=E(x)+r*B*S(x)*I(x)/N-a*E(x);%潜伏者人数迭代
    I(x+1)=I(x)+a*E(x)-(y+k)*I(x);%患病人数迭代
    R(x+1)=R(x)+y*I(x);%康复人数迭代 
    D(x+1)=D(x)+k*I(x);%死亡患者人数迭代
end
plot(T,S,T,E,T,I,T,R,T,D);
grid on;
xlabel('日期');
ylabel('人数');
legend('易感者','潜伏者','传染者','康复者','死亡者');
title('SEIR模型');
plot(T,E,T,I,T,R,T,D);
grid on;
xlabel('日期');
ylabel('人数');
legend('潜伏者','传染者','康复者','死亡者');
title('疫情情况');