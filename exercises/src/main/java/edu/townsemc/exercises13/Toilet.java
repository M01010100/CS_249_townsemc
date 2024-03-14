package edu.townsemc.exercises13;

public class Toilet {
    private double gpf = 3.7;
    public Toilet(){}
    public Toilet(double gpf){
        this.gpf = gpf;
    }
    public double flush(int cnt){
        return gpf * cnt;
    }
    public static double computeGallons(int liter, double gallons){
        return liter * gallons;
    }

    public static void main(String [] args){
        Toilet privy = new Toilet(9.1);
        double gallonUsed = privy.flush(27);
        System.out.println(gallonUsed);
        double gallons = computeGallons(30,4.2);
        System.out.println(gallons);

    }
}
