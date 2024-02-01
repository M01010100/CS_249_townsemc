package edu.realemj.exercises06;

public class Supplies {
    private int totalFood = 0;

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
        String s = "";
        s += "*******************\n";
        s += "SUPPLIES:\n";
        s += "Food: " + totalFood + "\n";
        s += "*******************\n";
        return s;
    }
}
