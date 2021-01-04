package experiment;

import java.util.ArrayList;

public class shiyan_9_1 {
    public static void main(String[] args) {
        //Tom Telephone No is 18646681001.Marry Telephone No is 18646681002.Owen Telephone No is 18646681003.
        String messgae = "Tom Telephone No is 18646681001.Marry Telephone No is 18646681002.Owen Telephone No is 18646681003.";
        ArrayList<Student> list = new ArrayList<Student>();
        int Last_point = messgae.lastIndexOf(".");
        System.out.println("(1)：");
        for (int i = 0; i < 3; i++) {
            int point = messgae.indexOf(".");
            if (i == 2) point = messgae.length();
            String subMessage = messgae.substring(0, point);
            switch (i) {
                case 0:
                    messgae = messgae.substring(point + 1, Last_point);
                    break;
                case 1: {
                    int second_point = messgae.indexOf(".");
                    int last_point = messgae.length();
                    messgae = messgae.substring(second_point + 1, last_point);
                    break;
                }
            }
            int space = subMessage.indexOf(" ");
            String name = subMessage.substring(0, space);
            int last_point = subMessage.lastIndexOf(" ");
            String telephone = subMessage.substring(last_point + 1, point);
            System.out.println(name + ":" + telephone);
            if (i == 0) {
                Student S_1 = new Student(name, telephone);
                list.add(S_1);
            } else if (i == 2) {
                Student S_2 = new Student(name, telephone);
                list.add(S_2);
            } else {
                Student S_3 = new Student(name, telephone);
                list.add(S_3);
            }
        }
        System.out.println("\n(2)：");
        for (Student arr : list) {
            arr.message();
        }
    }

    static class Student {
        private String name;
        private String telephone;

        Student(String name, String telephone) {
            setName(name);
            setTelephone(telephone);
        }


        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        public String getTelephone() {
            return telephone;
        }

        private void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public void message() {
            System.out.println(getName() + ":" + getTelephone());
        }
    }
}
