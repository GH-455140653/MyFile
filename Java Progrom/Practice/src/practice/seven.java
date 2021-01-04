package practice;

public class seven {
    //输出所有语言字符
    public static void main(String[] args){
        char x='A';
        char y='Ω';
        char c='α';
        char d='ω';
        int i,j;
        for(i=(int)x;i<=(int)y;i++){
            char a=(char)i;
            System.out.print(""+a);
        }
        for(j=(int)c;j<=(int)d;j++){
            char b=(char)j;
            System.out.print(""+b);
        }
    }
}
