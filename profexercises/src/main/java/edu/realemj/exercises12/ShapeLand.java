package edu.realemj.exercises12;
import edu.realemj.exercises09.Matrix;
public class ShapeLand {
    public static void main(String [] args) {
        Shape s1 = new Shape(Matrix.makePoint2D(-5,3), true);
        System.out.println(s1);
        Circle c1 = new Circle();
        c1.setCenter(Matrix.makePoint2D(8,9));
        System.out.println(c1);
        Rectangle r1 = new Rectangle(24, 14.7);
        System.out.println(r1);
        printArea(s1);
        printArea(c1);
        printArea(r1);

        Shape [] myShapes = new Shape[3];
        myShapes[0] = s1;
        myShapes[1] = c1;
        myShapes[2] = r1;

        System.out.println("MY SHAPES:");
        for(Shape s : myShapes) {
            System.out.println("* " + s);
        }
    }

    public static void printArea(Shape s) {
        System.out.println("** AREA OF THIS MAGNIFICENT SHAPE ******");
        System.out.println(s.getArea());
        if(s instanceof Circle c) {
            //Circle c = (Circle) s;
            System.out.println("Radius = " + c.getRadius());
        }
        System.out.println("****************************************");
    }
}
