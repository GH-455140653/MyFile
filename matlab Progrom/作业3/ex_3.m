function ex_3()
sum=0;
n=0;
while n+1
    num=input("请输入若干个数，输入0结束：");
    if num==0
        break;
    end
    sum=sum+num;
    n=n+1;
end
disp(sum*1.0/n);
