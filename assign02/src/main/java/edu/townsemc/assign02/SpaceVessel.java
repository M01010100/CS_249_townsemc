package edu.townsemc.assign02;

public class SpaceVessel {
    private int length = 0;
    private String vesselName = "";
    private int weight =0;

    public String getName(){
        return vesselName;
    }
    public int getLength(){
        return length;
    }
    public int getWeight(){
        return weight;
    }
    public void setName(String name){
        vesselName = name;
    }
    public void setLength(int feet){
        length = feet;
    }
    public void setWeight(int pounds){
        weight = pounds;
    }
    public String getLengthString(){
        String meters = "";
        meters = length + " ft. (" + String.format("%.2f", length * 0.3048) + " m)";
        return meters;
    }
    public String getWeightString(){
        String Kilos = "";
        Kilos = weight + " lbs. (" + String.format("%.2f", weight * 0.4536) + " kg)";
        return Kilos;
    }
    public String toString(){
        String stats = "";
        stats = "NAME: " + vesselName +"\n"+"LENGTH: " + getLengthString() + "\n" + "WEIGHT: " + getWeightString() + "\n";
        return stats;
    }
}
