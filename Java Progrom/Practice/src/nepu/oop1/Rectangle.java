package nepu.oop1;

public class Rectangle {
    double height;
    double width;
    public Rectangle(double h,double w){
        height=h;
        width=w;
    }
    public double area(){
        return (height*width);
    }
    public double Perimeter(){
        return (height+width)*2;
    }
}
