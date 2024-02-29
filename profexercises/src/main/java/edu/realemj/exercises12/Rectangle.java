package edu.realemj.exercises12;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double height = 1.0;

    public Rectangle() {}

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public String toString() {
        String s = "Rectangle: ";
        s += width + " x " + height;
        s += " --> " + super.toString();
        return s;
    }

    public double getArea() {
        return (width*height);
    }
}
