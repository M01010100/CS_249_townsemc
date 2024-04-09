package edu.townsemc.exercises15.Strategy;

public class BearSimulator {
    public static void main(String [] args) {
        Bear polar = new PolarBear();
        Bear pooh = new TeddyBear();

        polar.draw();
        polar.performMove();
        pooh.draw();
        pooh.performMove();

        polar.draw();
        polar.setMoveBehavior(new MoveWithTwoLegs());
        polar.performMove();
    }
}
