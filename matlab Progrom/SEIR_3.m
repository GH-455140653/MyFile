%--------------------------------------------------------------------------
%   ��ʼ��
%--------------------------------------------------------------------------
clear;clc;

%--------------------------------------------------------------------------
%   ��������
%--------------------------------------------------------------------------
N = 10000;                                                                  %�˿�����
I = 1;                                                                      %��Ⱦ��
S = N - I;                                                                  %�׸���
R = 0;                                                                      %������

r = 10;                                                                     %��Ⱦ�߽Ӵ��׸��ߵ�����
B = 0.1;                                                                   %��Ⱦ����
y = 0.2;                                                                    %��������

T = 1:100;
for idx = 1:length(T)-1
    S(idx+1) = S(idx) - r*B*S(idx)*I(idx)/N;
    I(idx+1) = I(idx) + r*B*S(idx)*I(idx)/N - y*I(idx);
    R(idx+1) = R(idx) + y*I(idx);
end

plot(T,S,T,I,T,R);grid on;
xlabel('��');ylabel('����')
legend('�׸���','��Ⱦ��','������')