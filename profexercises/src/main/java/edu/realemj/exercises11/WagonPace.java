package edu.realemj.exercises11;

public enum WagonPace {
    STOPPED(0),
    SLOW(7),
    NORMAL(15),
    FAST(18);

    private double milesPerDay;

    private WagonPace(double miles) {
        milesPerDay = miles;
    }

    public double getMilesPerDay() {
        return milesPerDay;
    }
}
