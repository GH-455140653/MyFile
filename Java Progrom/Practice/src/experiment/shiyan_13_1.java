package experiment;

import java.io.*;

public class shiyan_13_1 {
    public static void main(String[] args) {
        newThread newth = new newThread("新线程");
        Thread t1 = new Thread(newth);
        t1.start();
        for (int i = 0; i < 1000; i++) {
            int temp = (int) (Math.random() * i);
            System.out.printf("我是%d主线程！\n我的随机数为：%d\n",i,temp);
        }
    }
}

class newThread implements Runnable {
    String threadName;

    public newThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        String path = System.getProperty("user.dir") + "\\cash";
        FileInputStream in = null;
        try {
            in = new FileInputStream(path + "\\1.BMP");
        } catch (FileNotFoundException e) {
            System.out.println("保存路径建立失败！");
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path + "\\2.BMP");
        } catch (FileNotFoundException e) {
            System.out.println("没有找到指定文件！");
        }

        assert in != null;
        BufferedInputStream bin = new BufferedInputStream(in);
        assert out != null;
        BufferedOutputStream bout = new BufferedOutputStream(out);
        int temp;
        while (true) {
            try {
                if ((temp = bin.read()) == -1)
                    break;
                else {
                    bout.write(temp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bin.close();
            bout.close();
            System.out.println("我是新线程！\n文件写入完成!");
        } catch (IOException e) {
            System.out.println("未打开指定文件");
        }
    }
}
