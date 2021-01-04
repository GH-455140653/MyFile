package practice;


public class thirteen {
    public static void main(String[] args) {
        Cylinder_1 CL = new Cylinder_1(5.5, 4);
        Cuboid CB = new Cuboid(3, 4, 5);
        System.out.println(CL.computeVolume(CL.area(), CL.height));
        System.out.println(CL.computeVolume(CB.area(),CB.height));
    }
}

class Geometry {
    public double computeVolume(double area, double height) {
        return area * height;
    }
}

class Cuboid extends Geometry {
    double length;
    double width;
    double height;

    public Cuboid(double l, double w, double h) {
        length = l;
        width = w;
        height = h;
    }

    public double area() {
        return length * width;
    }
}

class Cylinder_1 extends Geometry {
    double radius;
    double height;

    public Cylinder_1(double r, double h) {
        radius = r;
        height = h;
    }

    public double area() {
        return radius * radius * Math.PI;
    }
}
