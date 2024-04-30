package edu.townsemc.assign06;

import java.util.Scanner;

public class Tome extends Item{
    private String skill = "";
    public Tome(){
        this.skill = "";
    }
    public Tome(String ID, int Value, String skill){
        super(ID, Value);
        this.skill = skill;
    }
    public String getSkill(){
        return skill;
    }
    public void setSkill(String skill){
        this.skill = skill;
    }
    public void read(){
        System.out.println("Skill " + skill + " increased!");
    }
    public String toString(){
        return super.toString() + ", enhances " + skill;
    }
    public void load(Scanner input) throws GameFileException{
        try{
            super.load(input);
            skill = input.next();
        } catch (Exception e){
            super.setID("");
            super.setValue(0);
            skill = "";
            throw new GameFileException("Error loading Tome", e);
        }
    }
}

