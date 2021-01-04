package practice;

public class six {
    //求1-100之间的偶数之和
    public static void main(String [] args) {
        int sum=0;
        int even=1;
        while(even<=100)
        {
            even++;
            if(even%2==0)
            {
                sum=sum+even;
            }
        }
        System.out.println("1-100之间的所有偶数之和为："+sum);
    }
}
