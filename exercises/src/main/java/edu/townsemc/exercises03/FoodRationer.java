package edu.townsemc.exercises03;
import java.util.*;
public class FoodRationer {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        final double LOW_Rations = 1;
        final double Decent_Rations = 2;
        final double HIGH_Rations = 3;
        System.out.println("Enter number of party: ");
        int partyCnt = input.nextInt();

        System.out.println("Enter Total Food: ");
        double totalFood = input.nextDouble();
        double rations = Decent_Rations;


        /*System.out.println("Enter Ration type: 1 Low, 2 Decent, 3 High");
        int type = 0;
        type = input.nextInt();
        if(type >0 && type < 4) {
             rations = type;
             double foodPerDay = partyCnt * rations;
             double daysLeft = totalFood/foodPerDay;
            System.out.println("Days Left: " + daysLeft);
        }else {
            System.out.println("Invalid Ration Type; Survival Percentage = 0 ");
            double daysLeft = 0;
            System.out.println("Days Left: " + daysLeft);
        }
         */
        double foodPerDay = partyCnt * rations;
        double daysLeft = totalFood/foodPerDay;

        System.out.println("Days Left: " + daysLeft);
    }
}
