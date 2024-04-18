package edu.realemj.exercises15.decorator;

public abstract class Condiment extends Beverage {

    protected Beverage core;
    protected Condiment(String desc, Beverage core) {
        super(desc);
        this.core = core;
    }

    public abstract String getDescription();
}
