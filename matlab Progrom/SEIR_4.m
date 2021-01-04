%--------------------------------------------------------------------------
%   ��ʼ��
%--------------------------------------------------------------------------
clear;clc;

%--------------------------------------------------------------------------
%   ��������
%--------------------------------------------------------------------------
N = 9083500;                                                                %�˿�����
E = 0;                                                                      %Ǳ����
I = 1;                                                                      %��Ⱦ��
S = N - I;                                                                  %�׸���
R = 0;                                                                      %������
r = 10;                                                                     %��Ⱦ�߽Ӵ��׸��ߵ�����
B = 0.38;                                                                   %��Ⱦ����
a = 0.2;                                                                    %Ǳ����ת��Ϊ��Ⱦ�߸���
y = 0.1;                                                                    %��������
T = 1:120;
for idx = 1:length(T)-1
    S(idx+1) = S(idx) - r*B*S(idx)*I(idx)/N;
    E(idx+1) = E(idx) + r*B*S(idx)*I(idx)/N-a*E(idx);
    I(idx+1) = I(idx) + a*E(idx) - y*I(idx);
    R(idx+1) = R(idx) + y*I(idx);
end

plot(T,S,T,E,T,I,T,R);grid on;
xlabel('��');ylabel('����')
legend('�׸���','Ǳ����','��Ⱦ��','������')