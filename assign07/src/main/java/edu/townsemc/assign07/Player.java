package edu.townsemc.assign07;

import edu.townsemc.assign04.GameBoard;
import edu.townsemc.assign06.Creature;

public class Player extends Creature {
    public Player(){super();}
    public Player(int row, int col){
        super(row, col);
    }
    public String toString(){
        return "Player at " + getRow() + "," + getCol();
    }
    public void draw(GameBoard map){
        map.setPos(getRow(),getCol(), 'P');
    }
}
