package edu.realemj.exercises15.decorator;

public class OatMilk extends Condiment {
    public OatMilk(Beverage core) {
        super("Oat Milk", core);
    }

    public String getDescription() {
        return core.getDescription() + " + " + desc;
    }

    public double cost() {
        return core.cost() + 0.70;
    }
}
