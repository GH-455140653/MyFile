package experiment.shiyan_6_3;

public class animalClass {
    static class Animal {
        public void eat() {
        }

        public void behavior() {
        }
    }

    static class Cat extends Animal {
        Cat() {
        }

        @Override
        public void eat() {
            System.out.println("猫吃老鼠！");
        }

        @Override
        public void behavior() {
            System.out.println("猫可以抓老鼠！");
        }
    }

    static class Dog extends Animal {
        Dog() {
        }

        @Override
        public void eat() {
            System.out.println("狗吃骨头！");
        }

        @Override
        public void behavior() {
            System.out.println("狗能看家护院！");
        }
    }

    static class Pig extends Animal {
        Pig() {
        }

        @Override
        public void eat() {
            System.out.println("猪吃饲料！");
        }

        @Override
        public void behavior() {
            System.out.println("猪特别能睡觉！");
        }
    }
}
