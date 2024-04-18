package edu.realemj.exercises15.decorator;

public class JavaBytes {
    public static void main(String [] args) {
        Beverage coffee = new MediumRoast();

        coffee = new OatMilk(coffee);
        coffee = new Creamer(coffee);
        coffee = new Creamer(coffee);

        System.out.println(coffee.getDescription());
        System.out.println("COST: $" + coffee.cost());
    }
}
