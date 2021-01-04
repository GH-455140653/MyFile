package experiment.shiyan_6_3;

public class Test1 {
    public static void main(String[] args) {
        animalClass.Cat C = new animalClass.Cat();
        eatfunction(C);
    }

    public static void eatfunction(animalClass.Animal A) {
        A.eat();
        A.behavior();
    }
}
