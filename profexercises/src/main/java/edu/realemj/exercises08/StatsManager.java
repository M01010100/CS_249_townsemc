package edu.realemj.exercises08;
import java.util.*;
public class StatsManager {
    public static double[] getRandomDoubles(int cnt, int maxval) {
        double [] data = new double[cnt];
        for(int i = 0; i < data.length; i++) {
            data[i] = Math.random()*maxval;
        }
        return data;
    }
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of values:");
        int cnt = input.nextInt();
        double [] d = getRandomDoubles(cnt, 200);
        Statistics s = new Statistics(d);
        System.out.println(s);
    }
}
