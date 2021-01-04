function ex_1()
a=1;
b=1;
while a<10000
    temp=a+b;
    a=b;
    b=temp;
end
disp(a)
