package edu.realemj.exercises15.decorator;

public abstract class Beverage {
    protected String desc = "";

    protected Beverage(String desc) {
        this.desc = desc;
    }

    public String getDescription() {
        return desc;
    }

    public abstract double cost();
}
