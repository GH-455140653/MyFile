%
function ex_3()
t=0:pi/100:2*pi;
x=sin(t).^3;
y=cos(t).^3;
plot3(t,x,y);
xlabel('T');
zlabel('X');
ylabel('Y');
legend('sin(t)^3 and cos(t)^3')
grid on

