package edu.realemj.exercises10;
import edu.realemj.exercises09.*;
public class CircleLand {
    public static void main(String [] args) {
        Circle c = new Circle();
        System.out.println(c);
        Matrix p = c.getCenter();
        p.set(0,0,27);
        System.out.println(c);
        Circle c2 = new Circle(5.6, Matrix.makePoint2D(2,-3));
        System.out.println(c2);

        boolean good = Circle.isValidRadius(5.7);
    }
}
