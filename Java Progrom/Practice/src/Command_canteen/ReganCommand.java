package Command_canteen;

public class ReganCommand implements Command {
    Cook cook;

    ReganCommand(Cook cook) {
        this.cook = cook;
    }

    @Override
    public void execute() {
        cook.reganNoodle();
    }

    @Override
    public void undo() {

    }
}
