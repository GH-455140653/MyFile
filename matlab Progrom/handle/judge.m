function[f1,f2,j]=judge(N1,N2,N,t)
%司机决策主函数
%N1代表前一个小时航班数、N2代表后一个小时航班数、N代表司机前面出租车数量，t代表时间
%fl代表等待载客然后返回收益、f2代表空载直接返回收益、j代表选方案1还是2
%确定参数设置
L=25.1;%机场与市中心距离
b=0.4;%空载率；
v=60;%假设车速
v_jichang=1;%假设机场每分钟通过出租车带走多少组乘客
a1=0.3;%选择出租车出行的乘客数
a2=2;%平均同行乘客数
%非确定因素
%假设航班以200-300均匀分布
%num=randperm(100,1);
%num=num+200;%节假日
num=randperm(150,1);
num=num+50;%工作日，50-200之间均匀分布
x=normrnd(L,8.3);%乘客乘车距离随机产生
N1=floor(N1*num*a1/a2)-60*v_jichang;
N2=floor(N2*num*a1/a2);
if N1+N2>=N
    t_wait=(1/60)*N/v_jichang;
else
    t_wait=2;
end
Cg1=L*0.492;
Ct1=(1-b)*(earning(t_wait*v,t)+earning(L-x,t));
f1=earning(x,t)-Cg1-Ct1;%等待载客的收益
Cg2=L*0.492;%油耗
Ct2=(1-b)*earning(L,t);
f2=-Cg2-Ct2;%选择空载的收益
if f1>f2
    j=1;
else
    j=2;
end
end

