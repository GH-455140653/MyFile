function y=Fib(x)
if x==1 || x==2
    y=1;
else
    y=Fib(x-1)+Fib(x-2);
end