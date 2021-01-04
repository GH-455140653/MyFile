package experiment;

public class shiyan_6_2 {
    public static void main(String[] args) {
        Student S = new Student("小孟", 18, "二年级");
        Teacher T = new Teacher("小李", 30, "1C-202", 8192);
        S.goToSchool();
        System.out.println(S.toString());
        T.teaching();
        System.out.println(T.toString());
    }

    static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            setName(name);
            setAge(age);
        }

        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        private void setAge(int age) {
            this.age = age;
        }

        public String toString() {
//            System.out.println(getName()+"的年龄是"+getAge());
            return null;
        }
    }

    static class Student extends Person {
        private String classStatic;

        Student(String name, int age, String degree) {
            super(name, age);
            setClassStatic(degree);
        }

        public void goToSchool() {
            System.out.println(getName() + "可以上学！");
        }

        public String getClassStatic() {
            return classStatic;
        }

        private void setClassStatic(String classStatic) {
            this.classStatic = classStatic;
        }

        public String toString() {
            return getName() + "的年龄是" + getAge() + "，他是" + getClassStatic() + "学生。";
        }
    }

    static class Teacher extends Person {
        private String office;
        private int wage;

        Teacher(String name, int age, String office, int wage) {
            super(name, age);
            setOffice(office);
            setWage(wage);
        }

        public int getWage() {
            return wage;
        }

        private void setWage(int wage) {
            this.wage = wage;
        }

        public String getOffice() {
            return office;
        }

        private void setOffice(String office) {
            this.office = office;
        }

        public void teaching() {
            System.out.println(getName() + "可以授课！");
        }

        public String toString() {
            return getName() + "的年龄是" + getAge() + "，他的办公室在" + getOffice() + ",他的薪水为：" + getWage()+"。";
        }
    }
}
