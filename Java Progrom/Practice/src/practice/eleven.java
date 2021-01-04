package practice;

public class eleven {//求两点之间的距离
    public static void main(String[] args) {
//        practice.Stock c = new practice.Stock();
        MyPoint point_1 = new MyPoint();
        MyPoint point_2 = new MyPoint(10, 30.5);
        System.out.println(point_2.distance(point_1.x, point_1.y));

    }
}

class Stock {
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;

    Stock() {
        symbol = "SUNW";
        name = "Microsystems";
        System.out.println(currentPrice);
        System.out.println("离开前的价格与现在价位的变化的比率为：" + changePercent());
    }

    public double changePercent() {
        return (currentPrice - previousClosingPrice) * 100;
    }
}

class MyPoint {
    double x;
    double y;

    public MyPoint() {
        x = 0;
        y = 0;
    }

    public MyPoint(double a, double b) {
        x = a;
        y = b;
    }

    public double distance(double a, double b) {
        double temp = Math.pow(x - a, 2) + Math.pow(y - b, 2);
        return Math.sqrt(temp);
    }
}
