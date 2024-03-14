package edu.townsemc.exercises13;

import java.util.Arrays;
import java.util.Scanner;

public class Mystery {
    /*public static void swapCoords(double [] coords) {
        double tmp = coords[0];
        coords[0] = coords[1];
        coords[1] = tmp;
    }
    public static void main(String [] args) {
        double [] point = { 3.5, 8.9 };
        swapCoords(point);
        System.out.println(Arrays.toString(point));
        for(int i = 0; i < 10; i++)
            System.out.println(random());
    }
    public static int random() {
        int limit = (int) (Math.random() * 6);
        return limit;
    }

     */
        public static void main(String[] args) {
            System.out.println("SHE LIKES MY SPARK!");

            System.err.println("May all your bacon burn.");

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter speed: ");
            double speed = scanner.nextDouble();

            System.out.println("Speed: " + speed);

            int [] dwarves = new int[7];
            dwarves[0] = 6;
            String message = "Hello";

            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                System.out.println(ch);
            }
        }
    }




