package edu.townsemc.exercises08;

import java.util.Scanner;

public class StatsManager {
    public static double[] getRandomDoubles(int cnt, int maxval){
        double [] data = new double[cnt];
        for(int i = 0; i < data.length; i++){
            data[i] = Math.random()*maxval;
        }
        return data;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number Values: ");
        int cnt = input.nextInt();
        double [] d = new double[5];
        Statistics s = new Statistics(d);
        System.out.println(s);
    }
}
