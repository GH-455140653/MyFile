package Command;

public interface Command {
    public void execute(String command);

    public void undo();
}

