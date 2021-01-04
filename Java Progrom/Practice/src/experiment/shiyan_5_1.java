package experiment;

public class shiyan_5_1 {
    public static void main(String[] args) {
        Point P_0 = new Point();
        Point P_1 = new Point(15.5, 12.5);
        P_0.show();
        P_1.show();
    }

    static class Point {
        public double x;
        public double y;

        Point() {
            this.x = 0;
            this.y = 0;
        }

        Point(double a, double b) {
            this.x = a;
            this.y = b;
        }

        public void show() {
            System.out.printf("该坐标的x值为：%g,y的值为：%g\n", this.x, this.y);
        }
    }
}
