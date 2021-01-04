package experiment.shiyan_7_1;

public class President implements TakeCareOfPets {
    @Override
    public void feed() {
        System.out.println("校长可以喂食宠物！");
    }

    @Override
    public void play() {
        System.out.println("校长可以和它玩耍！");
    }
    President(){
        feed();
        play();
    }
}
