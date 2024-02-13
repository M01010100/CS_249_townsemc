package edu.townsemc.exercises06;

import java.util.*;
public class OregonTrail {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Supplies supplies = new Supplies();
        GeneralStore store = new GeneralStore();

        System.out.println("BEFORE");

        store.enter(input, supplies);

        System.out.println("AFTER: ");
    }
    private static void printSupplies(String message, Supplies supplies) {
        System.out.println(message);
        System.out.println(supplies);
    }
}
