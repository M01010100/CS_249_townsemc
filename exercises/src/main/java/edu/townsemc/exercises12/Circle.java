package edu.townsemc.exercises12;
import edu.townsemc.exercises09.*;
public class Circle extends Shape{
    private static final double DEFAULT_RADIUS = 1.0;
    private double radius = DEFAULT_RADIUS;
    public Circle(){
        this(DEFAULT_RADIUS, Matrix.makePoint2D(0,0));
    }
    public Circle(double r){
        this(r, Matrix.makePoint2D(0,0));
    }
    public Circle(double r, Matrix c){
        setRadius(r);
        setCenter(c);
    }
    public Circle(double r, Matrix c, boolean filled){
        setRadius(r);
        setCenter(c);
        this.filled=filled;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius) {
        if (isValidRadius(radius)) {
            this.radius=radius;
        }
    }
    public static boolean isValidRadius(double r){
        return (r >=0);
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }
    //public String toString(){
    //    return " "
   // }
}
