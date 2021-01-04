package Command_canteen;

public class Waiter {
    Command command;

    Waiter() {
    }

    void setCommand(Command command) {
        this.command = command;
    }

    public void setOrder() {
        command.execute();
    }

    public void cancelOrder() {
        command.undo();
    }
}
