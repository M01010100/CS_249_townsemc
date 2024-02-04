package edu.realemj.exercises06;
import java.util.*;
public class GeneralStore {

    public void enter(Scanner input, Supplies supplies) {
        // Print greeting
        printGreeting();

        // In do-while loop...
        int cnt = 0;
        do {
            // Ask what you want to buy
            System.out.println("What do you want to buy/sell?");

            // User enters "cnt food"
            String line = input.nextLine();
            Scanner parseLine = new Scanner(line);
            cnt = parseLine.nextInt();
            String item = parseLine.next();

            // Update supplies based on item
            updateSupplies(cnt, item, supplies);

            // Print current supplies
            System.out.println("CURRENT:");
            System.out.println(supplies);

            // While cnt != 0
        } while(cnt != 0);

        // Print goodbye
        printGoodbye();
    }

    private void printGreeting() {
        System.out.println("** WELCOME TO MR. DO-WHILES GENERAL STORE! **");
    }

    private void printGoodbye() {
        System.out.println("** SAFE TRAVELS FRIEND! **");
    }

    private int updateSupplies(int cnt, String item, Supplies supplies) {
        String itemName = item.toLowerCase();

        switch(itemName) {
            case "food" -> {
                /*
                int current = supplies.getTotalFood();
                int updated = current + cnt;
                if(updated < 0) {
                    cnt = cnt - updated;
                    updated = 0;
                }
                supplies.setTotalFood(updated);
                */
                cnt = supplies.updateTotalFood(cnt);
            }
            default -> {
                System.out.println("I'm sorry but we don't carry " + itemName + ".");
                cnt = 0;
            }
        }

        return cnt;
    }
}
