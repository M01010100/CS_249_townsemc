package edu.realemj.exercises02;

public class NPC {
    private String name = "";
    private int health = 100;

    public NPC() {}

    public NPC(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int h) {
        if(h < 0) {
            h = 0;
        }
        if(h > 100) {
            h = 100;
        }
        health = h;
    }
}
