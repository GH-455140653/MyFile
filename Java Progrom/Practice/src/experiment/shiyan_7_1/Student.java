package experiment.shiyan_7_1;

public class Student implements TakeCareOfPets {

    @Override
    public void feed() {
        System.out.println("学生可以喂食宠物！");
    }

    @Override
    public void play() {
        System.out.println("学生可以和它玩耍！");
    }
    Student(){
        feed();
        play();
    }
}
