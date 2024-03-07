package edu.townsemc.assign04;

public class GameBoard {
    private char filler = 0;
    private char [][] gameBoard;
    public GameBoard(int rowCnt, int colCnt, char fillChar){
        filler = fillChar;
        gameBoard = new char[rowCnt][colCnt];
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[i].length; j++){
                gameBoard[i][j] = filler;
            }
        }
    }
    public void clear(){
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[i].length; j++){
                gameBoard[i][j] = filler;
            }
        }
    }
    public int getRowCnt(){
        return gameBoard.length;
    }
    public int getColCnt(){
        return gameBoard[0].length;
    }
    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < gameBoard.length && col >= 0 && col < gameBoard[0].length;
    }
    public char getPos(int row,int col){
        if (isValidPosition(row, col)) {
            return gameBoard[row][col];
        }
        return ' ';
    }
    public boolean setPos(int row, int col, char c){
        if(isValidPosition(row,col)){
            gameBoard[row][col] = c;
            return true;
        }else {
            return false;
        }
    }
    public String toString(){
        String s = getRowCnt() + " x " + getColCnt() + " GameBoard (default: " + filler + ")";
        return s;
    }
    public String getBoardString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                sb.append(gameBoard[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
