package edu.townsemc.exercises06;

public class Supplies {
    private int totalFood = 0;

    public int getTotalFood() {
        return totalFood;
    }

    public void setTotalFood(int food){
        totalFood = food;
    }

    public String toString() {
        String s = "";
        s += "*****************\n";
        s += "SUPPLIES:\n";
        s += "Food: " + totalFood +"\n";
        s += "*****************\n";
        return s;
    }
}
