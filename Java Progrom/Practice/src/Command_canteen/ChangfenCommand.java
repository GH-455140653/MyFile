package Command_canteen;

public class ChangfenCommand implements Command {
    Cook cook;

    ChangfenCommand(Cook cook) {
        this.cook = cook;
    }

    @Override
    public void execute() {
        cook.changfen();
    }

    @Override
    public void undo() {

    }
}
