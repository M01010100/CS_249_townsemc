package edu.realemj.exercises12;

import edu.realemj.exercises10.*;
import java.util.*;
public class PartyMaker {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        String n = "";
        do {
            System.out.println("Enter name:");
            n = input.nextLine();
            n = n.trim();
            if (!n.isEmpty()) {
                names.add(n);
                System.out.println(names.size() + " names so far.");
            }
        }while(!n.isEmpty());

        System.out.println("NAMES:");
        System.out.println(names);
        for(int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            name = "PERSON " + name;
            names.set(i, name);
            System.out.println("* " + names.get(i));
        }

        names.remove(1);
        names.remove("PERSON D");

        System.out.println("NAMES AGAIN:");
        for(String s : names) {
            System.out.println("* " + s);
        }

    }
}
