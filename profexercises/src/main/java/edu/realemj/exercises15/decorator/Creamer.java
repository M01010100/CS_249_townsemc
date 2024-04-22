package edu.realemj.exercises15.decorator;

public class Creamer extends Condiment {
    public Creamer(Beverage core) {
        super("Creamer", core);
    }

    public String getDescription() {
        return core.getDescription() + " + " + desc;
    }

    public double cost() {
        return core.cost() + 0.52;
    }
}
