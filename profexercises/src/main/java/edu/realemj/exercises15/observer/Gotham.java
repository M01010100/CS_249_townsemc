package edu.realemj.exercises15.observer;

public class Gotham {
    public static void main(String [] args) {
        Batsignal batsignal = new Batsignal();

        Batperson bruce = new Batperson("Batman");
        Batperson dick = new Batperson("Nightwing");
        Batperson barb = new Batperson("Batgirl");
        Batperson jason = new Batperson("Robin");

        batsignal.registerObserver(bruce);
        batsignal.registerObserver(dick);
        batsignal.registerObserver(barb);
        batsignal.registerObserver(jason);

        batsignal.setActiveCrime("a robbery");

        batsignal.removeObserver(dick);

        batsignal.setActiveCrime("a kidnapping");

        Superperson clark = new Superperson("Superman");
        batsignal.registerObserver(clark);

        batsignal.setActiveCrime("a crossover event");
    }
}
