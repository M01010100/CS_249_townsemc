package edu.realemj.exercises15.strategy;

public class TeddyBear extends Bear {

    public TeddyBear() {
        super(new NoMove());
    }

    public void draw() {
        System.out.println("TEDDY BEAR");
    }
}
