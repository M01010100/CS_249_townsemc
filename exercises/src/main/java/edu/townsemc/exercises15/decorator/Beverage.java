package edu.townsemc.exercises15.decorator;

import java.lang.ref.SoftReference;

public abstract class Beverage {
    protected String desc = "";
    protected Beverage(String desc){
        this.desc = desc;
    }
    public String getDescription(){
        return desc;
    }
    public abstract double cost();
}
