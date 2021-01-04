package practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class twentySecond {
    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<String>();
        Stack stack = new Stack();
        stack.add(link);
        stack.delete(link);
        System.out.println("删除最后一个元素：" + link.getLast());
        link.removeLast();
        stack.teraver(link);
        System.out.println("栈出：");
        stack.zhan(link);
    }
}

class Stack {
    public void add(LinkedList<String> link) {//存入数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入堆栈元素：");
        String scan = scanner.next();
        while (!scan.equals("#")) {
            link.addLast(scan);
            scan = scanner.next();
        }
        teraver(link);
    }

    public void delete(LinkedList<String> link) {//删除指定元素
        System.out.println("你想删除第几个元素：");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        link.remove(index - 1);
        teraver(link);
    }

    public void teraver(LinkedList<String> link) {//遍历
        Iterator it = link.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public void zhan(LinkedList<String> link) {//栈出
        ListIterator it = link.listIterator(link.size());
        while (it.hasPrevious()) {
            Object obj = it.previous();
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
