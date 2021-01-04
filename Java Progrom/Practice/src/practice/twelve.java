package practice;

public class twelve {
    public static void main(String[] args) {
        Cylinder C = new Cylinder(3, 3);
        System.out.println("面积："+C.area()+"\n体积："+C.volume());
    }
}

class Cylinder {
    double pi = 3.1415926535;
    double radius;
    double height;

    Cylinder(double r, double h) {
        radius = r;
        height = h;
    }

    public double area() {
        return pi * Math.pow(radius, 2);
    }

    public double volume() {
        return area() * height;
    }
}
