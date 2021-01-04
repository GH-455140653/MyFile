package nepu.oop1;

public class Cricle {
    double radius;
    double pi=3.1415926535;
    public Cricle(double r){
        radius=r;
    }
    public double area(){
        return pi*(radius*radius);
    }
    public double Perimeter(){
        return 2*pi*radius;
    }
}
