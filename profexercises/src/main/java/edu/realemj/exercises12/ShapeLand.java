package edu.realemj.exercises12;
import edu.realemj.exercises09.Matrix;
public class ShapeLand {
    public static void main(String [] args) {
        Shape s1 = new Shape(Matrix.makePoint2D(-5,3), true);
        System.out.println(s1);
        Circle c1 = new Circle();
        c1.setCenter(Matrix.makePoint2D(8,9));
        System.out.println(c1);
    }
}
