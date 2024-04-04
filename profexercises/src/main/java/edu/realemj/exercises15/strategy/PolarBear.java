package edu.realemj.exercises15.strategy;

public class PolarBear extends Bear {

    public PolarBear() {
        super(new MoveWithFourLegs());
    }

    public void draw() {
        System.out.println("POLAR BEAR");
    }
}
