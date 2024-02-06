package edu.townsemc.assign02;
import java.util.Scanner;
public class Armada {
    public static void main(String[] args){
        //Scanner
        SpaceVessel vessel = new SpaceVessel();
        Scanner Input = new Scanner(System.in);
        //Name
        System.out.println("Enter vessel name: ");
        String Line = Input.nextLine();
        vessel.setName(Line);
        //L + W
        System.out.println("Enter length and weight: ");
        String Line2 = Input.nextLine();
        Scanner parseLine = new Scanner(Line2);
        int L = parseLine.nextInt();
        int W = parseLine.nextInt();
        vessel.setLength(L);
        vessel.setWeight(W);

        System.out.println(vessel.toString());
    }
}
