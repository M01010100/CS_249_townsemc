package edu.townsemc.exercises02;

public class Wasteland {
    public static void main(String[] args){
        System.out.println("The Enclave");
        NPC bob = new NPC("Bob Bob");
        NPC Horrigan = new NPC("Frank Horrigan");

        System.out.println("Bob's Health: " + bob.getHealth());
        bob.setHealth(125);
        System.out.println(bob.getName() + "'s Health: " + bob.getHealth());
        Horrigan.setHealth(250);
        System.out.println(Horrigan.getName() + "'s Health: " + Horrigan.getHealth());
        System.out.println(Horrigan.getName() + "'s Strength: " + Horrigan.getStrength());
        Horrigan.setStrength(12);
        System.out.println(Horrigan.getName() + "'s Strength: " + Horrigan.getStrength());

    }
}
