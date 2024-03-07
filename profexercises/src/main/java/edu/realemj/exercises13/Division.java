package edu.realemj.exercises13;
import java.util.*;
import java.io.*;
public class Division {
    public static int quotient(int a, int b) throws IOException {
        if(b == 0) {
            throw new ArithmeticException("YOU FOOL! YOU SHALL TEAR THE UNIVERSE ASUNDER!");
        }

        if(b < 0) {
            throw new IOException("Negative?");
        }

        int res = a/b;
        return res;
    }

    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        try {
            int x = input.nextInt();
            int y = input.nextInt();
            int z = quotient(x, y);
            System.out.println("Ans: " + z);
        }
        catch(ArithmeticException e) {
            System.err.println("** ALERT!!!!!! ************");
            System.err.println(e.getMessage());
            //e.printStackTrace();
        }
        //catch(InputMismatchException e) {
        //    System.err.println("WHAT AILS YOUR BRAIN????");
        //}
        catch(IOException e) {
            System.err.println("NOT a good example of an IOException...");
        }
        catch(Exception e) {
            System.err.println("Something WEIRD happened.");
        }

        System.out.println("Program complete.");
    }
}
