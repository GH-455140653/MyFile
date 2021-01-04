function ex_11()
n=1;
sum=0;
while n
    sum=Fib(n);
    if sum>10000
        break;
    end
    n=n+1;
end
disp(sum)

