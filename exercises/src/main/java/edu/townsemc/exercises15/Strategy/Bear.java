package edu.townsemc.exercises15.Strategy;

public abstract class Bear {
    private Moveable moveBehavior;

    protected Bear(Moveable m) {
        moveBehavior = m;
    }
    public void performMove() {
        moveBehavior.move();
    }

    public void setMoveBehavior(Moveable m) {
        moveBehavior = m;
    }

    public abstract void draw();
}
