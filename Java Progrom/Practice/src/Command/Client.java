package Command;

import javax.swing.*;

public class Client {
    private String name;

    public Client(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void order(String command) {
        Invoker invoker = new Invoker(command, getName());
    }

    public void goaway() {
        JOptionPane.showMessageDialog(null,
                getName() + "离开了。",
                "提示",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
