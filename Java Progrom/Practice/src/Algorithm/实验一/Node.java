package Algorithm.实验一;

import java.util.Objects;

public class Node {
    public int x;

    public int y;

    /**
     * 方向 记录节点的方向 1 上  2 右  3 下  4 左
     */
    public Integer direct;


    public Node(int x, int y, Integer direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
