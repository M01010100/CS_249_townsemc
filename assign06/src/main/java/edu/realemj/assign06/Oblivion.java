package edu.realemj.assign06;
//NOTE: CHANGE realemj to YOUR SITNETID!!!

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oblivion {
    
    public static void main(String [] args) {
    	// Create game state
        GameState gameState = new GameState();

		// Ask user for level name
		Scanner inputUser = new Scanner(System.in);
		System.out.println("Enter level filename:");
		String levelName = inputUser.nextLine();
		inputUser.close();

		try (
			// Open level file
			Scanner levelFile = new Scanner(new File(levelName));
		) {	  
            gameState.load(levelFile);
		}
		catch(FileNotFoundException e) {
			System.err.println("Game File Error: " + levelName + " not found!");
		}
		catch(Exception e) {
		    System.err.println("Game File Error: " + e.getMessage());
		    //e.printStackTrace();
		}

		// Print game state
        System.out.println(gameState);		
	}
}
