package edu.realemj.exercises07;
import edu.realemj.exercises06.*;
public class MethodLand {

    public static void noChangePrimitive(int x) {
        x = 7;
    }

    public static void noChangeSupplies(Supplies s) {
        s = new Supplies(300);
    }

    public static void doesChangeSupplies(Supplies s) {
        s.setTotalFood(400);
    }
    public static void main(String [] args) {
        int x = 5;
        noChangePrimitive(x);
        System.out.println("x = " + x);
        Supplies s = new Supplies(200);
        noChangeSupplies(s);
        System.out.println(s);
        doesChangeSupplies(s);
        System.out.println(s);
    }
}
