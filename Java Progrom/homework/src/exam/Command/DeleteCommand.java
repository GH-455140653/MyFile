package exam.Command;

import exam.Operation.Opera_Log;
import exam.Operation.Opera_Message;
import exam.Operation.Opera_Rant;
import exam.Operation.Opera_Resource;

public class DeleteCommand implements Command {
    Opera_Message opera_Message;
    Opera_Resource opera_Resource;
    Opera_Rant opera_Rant;
    Opera_Log opera_Log;

    public DeleteCommand(Opera_Message opera) {
        this.opera_Message = opera;
    }

    public DeleteCommand(Opera_Resource opera) {
        this.opera_Resource = opera;
    }

    public DeleteCommand(Opera_Rant opera) {
        this.opera_Rant = opera;
    }

    public DeleteCommand(Opera_Log opera) {
        this.opera_Log = opera;
    }

    @Override
    public void execute_message() {
        opera_Message.delete();
    }

    @Override
    public void execute_resource() {
        opera_Resource.delete();
    }

    @Override
    public void execute_log() {}

    @Override
    public void execute_rant() {}
}
