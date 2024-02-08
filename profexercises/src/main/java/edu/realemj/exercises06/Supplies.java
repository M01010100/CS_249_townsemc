package edu.realemj.exercises06;

public class Supplies {
    private int totalFood = 0;

    public Supplies() {}

    public Supplies(int food) {
        totalFood = food;
    }

    public int getTotalFood() {
        return totalFood;
    }

    public void setTotalFood(int food) {
        totalFood = food;
    }

    public int updateTotalFood(int cnt) {
        totalFood = totalFood + cnt;
        if(totalFood < 0) {
            cnt = cnt - totalFood;
            totalFood = 0;
        }
        return cnt;
    }

    public String toString() {
        /*
        String s = "";
        s += "*******************\n";
        s += "SUPPLIES:\n";
        s += "Food: " + totalFood + "\n";
        s += "*******************\n";
        return s;*/
        return toString("*******************");
    }

    public String toString(String bound) {
        String s = "";
        s += bound + "\n";
        s += "SUPPLIES:\n";
        s += "Food: " + totalFood + "\n";
        s += bound + "\n";
        return s;
    }
}
