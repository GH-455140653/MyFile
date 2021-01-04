package experiment.shiyan_5_2;

public class Test {
    public static void main(String[] args){
        Student S=new Student();
        Student s=new Student(100,"LRL");
        System.out.println("S的姓名为："+S.name+",S的分数为："+S.score);
        System.out.println("s的姓名为："+s.name+",s的分数为："+s.score);
    }
}
