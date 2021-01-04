package exam;

import exam.Command.Command;

public class Server {
    Command command;

    Server(Command command) {
        setCommand(command);
    }

    //父类调用子类的对象
    private void setCommand(Command command) {
        this.command = command;
    }

    public void execute_message() {
        command.execute_message();
    }

    public void execute_log() {
        command.execute_log();
    }

    public void execute_resourse() {
        command.execute_resource();
    }

    public void execute_rant() {
        command.execute_rant();
    }
}
