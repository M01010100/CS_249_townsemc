package edu.townsemc.assign06;

import java.lang.invoke.VolatileCallSite;
import java.util.Scanner;
public class Item implements Loadable{
    private String ID;
    private int Value;
    public Item(){
        this.ID = "";
        this.Value = 0;
    }
    public Item(String ID, int Value){
        this.ID = ID;
        this.Value = Value;
    }
    public String getID(){
        return ID;
    }
    public int getValue(){
        return Value;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public void setValue(int Value){
        this.Value = Value;
    }
    public String toString(){
        return ID + " with value "+ Value;
    }
    public void load(Scanner input) throws GameFileException {
        try{
            ID = input.next();
            Value = input.nextInt();
        } catch (Exception e){
            ID = "";
            Value = 0;
            throw new GameFileException("Error loading Item", e);
        }
    }
}
