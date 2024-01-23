package edu.townsemc.exercises02;

public class NPC {
    private String name = "";
    private int health = 100;
    private int Strength = 0; //array if full special
    public NPC() {}
    public NPC(String n){
        name = n;
    }
    public String getName() {
        return name;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int h){
        if(h < 0){
            h = 0;
        }
        if(h > 200){
            h=200;
        }
        health = h;
    }
    public int getStrength(){
        return Strength;
    }
    public void setStrength(int s){
        if(s > 0 && s<15){
            Strength = s;
        }
    }
}
