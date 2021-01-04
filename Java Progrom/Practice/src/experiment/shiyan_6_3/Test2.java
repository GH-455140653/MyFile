package experiment.shiyan_6_3;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<animalClass.Animal> list = new ArrayList<animalClass.Animal>();
        animalClass.Cat cat = new animalClass.Cat();
        animalClass.Dog dog = new animalClass.Dog();
        animalClass.Pig pig = new animalClass.Pig();
        list.add(cat);
        list.add(dog);
        list.add(pig);
        for (animalClass.Animal animal : list) {
            Test1.eatfunction(animal);
        }
    }
}

//package shiyan_6_3;
//
//        import java.util.ArrayList;
//
//public class Test2 {
//    public static void main(String[] args) {
//        ArrayList list = new ArrayList();
//        animalClass.Cat cat = new animalClass.Cat();
//        animalClass.Dog dog = new animalClass.Dog();
//        animalClass.Pig pig = new animalClass.Pig();
//        list.add(cat);
//        list.add(dog);
//        list.add(pig);
//        for (int i = 0; i < list.size(); i++) {
//            Test1.eatfunction((animalClass.Animal) (list.get(i)));
//        }
//    }
//}

