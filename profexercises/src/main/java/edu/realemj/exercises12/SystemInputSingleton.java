package edu.realemj.exercises12;
import java.util.*;
public class SystemInputSingleton {

    private static SystemInputSingleton instance;

    public static SystemInputSingleton getInstance() {
        if(instance == null) {
            instance = new SystemInputSingleton();
        }
        return instance;
    }

    private SystemInputSingleton() {}

    private Scanner input = new Scanner(System.in);

    public Scanner getScanner() {
        return input;
    }
}
