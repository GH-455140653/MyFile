package experiment;

import java.util.ArrayList;

public class shiyan_6_5 {
    public static void main(String[] args) {
        ArrayList<Animal> list = new ArrayList<Animal>();
        Horse h1 = new Horse("h1");
        Horse h2 = new Horse("h2");
        Snake s1 = new Snake("s1");
        Snake s2 = new Snake("s2");
        list.add(h1);
        list.add(h2);
        list.add(s1);
        list.add(s2);
        for (Animal animal : list) {
            if (animal instanceof Horse) {
                animal.walk();
            }
            if (animal instanceof Snake) {
                animal.walk();
            }
        }
    }

    static class Animal {
        private String name;

        Animal(String name) {
            setName(name);
        }

        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        public void breathe() {
        }

        public void walk() {
        }
    }

    static class Horse extends Animal {
        Horse(String name) {
            super(name);
        }

        @Override
        public void walk() {
            System.out.println(getName() + "能够用四足行走！");
        }
    }

    static class Snake extends Animal {
        Snake(String name) {
            super(name);
        }

        @Override
        public void walk() {
            System.out.println(getName() + "能够用身体行走！");
        }
    }
}
