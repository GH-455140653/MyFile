package exam.Operation;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import exam.SystemForm;

public class Opera_Rant {
    private final String admin = SystemForm.ADMIN;
    private static final String path = System.getProperty("user.dir") + "\\src\\exam\\cash\\save\\rantData.doc";//默认文件存放路径
    private static final String pathP = System.getProperty("user.dir") + "\\src\\exam\\cash\\save\\personData.doc";//默认文件存放路径
    private static final String pathR = System.getProperty("user.dir") + "\\src\\exam\\cash\\save\\resourceData.doc";//默认文件存放路径
    private static ArrayList<String> list_Pno = new ArrayList<>();
    private static ArrayList<String> list_Rno = new ArrayList<>();
    private static ArrayList<String> list_name = new ArrayList<>();
    private static ArrayList<String> list_cost_w = new ArrayList<>();
    private static ArrayList<String> list_cost_e = new ArrayList<>();
    private static ArrayList<String> list_cost = new ArrayList<>();

    pThread person = new pThread("个人资料线程");
    rThread resource = new rThread("资源线程");
    Thread PThread = new Thread(person);
    Thread RThread = new Thread(resource);

    public Opera_Rant() {
    }

    public void select() {
        try {
            PThread.start();//从个人信息文件获取信息
            RThread.start();//从资源信息表获取信息
            RThread.join();//读取数据前先等待两个线程完成

            if (list_Pno.size() == list_Rno.size()) {
                //数据处理得出当月房租值
                ArrayList<String> list_rant = new ArrayList<>();
                for (int i = 1; i < list_Rno.size(); i++) {
                    int temp = Integer.parseInt(list_cost_w.get(i)) + Integer.parseInt(list_cost_e.get(i)) + Integer.parseInt(list_cost.get(i));
                    String str = Integer.toString(temp);
                    list_rant.add(str);
                }
                //数据写入文件
                FileWriter out = new FileWriter(path);
                BufferedWriter bout = new BufferedWriter(out);
                for (int i = 0; i < list_Pno.size(); i++) {
                    bout.write(list_Pno.get(i) + "\t\t");
                    bout.write(list_name.get(i) + "\t\t");
                    bout.write(list_cost_w.get(i) + "\t\t");
                    bout.write(list_cost_e.get(i) + "\t\t");
                    bout.write(list_cost.get(i) + "\t\t");
                    if (i == 0) {//写入字段
                        bout.write("房租\n");
                    } else {
                        bout.write(list_rant.get(i - 1) + "\n");
                    }
                }
                bout.close();

                //读取文件内容并输出
                FileReader in = new FileReader(path);
                BufferedReader bin = new BufferedReader(in);
                String str;
                while ((str = bin.readLine()) != null) {
                    System.out.println(str);
                }
                bin.close();
                System.out.println();
            } else {
                System.out.println("住客信息表和资源信息表数量不一致,请回到系统检查这两个表!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("该路径下文件没找到!");
        } catch (IOException e) {
            System.out.println("文件写入失败!");
        } catch (InterruptedException e) {
            System.out.println("线程访问失败！");
        }

        Opera_Log log = new Opera_Log(admin, "查询了出租房收费表");
        log.record();
    }

    private static class pThread implements Runnable {
        String threadName;

        public pThread(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            try {
                FileReader reader = new FileReader(pathP);
                BufferedReader bread = new BufferedReader(reader);
                ArrayList<String> list = new ArrayList<>();
                StringTokenizer arr;

                //读数据
                String temp;
                while ((temp = bread.readLine()) != null) {
                    list.add(temp + "\n");
                }

                //获取指定数据
                list_Pno.clear();
                list_name.clear();
                list_cost.clear();
                for (String s : list) {
                    arr = new StringTokenizer(s);
                    int count = 0;
                    while (arr.hasMoreTokens()) {
                        count++;
                        String t = arr.nextToken();
                        if (count == 1) list_Pno.add(t);
                        if (count == 4) list_name.add(t);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("文件找不到读取路径！");
            } catch (IOException e) {
                System.out.println("文件读取失败！");
            }
        }//线程读取personData.doc文档内容获取指定内容
    }

    private static class rThread implements Runnable {
        String threadName;

        public rThread(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            try {
                FileReader reader = new FileReader(pathR);
                BufferedReader bread = new BufferedReader(reader);
                ArrayList<String> list = new ArrayList<>();
                StringTokenizer arr;

                //读数据
                String temp;
                while ((temp = bread.readLine()) != null) {
                    list.add(temp + "\n");
                }

                //获取指定数据
                list_Rno.clear();
                list_cost_e.clear();
                list_cost_w.clear();
                list_cost.clear();
                for (String s : list) {
                    arr = new StringTokenizer(s);
                    int count = 0;
                    while (arr.hasMoreTokens()) {
                        count++;
                        String t = arr.nextToken();
                        if (count == 1) list_Rno.add(t);
                        if (count == 2) list_cost_w.add(t);
                        if (count == 3) list_cost_e.add(t);
                        if (count == 4) list_cost.add(t);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("文件找不到读取路径！");
            } catch (IOException e) {
                System.out.println("文件读取失败！");
            }
        }//线程读取resourceData.doc文档内容获取指定内容
    }
}
