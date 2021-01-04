function exam_3()
[x,y]=meshgrid(-2:0.1:2,-2:0.1:2);
z=x.^3+y.^3;
surf(x,y,z);
xlabel('X');
ylabel('Y');
zlabel('Z');
grid on;
colorbar;
legend('x^3+y^3')