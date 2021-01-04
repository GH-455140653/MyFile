package Command;

import javax.swing.*;

public class begin {
    public static Client client;

    public static void main(String[] args) {
        whatYourName();
        whatDoYouWantToDo();
    }

    public static void whatYourName() {
        String paneIn = JOptionPane.showInputDialog(null, "服务员：客官，怎么称呼你？", "输入", JOptionPane.QUESTION_MESSAGE);
        client = new Client(paneIn);
    }

    public static void whatDoYouWantToDo() {
        Object[] obj = {"点餐", "离开"};
        String options = (String) JOptionPane.showInputDialog(null,
                "服务员：" + client.getName() + ",请问你要干什么？",
                "message",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                obj,
                "点餐");
        try {
            if (options.equals("点餐")) {
                String command = whatDoYouWantToEat();
                client.order(command);
            } else {
                client.goaway();
            }
        } catch (Exception e) {
            System.exit(0);
        }

    }

    public static String whatDoYouWantToEat() {
        Object[] obj = {"肠粉", "热干面", "臊子面"};
        return (String) JOptionPane.showInputDialog(null,
                "服务员：请问你要吃什么？",
                "message",
                JOptionPane.QUESTION_MESSAGE,
                null,
                obj,
                "肠粉");
    }
}
