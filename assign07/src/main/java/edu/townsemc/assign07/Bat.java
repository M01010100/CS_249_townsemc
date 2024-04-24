package edu.townsemc.assign07;

import edu.townsemc.assign04.GameBoard;
import edu.townsemc.assign06.Creature;

public class Bat extends Creature implements Mover {
    private MoveAlgorithm moveAlgorithm;
    public Bat(){
        this.moveAlgorithm = new AvoidPlayer();
    }
    public Bat(int row, int col){
        super(row, col);
        this.moveAlgorithm = new AvoidPlayer();
    }
    public String toString(){
        return "Bat at " + getRow() +","+ getCol();
    }
    public void draw(GameBoard map){
        map.setPos(getRow(),getCol(),'B');
    }
    public void performMove(Player p){
        moveAlgorithm.move(this,p);
    }


}