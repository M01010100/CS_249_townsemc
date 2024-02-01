package edu.realemj.exercises03;
import java.util.*;
public class FoodRationer {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        final double LOW_RATIONS = 1;
        final double DECENT_RATIONS = 2;

        System.out.println("Enter number of people:");
        int partyCnt = input.nextInt();

        String s = String.valueOf(42);

        System.out.println("Enter total food:");
        double totalFood = input.nextDouble();
        double rations = DECENT_RATIONS;

        double foodPerDay = partyCnt*rations;
        double daysLeft = totalFood/foodPerDay;

        System.out.println("DAYS LEFT: " + daysLeft);
    }
}
