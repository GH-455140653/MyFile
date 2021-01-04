package experiment.shiyan_7_1;

public class Professor implements TakeCareOfPets {
    @Override
    public void feed() {
        System.out.println("教授可以喂食宠物！");
    }

    @Override
    public void play() {
        System.out.println("教授可以和它玩耍！");
    }
    Professor(){
        feed();
        play();
    }
}
