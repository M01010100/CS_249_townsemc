package edu.townsemc.exercises10;
import edu.townsemc.exercises09.*;

import edu.townsemc.exercises09.*;

public class Circle {
    private double radius = 1.0;
    private Matrix pos = Matrix.makePoint2D(0,0);
    public Circle(){}
    public Circle(double r){
        //radius = r;
        setRadius(r);
    }
    public Circle(double r, Matrix c){
        setRadius(r);
        setCenter(c);
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double r) {
        if (isValidRadius(r)) {
            radius = r;
        }
    }
    public static boolean isValidRadius(double r){
        return (r >=0);
    }
    public Matrix getCenter(){
        return new Matrix(pos);
    }
    public void setCenter(Matrix c){
        pos = new Matrix(c);
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }
    public String toString(){
        String s = "(Circle) r = " + radius + "\n";
        s += "center = \n";
        s += pos + "\n";
        return s;
    }
}


