package Command_canteen;

import javax.swing.*;

public class Test {
    public static Customer customer;
    public static Cook cook = new Cook();
    public static Waiter waiter = new Waiter();
    public static SaoziCommand saoziNoodle = new SaoziCommand(cook);
    public static ReganCommand reganNoddle = new ReganCommand(cook);
    public static ChangfenCommand changfen = new ChangfenCommand(cook);

    public static void main(String[] args) {
        whatYourName();
        whatDoYouWantToDo();
    }

    private static void whatYourName() {
        String paneIn = JOptionPane.showInputDialog(null, "服务员：客官，怎么称呼你？", "输入", JOptionPane.QUESTION_MESSAGE);
        customer = new Customer(paneIn);
    }

    public static void whatDoYouWantToDo() {
        Object[] obj = {"点餐", "离开"};
        String options = (String) JOptionPane.showInputDialog(null,
                "服务员：" + customer.getName() + ",请问你要干什么？",
                "message",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                obj,
                "点餐");
        try {
            if (options.equals("点餐")) {
                String command = whatDoYouWantToEat();
                if (command.equals("臊子面")) {
                    waiter.setCommand(saoziNoodle);
                    waiter.setOrder();
                } else if (command.equals("热干面")) {
                    waiter.setCommand(reganNoddle);
                    waiter.setOrder();
                } else {
                    waiter.setCommand(changfen);
                    waiter.setOrder();
                }
            } else {
                customer.goaway();
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
