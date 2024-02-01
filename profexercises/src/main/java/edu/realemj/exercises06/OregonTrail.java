package edu.realemj.exercises06;

import java.util.*;
public class OregonTrail {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        Supplies supplies = new Supplies();
        GeneralStore store = new GeneralStore();

        System.out.println("BEFORE:");
        System.out.println(supplies);

        store.enter(input, supplies);

        System.out.println("AFTER:");
        System.out.println(supplies);
    }
}
