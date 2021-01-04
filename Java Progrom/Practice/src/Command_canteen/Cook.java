package Command_canteen;

import javax.swing.*;

public class Cook {
    public void saoziNoodle() {
        JOptionPane.showMessageDialog(null,
                "臊子面正在制作中，请稍等！",
                "message",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void reganNoodle() {
        JOptionPane.showMessageDialog(null,
                "热干面正在制作中，请稍等！",
                "message",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void changfen() {
        JOptionPane.showMessageDialog(null,
                "肠粉正在制作中，请稍等！",
                "message",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
