package practice;

import javax.swing.JOptionPane;

public class third {
    public static void main(String [] args){//对话框方法将小写字母变成大写字母
        String paneIn = JOptionPane.showInputDialog(null,
                "please input a alphabet",
                "input",
                JOptionPane.QUESTION_MESSAGE);
        while(paneIn!=null){
            char c=paneIn.charAt(0);
            char temp=c;
            if(c>=97 && c<=122){
                c=(char)(c-32);
                JOptionPane.showMessageDialog(null,
                        paneIn+"的第一个字母为："+temp+"\n"+temp+"的大写字母为："+c,
                        "output",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "请输入正确的小写英文字母！！！",
                        "error",
                        JOptionPane.ERROR_MESSAGE);
                paneIn=JOptionPane.showInputDialog(null,
                        "please input a alphabet",
                        "input",
                        JOptionPane.QUESTION_MESSAGE);
            }
        }
        System.exit(0);
    }
}
