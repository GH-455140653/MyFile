package exam.Command;

import exam.Operation.*;

public class AddCommand implements Command {
    Opera_Message opera_Message;
    Opera_Resource opera_Resource;
    Opera_Rant opera_Rant;
    Opera_Log opera_Log;

    public AddCommand(Opera_Message opera) {
        this.opera_Message = opera;
    }

    public AddCommand(Opera_Resource opera) {
        this.opera_Resource = opera;
    }

    public AddCommand(Opera_Rant opera) {
        this.opera_Rant = opera;
    }

    public AddCommand(Opera_Log opera) {
        this.opera_Log = opera;
    }

    @Override
    public void execute_message() {
        opera_Message.add();
    }

    @Override
    public void execute_resource() {
        opera_Resource.add();
    }

    @Override
    public void execute_log() {}

    @Override
    public void execute_rant() {}
}
