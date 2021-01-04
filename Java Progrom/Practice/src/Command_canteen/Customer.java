package Command_canteen;

import javax.swing.*;

public class Customer {
    private String name;

    public Customer(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void order() {
    }

    public void goaway() {
        JOptionPane.showMessageDialog(null,
                getName() + "离开了。",
                "提示",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
