package edu.townsemc.assign03;
import java.util.Scanner;
public class Hallmark {
    public static GreetingCard generateCard(Scanner input){
        System.out.println("Enter boundary character:");
        char boundaryChar = input.nextLine().charAt(0);

        System.out.println("Enter number of lines:");
        int numberOfLines = Integer.parseInt(input.nextLine());

        String[] allLines = new String[numberOfLines];
        System.out.println("Enter lines:");
        for(int i = 0; i < numberOfLines; i++){
            allLines[i] = input.nextLine();
        }
    return new GreetingCard(allLines, boundaryChar);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GreetingCard n = generateCard(scanner);
        System.out.println("For any occasion:");
        System.out.println(n);
    }
}