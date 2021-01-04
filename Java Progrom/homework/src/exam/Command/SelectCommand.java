package exam.Command;

import exam.Operation.Opera_Log;
import exam.Operation.Opera_Message;
import exam.Operation.Opera_Rant;
import exam.Operation.Opera_Resource;

public class SelectCommand implements Command {
    Opera_Message opera_Message;
    Opera_Resource opera_Resource;
    Opera_Rant opera_Rant;
    Opera_Log opera_Log;

    public SelectCommand(Opera_Message opera) {
        this.opera_Message = opera;
    }

    public SelectCommand(Opera_Resource opera) {
        this.opera_Resource = opera;
    }

    public SelectCommand(Opera_Rant opera) {
        this.opera_Rant = opera;
    }

    public SelectCommand(Opera_Log opera) {
        this.opera_Log = opera;
    }

    @Override
    public void execute_message() {
        opera_Message.select();
    }

    @Override
    public void execute_resource() {
        opera_Resource.select();
    }

    @Override
    public void execute_log() {
        opera_Log.select();
    }

    @Override
    public void execute_rant() {
        opera_Rant.select();
    }
}
