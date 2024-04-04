package edu.realemj.exercises14;

public class Zoo {

    public static void printRecipe(Edible e) {
        System.out.println("To eat this item:");
        System.out.println(e.howToEat());
    }
    public static void main(String [] args) {
        Chicken c = new Chicken();
        Salt s = new Salt();
        Toad t = new Toad();

        Animal c2 = new Chicken();
        Animal t2 = new Toad();

        printRecipe(c);
        printRecipe(s);
        // NOT LEGAL: printRecipe(t);
        if(c2 instanceof Edible e2) {
            printRecipe(e2);
        }

        if(t2 instanceof Edible e3) {
            printRecipe(e3);
        }




    }
}
