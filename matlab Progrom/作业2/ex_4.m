function ex_4()
[x,y]=meshgrid(-10:1:10,-10:1:10);
z=x.^2/9.0-y.^2/4.0;
surf(x,y,z);
xlabel('X');
ylabel('Y');
zlabel('Z');
grid on;
colorbar;
legend('x.^2/9-y.^2/4')