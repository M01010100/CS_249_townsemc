package edu.townsemc.assign07;

import edu.townsemc.assign04.GameBoard;
import edu.townsemc.assign06.Creature;

public class Orc extends Creature implements Mover {
    private MoveAlgorithm moveAlgorithm;
    public Orc(){
        this.moveAlgorithm = new SeekPlayer();
    }
    public Orc(int row, int col){
        super(row, col);
        this.moveAlgorithm = new SeekPlayer();
    }
    public String toString(){
        return "Orc at " + getRow() +","+ getCol();
    }
    public void draw(GameBoard map){
        map.setPos(getRow(),getCol(),'O');
    }
    public void performMove(Player p){
        moveAlgorithm.move(this,p);
    }
}
