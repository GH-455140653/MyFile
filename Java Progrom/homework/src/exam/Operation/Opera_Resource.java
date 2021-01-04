package exam.Operation;

import exam.SystemForm;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Opera_Resource {
    private final String admin = SystemForm.ADMIN;
    private final String path = System.getProperty("user.dir") + "\\src\\exam\\cash\\save\\resourceData.doc";//默认文件存放路径
    private String no;
    private String cost_w;
    private String cost_e;
    private String cost;

    public Opera_Resource(String no) {
        this.no = no;
    }//删

    public Opera_Resource(String no, String cost_W, String cost_E, String cost) {
        this.no = no;
        this.cost_w = cost_W;
        this.cost_e = cost_E;
        this.cost = cost;
    }//增

    public Opera_Resource() {

    }//查

    public void add() {
        try {
            fileExists();

            //建立集合存储文件中的数据
            ArrayList<String> list = new ArrayList<String>();
            ArrayList<String> list_no = new ArrayList<String>();

            //读取
            FileReader in = new FileReader(path);
            BufferedReader bin = new BufferedReader(in);
            String str;
            while ((str = bin.readLine()) != null) {
                list.add(str + "\n");
            }
            bin.close();//关闭读取

            getList_no(list, list_no);

            boolean key = true;//判断sno作为主键是否出现重复
            while (key) {
                for (int i = 1; i < list.size(); i++) {
                    if ((this.no).equals(list_no.get(i))) {
                        System.out.println("该入住编号已经存在，请重新输入入住编号！");
                        Scanner scanner = new Scanner(System.in);
                        this.no = scanner.nextLine();
                        break;
                    }
                    if (i == list.size() - 1) key = false;
                }
                if (list.size() == 1) {//判断该表只有表头
                    break;
                }
            }

            FileWriter out = new FileWriter(path);
            BufferedWriter bout = new BufferedWriter(out);

            //添加进集合
            list.add(this.no + "\t\t\t");
            list.add(this.cost_w + "\t\t");
            list.add(this.cost_e + "\t\t");
            list.add(this.cost + "\n");

            //遍历集合写入文档
            for (String index : list) {
                bout.write(index);
            }
            bout.close();//关闭写入

            Opera_Log log = new Opera_Log(admin, "添加了入住编号为" + this.no + "的资源消耗信息。");
            log.record();//日志记录

            select();

        } catch (FileNotFoundException e) {
            System.out.println("该路径下文件没找到!");
        } catch (IOException e) {
            System.out.println("文件写入失败!");
        }
    }//增

    public void delete() {
        try {
            fileExists();

            //读出文档数据并写入集合
            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> list_no = new ArrayList<>();
            FileReader in = new FileReader(path);
            BufferedReader bin = new BufferedReader(in);
            String str;
            while ((str = bin.readLine()) != null) {
                list.add(str + "\n");
            }
            bin.close();//关闭文档

            getList_no(list, list_no);

            //判断输入的值的正确性
            boolean flag = true;//写入循环判断
            boolean key = true;//输出语句循环判断
            while (flag) {
                for (int i = 1; i < list.size(); i++) {
                    if ((this.no).equals(list_no.get(i))) {
                        list.remove(i);

                        //写入文档
                        FileWriter out = new FileWriter(path);
                        BufferedWriter bout = new BufferedWriter(out);
                        for (String value : list) {
                            bout.write(value);
                        }
                        bout.close();//关闭文档

                        Opera_Log log = new Opera_Log(admin, "删除了入住编号为" + this.no + "的资源消耗信息。");
                        log.record();//日志记录

                        select();//查看修改后的数据表
                        flag = false;
                        JOptionPane.showMessageDialog(null,
                                "入住编号为" + this.no + "的租客信息已被删除！",
                                "提示",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;//跳出for
                    }
                }
                if (!flag) break;//跳出while

                if (key) System.out.println("你输入的值没有找到对应值！");
                System.out.print("请问你是否还要删除数据？(Y/N)");
                Scanner scanner = new Scanner(System.in);
                char s = scanner.next().charAt(0);
                if (s == 'y' || s == 'Y') {
                    key = true;
                    System.out.print("请重新输入你要删除的租客的入住编号：");
                    this.no = scanner.next();
                    System.out.println();
                } else if (s == 'n' || s == 'N') {
                    key = true;
                    flag = false;//跳出while，实现返回上一级
                } else {
                    System.out.println("\n请按提示正确选择并输入相应的字母！\n");
                    key = false;
                }
            }
        } catch (IOException e) {
            System.out.println("文件写入失败！");
        }
    }//删

    public void modify() {
        try {
            fileExists();

            //读出文档数据并写入集合
            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> list_no = new ArrayList<>();
            FileReader in = new FileReader(path);
            BufferedReader bin = new BufferedReader(in);
            String temp;
            while ((temp = bin.readLine()) != null) {
                list.add(temp + "\n");
            }
            bin.close();//关闭文档

            getList_no(list, list_no);

            //判断输入的值的正确性
            boolean key = true;//输出语句循环判断
            boolean flag = true;//写入循环判断
            while (flag) {
                for (int i = 1; i < list.size(); i++) {
                    if ((this.no).equals(list_no.get(i))) {
                        list.remove(i);//删除指定入住信息

                        //写入文档
                        FileWriter out = new FileWriter(path);
                        BufferedWriter bout = new BufferedWriter(out);
                        for (String value : list) {
                            bout.write(value);
                        }
                        bout.close();//关闭文档

                        //读文档
                        ArrayList<String> list_2 = new ArrayList<>();
                        FileReader in_2 = new FileReader(path);
                        BufferedReader bin_2 = new BufferedReader(in_2);
                        String str;
                        while ((str = bin_2.readLine()) != null) {
                            list_2.add(str + "\n");
                        }
                        bin_2.close();//关闭读取

                        //添加进集合list_2
                        list_2.add(this.no + "\t\t\t");
                        list_2.add(this.cost_w + "\t\t");
                        list_2.add(this.cost_e + "\t\t");
                        list_2.add(this.cost + "\n");

                        //打开文档
                        FileWriter out_2 = new FileWriter(path);
                        BufferedWriter bout_2 = new BufferedWriter(out_2);

                        //将集合list_2的数据写入文档
                        for (String index : list_2) {
                            bout_2.write(index);
                        }
                        bout_2.close();//关闭写入

                        Opera_Log log = new Opera_Log(admin, "修改了入住编号为" + this.no + "的资源消耗信息。");
                        log.record();//日志记录

                        select();
                        flag = false;
                        break;//跳出for
                    }
                }
                if (!flag) break;//跳出while

                if (key) System.out.println("该表中没有这个入住编号！");
                System.out.print("请问你是否还要修改数据？(Y/N)");
                Scanner scanner = new Scanner(System.in);
                char s = scanner.next().charAt(0);
                if (s == 'y' || s == 'Y') {
                    key = true;
                    System.out.print("请重新输入你要修改的租客的入住编号：");
                    this.no = scanner.next();
                    System.out.println();
                } else if (s == 'n' || s == 'N') {
                    key = true;
                    flag = false;//跳出while，实现返回上一级
                } else {
                    System.out.println("\n请按提示正确选择并输入相应的字母！\n");
                    key = false;
                }
            }
        } catch (IOException e) {
            System.out.println("文件写入失败！");
        }
    }//改

    public void select() {
        try {
            fileExists();
            FileReader in = new FileReader(path);
            BufferedReader bin = new BufferedReader(in);
            String str;
            while ((str = bin.readLine()) != null) {
                System.out.println(str);
            }
            bin.close();

            Opera_Log log = new Opera_Log(admin, "查询出租房客资源消耗信息");
            log.record();//日志记录

            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("该路径下文件没找到!");
        } catch (IOException e) {
            System.out.println("文件写入失败!");
        }
    }//查

    private void fileExists() {
        try {
            File file = new File(path);
            if (!(file.exists())) {//当存储文档不存在时，创建一个
                System.out.println("\n不存在存储资源消耗情况的文件,系统已经为你自动创建了一个存储文档。\n");
                //写入
                FileWriter out = new FileWriter(path);
                BufferedWriter bout = new BufferedWriter(out);
                bout.write("入住编号\t\t");
                bout.write("水费\t\t");
                bout.write("电费\t\t");
                bout.write("房租\n");
                bout.close();//关闭写入
            }
        } catch (IOException e) {
            System.out.println("文件写入失败！");
        }
    }//判断文件存在

    private void getList_no(ArrayList<String> list, ArrayList<String> list_no) {
        StringTokenizer arr;
        //读取list，筛选list中的sno
        for (String i : list) {
            int count = 0;
            arr = new StringTokenizer(i);
            while (arr.hasMoreTokens()) {
                count++;
                String s = arr.nextToken();
                if (count == 1) list_no.add(s);
            }
        }
    }
}
