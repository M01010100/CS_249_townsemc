package edu.townsemc.exercises15.decorator;

public class MediumRoast extends Beverage{
    public MediumRoast(){
        super("Medium Roast");
    }

    @Override
    public double cost(){
        return 2.99;
    }

}
