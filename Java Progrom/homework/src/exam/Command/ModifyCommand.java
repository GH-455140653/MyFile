package exam.Command;

import exam.Operation.Opera_Log;
import exam.Operation.Opera_Message;
import exam.Operation.Opera_Rant;
import exam.Operation.Opera_Resource;

public class ModifyCommand implements Command {
    Opera_Message opera_Message;
    Opera_Resource opera_Resource;
    Opera_Rant opera_Rant;
    Opera_Log opera_Log;

    public ModifyCommand(Opera_Message opera) {
        this.opera_Message = opera;
    }

    public ModifyCommand(Opera_Resource opera) {
        this.opera_Resource = opera;
    }

    public ModifyCommand(Opera_Rant opera) {
        this.opera_Rant = opera;
    }

    public ModifyCommand(Opera_Log opera) {
        this.opera_Log = opera;
    }

    @Override
    public void execute_message() {
        opera_Message.modify();
    }

    @Override
    public void execute_resource() {
        opera_Resource.modify();
    }

    @Override
    public void execute_log() {
    }

    @Override
    public void execute_rant() {
    }
}
