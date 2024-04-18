package edu.realemj.assign07;

import edu.realemj.assign04.GameBoard;
import edu.realemj.assign06.*;
import java.util.*;
public class Thunderdome {
    public static void main(String [] args) {
        GameBoard dungeonMap = new GameBoard(7, 31, '.');
        ArrayList<Creature> everyone = new ArrayList<>();
        Player roadWarrior = new Player(3, 15);
        everyone.add(roadWarrior);
        everyone.add(new Orc(0,0));
        everyone.add(new Orc(3,1));
        everyone.add(new Orc(5,21));
        everyone.add(new Orc(1,29));

        everyone.add(new Bat(1,15));
        everyone.add(new Bat(3,13));
        everyone.add(new Bat(3,17));
        everyone.add(new Bat(4,14));



        Scanner input = new Scanner(System.in);
        char token = ' ';

        do {
            // Clear map
            dungeonMap.clear();

            // Draw everyone on
            for(Creature c: everyone) {
                c.draw(dungeonMap);
            }

            // Draw map
            System.out.println("MAP:");
            System.out.println(dungeonMap.getBoardString());

            // Get input from user
            System.out.println("Enter action:");
            token = input.next().charAt(0);

            switch(token) {
                case 'w' -> roadWarrior.setRow(roadWarrior.getRow()-1);
                case 's' -> roadWarrior.setRow(roadWarrior.getRow()+1);
                case 'a' -> roadWarrior.setCol(roadWarrior.getCol()-1);
                case 'd' -> roadWarrior.setCol(roadWarrior.getCol()+1);
            }

            // Calculate AI
            for(Creature c: everyone) {
                if(c instanceof Mover m) {
                    m.performMove(roadWarrior);
                }
            }
        }while(token != 'x');
    }
}
