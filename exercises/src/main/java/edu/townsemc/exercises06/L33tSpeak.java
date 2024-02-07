package edu.townsemc.exercises06;
import java.util.*;
public class L33tSpeak {
    //static functions
    public static String makeL33t(String line){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            char nc = switch (c){
              case 'a','A' -> '4';
              case 'e','E' -> '3';
              case 'i','I' -> '1';
              case 'o','O' -> '0';
              default -> c;
            };
            sb.append(nc);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner lineInput = new Scanner(System.in);
        String line = "";
        do {
            System.out.println("Enter Line of Text: ");
            line = lineInput.nextLine();
            String leetLine = makeL33t(line);
            System.out.println(leetLine);
            //!line.equals(""), line.length() != 0, line.isEmpty(), line.compareTo("") != 0
        }while(!line.equals(""));
    }
}
