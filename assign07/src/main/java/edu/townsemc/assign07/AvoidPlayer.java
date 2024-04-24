package edu.townsemc.assign07;

import edu.townsemc.assign06.Creature;

public class AvoidPlayer implements MoveAlgorithm{
    @Override
    public void move(Creature current, Player p) {
        int rowDistance = p.getRow() - current.getRow();
        int colDistance = p.getCol() - current.getCol();
        if(rowDistance ==0 && colDistance == 0){
            return;
        }
        if (Math.abs(rowDistance) > Math.abs(colDistance)){
            if (rowDistance < 0){
                current.setRow(current.getRow()+1);
            } else{
                current.setRow(current.getRow()-1);
            }
        }else{
            if(colDistance < 0){
                current.setCol(current.getCol()+1);
            }else{
                current.setCol(current.getCol()-1);
            }
        }
    }
}
