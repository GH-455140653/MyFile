package Command;

public class ConcreteCommand implements Command {
    public ConcreteCommand(String command) {
        execute(command);
    }

    @Override
    public void execute(String command) {
        if (command.equals("臊子面")) {
            saozi();
        } else if (command.equals("热干面")) {
            reganmian();
        } else {
            changfen();
        }
    }

    @Override
    public void undo() {

    }

    public void saozi() {
        Receiver receiver = new Receiver();
        receiver.theCookOfSaoziNoodle();
    }

    public void changfen() {
        Receiver receiver = new Receiver();
        receiver.theCookOfChangfen();
    }

    public void reganmian() {
        Receiver receiver = new Receiver();
        receiver.theCookOfreganNoodle();
    }
}
