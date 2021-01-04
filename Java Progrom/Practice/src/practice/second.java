package practice;

import javax.swing.JOptionPane;

public class second {//对话框求圆的面积
    public static void main (String[] args){
        String temp = JOptionPane.showInputDialog(null,
                "please input radius",
                "input",
                JOptionPane.QUESTION_MESSAGE);
        int radius = Integer.parseInt(temp);

        temp = JOptionPane.showInputDialog(null,
                "please input PI",
                "input",
                JOptionPane.QUESTION_MESSAGE);
        double pi = Double.parseDouble(temp);

        double area = pi * radius * radius;
        JOptionPane.showMessageDialog(null,
                "the area of circle is:" + area,
                "output",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
