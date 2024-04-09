package edu.townsemc.exercises15.Strategy;

public class TeddyBear extends Bear{
    public TeddyBear() {
        super(new NoMove());
    }

    public void draw() {
        System.out.println("TEDDY BEAR");
    }
}
