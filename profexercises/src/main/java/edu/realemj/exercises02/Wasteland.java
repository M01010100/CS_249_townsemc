package edu.realemj.exercises02;

public class Wasteland {
    public static void main(String [] args) {
        System.out.println("War...war never changes.");

        NPC bob = new NPC("Bob Bobertson");
        NPC sue = new NPC();

        System.out.println(bob.getName() + "'s health: " + bob.getHealth());
        bob.setHealth(-2000);
        System.out.println(bob.getName() + "'s health: " + bob.getHealth());
    }
}
