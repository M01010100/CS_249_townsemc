package edu.realemj.exercises12;
import edu.realemj.exercises09.Matrix;
import edu.realemj.exercises13.InvalidRadiusException;
import java.util.*;

public class ShapeLand {
    public static void main(String [] args) {
        Shape s1 = new Shape(Matrix.makePoint2D(-5,3), true);
        System.out.println(s1);
        Circle c1 = new Circle();
        c1.setCenter(Matrix.makePoint2D(8,9));
        System.out.println(c1);
        Rectangle r1 = new Rectangle(24, 14.7);
        System.out.println(r1);

        try {
            Circle c2 = new Circle(5.0);
            Circle c3 = new Circle(-7.0);
        }
        catch(InvalidRadiusException r) {
            System.out.println(r);
        }

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

        try {
            Scanner input = new Scanner(System.in);
            Circle c4 = askForCircleInfo(input);
            System.out.println("Serious putty radius: " + c4.getRadius());
        }
        catch(InvalidRadiusException r) {
            r.printStackTrace();
        }

        System.out.println("DONE");
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

    public static Circle askForCircleInfo(Scanner s) throws InvalidRadiusException {
        Circle c = null;

        try {
            System.out.println("Enter radius value:");
            double r = s.nextDouble();
            c = new Circle(r);
            System.out.println("Here is your circle:");
            System.out.println(c);
        }
        catch(Exception e) {
            throw new InvalidRadiusException("Bad radius", e);
        }

        return c;
    }
}
