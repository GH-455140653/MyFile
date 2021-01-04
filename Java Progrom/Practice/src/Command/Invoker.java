package Command;

import javax.swing.*;

public class Invoker {
    private final String clientName;

    public Invoker(String command, String name) {
        clientName = name;
        int choice = JOptionPane.showConfirmDialog(null,
                "请问你确定要点" + command + "吗？",
                "message",
                JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            order(command);
        } else if (choice==1){
            undo();
        }
    }

    public void order(String command) {
        ConcreteCommand concreteCommand = new ConcreteCommand(command);
    }

    public void undo() {
        Object[] obj = {"点餐", "离开"};
        String options = (String) JOptionPane.showInputDialog(null,
                "服务员：订单已经取消，请问你现在要干嘛？", "message", JOptionPane.PLAIN_MESSAGE, null, obj, "离开");
        if (options.equals("点餐")) {
            String command = begin.whatDoYouWantToEat();
            Invoker invoker=new Invoker(command,clientName);
        } else {
            JOptionPane.showMessageDialog(null,
                    clientName + "离开了。",
                    "提示",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}
