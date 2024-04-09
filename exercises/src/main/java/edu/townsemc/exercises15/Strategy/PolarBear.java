package edu.townsemc.exercises15.Strategy;

public class PolarBear extends Bear{
    public PolarBear() {
        super(new MoveWithFourLegs());
    }

    public void draw() {
        System.out.println("POLAR BEAR");
    }
}
