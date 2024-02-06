package edu.realemj.exercises06;

import java.util.*;
public class OregonTrail {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        Supplies supplies = new Supplies();
        Supplies other = new Supplies(200);
        GeneralStore store = new GeneralStore();

        printSupplies("BEFORE:", supplies);

        store.enter(input, supplies);

        printSupplies("AFTER:", supplies);
    }

    private static void printSupplies(String message, Supplies supplies) {
        System.out.println(message);
        System.out.println(supplies);
    }
}
