package edu.townsemc.assign05;

public class Giant {
    private String Name = "";
    public Giant(String Name){
        setName(Name);
    }
    public String getName(){
        return Name;
    }
    public Void setName(String Name){
        this.Name = Name;
        return null;
    }
    public String toString(){
        return getName();
    }
}
