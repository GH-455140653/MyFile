function y = earning(x,t)
%˾�����ߺ����Ӻ���
%�������x��ʱ��t�������շ�
Base=13;%�����շ�
a1=2.3;
a2=2.3*1.5;
a3=a1*1.2;
a4=a2*1.2;
if(t>5 && t<23)%ÿ��5-23ʱ���շѱ�׼
    if x<=3
        y=Base;
    elseif x>3 && x<=15
        y=Base+a1*(x-3);
    else
        y=Base+a1*12+a2*(x-15);
    end
else%ÿ��23ʱ-�ڶ���5ʱ���շѱ�׼
    if x<=3
        y=Base;
    elseif x>3 && x<=15
        y=Base+a3*(x-3);
    else
        y=Base+a3*12+a4*(x-15);
    end
end