package edu.townsemc.exercises13;
import java.io.IOException;
import java.util.*;
public class Division {
    public static int quotient(int a, int b)throws Exception{
      if( b == 0){
        throw new ArithmeticException("Know not what number to divide?");
      }
      if ( b < 0){
          throw new IOException("You are Negative");
      }
        return a/b;
    }

    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two numbers");
        try {
            int x = input.nextInt();
            int y = input.nextInt();
            int z = quotient(x, y);
            System.out.println("Ans: " + z);
        }
        catch (ArithmeticException e) {
            System.err.println("** ALERT!!!! *******");
            System.err.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.err.println("WHAT AILS YOUR BRAIN");
        }
        catch (IOException e){
           System.err.println("NOT a good example of an IOException");
        }
        catch(Exception e){
            System.err.println("Your Doing it Wrong");
        }
        System.out.println("PROGRESS COMPLETE");
    }
}

