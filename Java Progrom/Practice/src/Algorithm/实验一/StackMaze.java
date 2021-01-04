package Algorithm.实验一;

import java.util.Objects;
import java.util.Stack;
/*
迷宫
 */

public class StackMaze {
    private static int[][] arr = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };


    public static void print(int[][] arr1) {            //打印地图的方法
        for (int[] ints : arr1) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 1) {
                    System.out.print("▇" + "\t");
                } else if (ints[j] == 3) {
                    System.out.print("*" + "\t");
                } else {
                    System.out.print("  " + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node start = new Node(1, 0, 0);
        Node end = new Node(18, 19, 0);

        Stack<Node> path = findPath(start, end);

        for (Node o : path) {
            arr[o.x][o.y] = 3;
        }


        print(arr);
    }


    private static Stack<Node> findPath(Node start, Node end) {

        //进行放入栈
        Stack<Node> nodes = new Stack<>();


        //进入栈 里面的都进行标记 标记的都是为 2
        arr[start.x][start.y] = 2;
        nodes.push(start);

        while (true) {
            if (nodes.isEmpty()) {
                return null;
            }

            //取出node
            Node top = nodes.peek();

            //如果是最后 跳出
            if (Objects.equals(top, end)) {
                return nodes;
            }


            //通过top 找到能够进行走的下一步的节点
            Node findNode = null;
            while (top.direct < 4) {
                top.direct++;
                Node node = null;
                switch (top.direct) {
                    case 1:// 上
                        node = existNode(top.x - 1, top.y, 0);
                        break;
                    case 2://右
                        node = existNode(top.x, top.y + 1, 0);
                        break;
                    case 3://下
                        node = existNode(top.x + 1, top.y, 0);
                        break;
                    case 4://左
                        node = existNode(top.x, top.y - 1, 0);
                        break;
                }
                if (Objects.nonNull(node)) {
                    findNode = node;
                    break;
                }
            }

            //如果找不到节点 就弹出节点
            if (Objects.isNull(findNode)) {
                arr[top.x][top.y] = 0;
                nodes.pop();
                continue;
            }

            //找到就压入节点
            nodes.push(findNode);

        }

    }

    static private Node existNode(int x, int y, Integer direct) {

        //判断x y所构成的节点是否合法
        if (x >= 0 && x <= 19
                && y >= 0 && y <= 19
                && arr[x][y] == 0) {
            arr[x][y] = 2;
            return new Node(x, y, direct);
        }

        return null;
    }
}
