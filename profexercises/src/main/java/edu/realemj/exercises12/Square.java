package edu.realemj.exercises12;

public class Square extends Shape {
    private double side = 1.0;

    public Square() {}

    public Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return side*side;
    }
}
