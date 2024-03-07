package edu.townsemc.assign04;

import java.util.ServiceLoader;

public class Box {
    private int startRow;
    private int startCol;
    private int endRow;
    private int endCol;
    private boolean fill;
    private char draw;
    public Box(int sr,int sc,int er,int ec,boolean filled,char drawChar){
        startRow = sr;
        startCol = sc;
        endRow = er;
        endCol = ec;
        fill = filled;
        draw = drawChar;
    }
    public String toString(){
        if (fill) {
            return "Filled Box from (" + startRow + "," + startCol + ") to (" + endRow + "," + endCol + ") with char '" + draw + "'";
        } else {
            return "Box from (" + startRow + "," + startCol + ") to (" + endRow + "," + endCol + ") with char '" + draw + "'";
        }
    }
    public void draw(GameBoard s){
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (fill || i == startRow || i == endRow || j == startCol || j == endCol) {
                    s.setPos(i, j, draw);
                }
            }
        }
    }
}