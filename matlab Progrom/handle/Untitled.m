%��һ�������������ģ��
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
legend('����һ����','����������');
xlabel('���ģ�����','FontName','����','FontSize',15,'FontWeight','bold');
ylabel('�������棨Ԫ��','FontName','����','FontSize',15,'FontWeight','bold');
title('100�����ģ����������������','FontName','����','FontSize',15,'FontWeight','bold');