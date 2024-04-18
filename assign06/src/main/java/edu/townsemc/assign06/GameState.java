package edu.townsemc.assign06;

import edu.townsemc.assign04.GameBoard;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GameState implements Loadable{
    private List<Loadable> loadableList;
    private GameBoard map;

    public GameState(){
        loadableList = new ArrayList<>();
        map = new GameBoard(12,30,'.');
    }
    public Loadable createLoadable(String typeName) throws GameFileException {
        switch (typeName){
            case "Skeleton":
                return new Skeleton();
            case "Rat":
                return new Rat();
            case "Item":
                return new Item();
            case "Tome":
                return new Tome();
            default:
                throw new GameFileException("Unkown type: "+typeName);
        }
    }
    public void load(Scanner input) throws GameFileException{
        map.clear();
        loadableList.clear();
        int numLines = input.nextInt();
        input.nextLine();
        for(int i = 0; i < numLines; i++) {
            String typeName = input.next();
            Loadable m = createLoadable(typeName);
            m.load(input);
            loadableList.add(m);

            if (m instanceof Drawable){
                ((Drawable) m).draw(map);
            }
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("MAP:\n");
        sb.append(map.getBoardString()).append("\n");
        sb.append("CREATURES:\n");
        for (Loadable m : loadableList) {
        if(m instanceof Creature) {
            sb.append("* ").append(m).append("\n");
            }
        }
        sb.append("INVENTORY:\n");
        for (Loadable m : loadableList) {
            if(m instanceof Item) {
                sb.append("* ").append(m).append("\n");
            }
        }
    return sb.toString();
    }
    public void save(String filename) throws GameFileException {
        try (PrintWriter writer = new PrintWriter(filename)){
            writer.print(this.toString());
        }catch (Exception e){
            throw new GameFileException("Failed to save file!", e);
        }
    }
}
