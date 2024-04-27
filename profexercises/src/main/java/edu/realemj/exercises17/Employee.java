package edu.realemj.exercises17;

public class Employee {
    private String name = "";
    private int yearStarted = 2024;

    public Employee() {}

    public Employee(String name, int yearStarted) {
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    public int getYearStarted() {
        // TODO
        return 0;
    }

    public int calcYearsOfService(int currentYear) {
        return currentYear - yearStarted;
    }

    public String toString() {
        return "Employee: " + name + " (started " + yearStarted + ")";
    }
}
