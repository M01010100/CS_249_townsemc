package edu.townsemc.assign06;

import edu.townsemc.assign04.GameBoard;

public class Rat extends Creature{
    public Rat(){
        super();
    }
    public Rat(int row, int col){
        super(row, col);
    }
    public String toString(){
        return "Rat at " +getRow()+","+getCol();
    }
    public void draw(GameBoard map){
        map.setPos(getRow(),getCol(), 'R');
    }
}

