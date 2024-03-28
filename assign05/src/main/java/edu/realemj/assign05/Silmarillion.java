package edu.realemj.assign05;

import java.util.Scanner;

public class Silmarillion {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        Woods fangorn = new Woods();

        String typeName = "";
        boolean keepGoing = true;

        do {
            System.out.println("**********");
            System.out.println("Enter name:");
            String name = input.nextLine().trim();
            System.out.println("Enter type:");
            typeName = input.nextLine().toUpperCase().trim();
            System.out.println("**********");

            keepGoing = fangorn.addGiant(name, typeName);

        }while(keepGoing); 

        fangorn.printAllGiants();
        fangorn.printAllTrees();
        fangorn.printAllTrolls();

        input.close();
    }
}
