package edu.realemj.assign04;

import java.util.*;

public class DraftingTable {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        GameBoard buffer = new GameBoard(7, 30, '.');
        System.out.println(buffer.getBoardString());
        char cont = 'n';
        do {
            System.out.println("Enter box coordinates (sr sc er ec):");
            int sr = input.nextInt();
            int sc = input.nextInt();
            int er = input.nextInt();
            int ec = input.nextInt();
            System.out.println("Enter drawing character:");
            char drawChar = input.next().charAt(0);
            System.out.println("Is this filled? (y/n)");
            boolean filled = (input.next().charAt(0) == 'y');
            Box b = new Box(sr, sc, er, ec, filled, drawChar);
            b.draw(buffer);
            System.out.println(buffer.getBoardString());
            System.out.println("Again? (y/n)");
            cont = input.next().charAt(0);
        }while(cont == 'y');
    }
}
