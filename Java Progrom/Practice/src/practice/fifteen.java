package practice;

interface Sing {
    void singPopMusic();

    void singRockandRoll();
}

interface Paint {
    void paintOliPainting();

    void paintSketch();
}

class Person {
    private String name;

    Person(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void breathe() {
        System.out.println(getName() + "能够呼吸！");
    }
}

class Student extends Person implements Sing {
    Student(String name) {
        super(name);
    }

    @Override
    public void singPopMusic() {
        System.out.println(getName()+"会唱流行歌");
    }

    @Override
    public void singRockandRoll() {
        System.out.println(getName()+"会唱摇滚乐");
    }

    public void study() {
        System.out.println(getName()+"可以学习");
    }

    public void load() {
        singPopMusic();
        singRockandRoll();
        study();
    }
}

class Teacher extends Person implements Sing, Paint {

    Teacher(String name) {
        super(name);
    }

    @Override
    public void singPopMusic() {
        System.out.println(getName()+"会唱流行歌");
    }

    @Override
    public void singRockandRoll() {
        System.out.println(getName()+"会唱摇滚乐");
    }

    @Override
    public void paintOliPainting() {
        System.out.println(getName()+"会画油画");
    }

    @Override
    public void paintSketch() {
        System.out.println(getName()+"会绘图");
    }

    public void teachCourse() {
        System.out.println(getName()+"可以授课！");
    }

    public void load() {
        singPopMusic();
        singRockandRoll();
        paintOliPainting();
        paintSketch();
        teachCourse();
    }
}

public class fifteen {
    public static void main(String[] args) {
        Student S = new Student("小李");
        Teacher T = new Teacher("小丽");
        S.load();
        T.load();
    }
}
