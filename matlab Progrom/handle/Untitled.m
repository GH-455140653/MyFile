%第一问虚拟数据随机模拟
f1=zeros(100,1);
f2=zeros(100,1);
j=zeros(100,1);
for i=1:100
    [f1(i),f2(i),j(i)]=judge(2,3,60,10);
end
stem(1:100,f1,'Marker','s');
hold on 
stem(1:100,f2,'Marker','*');
hold off 
legend('方案一收益','方案二收益');
xlabel('随机模拟次数','FontName','黑体','FontSize',15,'FontWeight','bold');
ylabel('方案收益（元）','FontName','黑体','FontSize',15,'FontWeight','bold');
title('100次随机模拟各方案的收益情况','FontName','黑体','FontSize',15,'FontWeight','bold');