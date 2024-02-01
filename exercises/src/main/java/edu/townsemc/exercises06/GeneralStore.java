package edu.townsemc.exercises06;
//import java.lang.foreign.StructLayout;
import java.util.*;
public class GeneralStore {

    public void enter(Scanner input, Supplies supplies) {
        //print greeting
        printGreeting();

        //In-do while loop
        int cnt = 0;
        do {
            //Ask what you want to buy
            System.out.println("What do you want to buy/sell");

            //usr enter "cnt food"
            String line = input.nextLine();
            Scanner parseLine = new Scanner(line);
            cnt = parseLine.nextInt();
            String item = parseLine.next();

            //update supplies by item
            updateSupplies(cnt, item, supplies);

            // current supplies
            System.out.println(supplies);
            //while cnt != 0
        } while (cnt != 0);
        //print goodbye
        printGoodbye();
    }
    private void printGreeting(){
        System.out.println("** Welcome TO MR> DO_WHILES GENERAL STORE! **");
    }
    private void printGoodbye(){
        System.out.println("** SAFE TRAVELING FRIEND **");
    }
    private int updateSupplies(int cnt, String item, Supplies supplies){
        String itemName = item.toLowerCase();
        switch(itemName) {
            case "food" -> {
               int current = supplies.getTotalFood();
               int updated = current + cnt;
               if(updated < 0){
                   cnt = cnt - updated;
                   updated = 0;
               }
               supplies.setTotalFood(updated);
            }
            default -> {
                System.out.println("I'm Sorry but we don't carry" + itemName + ".");
                cnt = 0;
            }
        }
        return cnt;
    }
}
