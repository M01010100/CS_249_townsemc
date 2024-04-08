package edu.realemj.exercises15.observer;

public class Batperson implements Observer {
    private String name = "";

    public Batperson(String name) {
        this.name = name;
    }

    public void update(Subject s) {
        if(s instanceof Batsignal batsig) {
            String crime = batsig.getActiveCrime();
            System.out.println("This is " + name + ", responding to " + crime);
        }
    }
}
