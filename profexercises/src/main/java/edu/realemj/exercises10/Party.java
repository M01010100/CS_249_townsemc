package edu.realemj.exercises10;

public class Party {
    private Person [] people;

    public Party(String [] names) {
        people = new Person[names.length];
        for(int i = 0; i < people.length; i++) {
            people[i] = new Person(names[i]);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PARTY:\n");
        for(Person p: people) {
            sb.append("* ");
            sb.append(p);
            sb.append("\n");
        }
        return sb.toString();
    }
}
