package edu.realemj.exercises08;

public class Statistics {
    private double [] data;

    public Statistics(double [] numbers) {
        data = new double[numbers.length];
        for(int i = 0; i < data.length; i++) {
            data[i] = numbers[i];
        }
    }

    public double getMean() {
        double sum = 0;
        //for(int i = 0; i < data.length; i++) {
        //    sum += data[i];
        //}
        for(double d: data) {
            sum += d;
        }

        double ave = sum/data.length;
        return ave;
    }

    public double getStdDev() {
        double ave = getMean();
        double sum = 0;
        for(double d: data) {
            d = (d - ave);
            d *= d;
            sum += d;
        }
        sum /= data.length;
        return Math.sqrt(sum);
    }

    public String toString() {
        double mean = getMean();
        double stddev = getStdDev();
        String s = "MEAN = " + mean + "\n";
        s += "STD DEV = " + stddev + "\n";
        return s;
    }
}
