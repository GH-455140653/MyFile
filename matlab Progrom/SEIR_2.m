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
r = 10;                                                                     %��Ⱦ�߽Ӵ��׸��ߵ�����
B = 0.01;                                                                   %��Ⱦ����
y = 0.03;                                                                   %��������
T = 1:400;

for idx = 1:length(T)-1
    S(idx+1) = S(idx) - r*B*I(idx)*S(idx)/N + y*I(idx);
    I(idx+1) = I(idx) + r*B*I(idx)*S(idx)/N - y*I(idx);
end

plot(T,S,T,I);grid on;
xlabel('��');ylabel('����')
legend('�׸���','��Ⱦ��');title('SISģ��')