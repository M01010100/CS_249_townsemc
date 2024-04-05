package edu.townsemc.exercises12;
public class Square extends Shape{
    private Double side = 1.0;
    public Square(){}
    public Square(double side) {
        this.side = side;
    }
    public double getArea(){
        return side*side;
    }
}
