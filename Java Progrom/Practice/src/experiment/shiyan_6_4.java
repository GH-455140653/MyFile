package experiment;

import java.util.ArrayList;

public class shiyan_6_4 {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<Person>();
        Person person = new Person("某某人", 18, "无业游民");
        PupilStudent pupil = new PupilStudent("小胜", 19, "小学生");
        GraduateStudent graduatestudent = new GraduateStudent("小孟", 20, "研究生");
        list.add(person);
        list.add(pupil);
        list.add(graduatestudent);
        for (Person ps : list) {
            System.out.println(ps.toString());
            if (ps instanceof PupilStudent) ((PupilStudent) ps).GoToSchool();
            if (ps instanceof GraduateStudent) ((GraduateStudent) ps).DoProject();
        }
        list.clear();
    }

    static class Person {
        public String name;
        public int age;
        public String degree;

        public String toString() {
            return name + "是一个" + age + "岁的" + degree;
        }

        Person(String name, int age, String degree) {
            this.name = name;
            this.age = age;
            this.degree = degree;
        }
    }

    static class PupilStudent extends Person {
        PupilStudent(String name, int age, String degree) {
            super(name, age, degree);
        }

        @Override
        public String toString() {
            return name + "是一个" + age + "岁的" + degree;
        }

        public void GoToSchool() {
            System.out.printf("姓名为%s的%d岁%s能够去上学！\n", name, age, degree);
        }
    }

    static class GraduateStudent extends Person {
        GraduateStudent(String name, int age, String degree) {
            super(name, age, degree);
        }

        @Override
        public String toString() {
            return name + "是一个" + age + "岁的" + degree;
        }

        public void DoProject() {
            System.out.printf("姓名为%s的%d岁%s能够从事项目研究！", name, age, degree);
        }
    }
}
