package experiment;

public class shiyan_7_2 {
    public static void main(String[] args) {
        Preson P = new Preson("小米", 18, "男性");
    }

}

class Preson implements behavior {
    private String name;
    private String sex;
    private int age;

    Preson(String name, int age, String sex) {
        setName(name);
        setAge(age);
        setSex(sex);
        breathe();
        eat();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    private void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public void breathe() {
        System.out.println(getAge() + "岁的" + getSex() + getName() + "会呼吸！");
    }

    @Override
    public void eat() {
        System.out.println(getAge() + "岁的" + getSex() + getName() + "会吃东西！");
    }
}

interface behavior {
    void breathe();

    void eat();
}
