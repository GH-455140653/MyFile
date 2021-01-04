package Command_canteen;

public class SaoziCommand implements Command {
    Cook cook;

    SaoziCommand(Cook cook) {
        this.cook = cook;
    }

    @Override
    public void execute() {
        cook.saoziNoodle();
    }

    @Override
    public void undo() {

    }
}
