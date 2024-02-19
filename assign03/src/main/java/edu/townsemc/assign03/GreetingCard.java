package edu.townsemc.assign03;

public class GreetingCard {
    private char boundaryChar;
    private String[] lines;
    public GreetingCard(String [] lines, char boundaryChar){
        setLines(lines);
        setBoundaryChar(boundaryChar);
    }
    public char getBoundaryChar(){
     return boundaryChar;
    }
    public String getLines(){
        StringBuilder gtLines = new StringBuilder();
        for(String line : lines){
            gtLines.append(line).append("\n");
        }
        return gtLines.toString();
    }
    public void setBoundaryChar(char boundaryChar){
        this.boundaryChar=boundaryChar;
    }
    public void setLines(String[] lines){
        this.lines = new String[lines.length];
        for(int i = 0; i < lines.length; i++){
            this.lines[i]=lines[i];
        }
    }
    public String generateBoundaryLine(){
        StringBuilder Boundary = new StringBuilder();
        for(int i = 0; i < 50; i++){
            Boundary.append(boundaryChar);
        }
        Boundary.append("\n");
        return Boundary.toString();
    }
    public String generateCenteredLine(String text){
        if(!text.isEmpty()){
            text = " " + text + " ";
        }
        int totalPadding = 50 - text.length();
        int halfPadding = totalPadding /2;
        int secondPadding = totalPadding - halfPadding;
        StringBuilder Centered = new StringBuilder();
        for(int i=0;i<halfPadding;i++){
            Centered.append(boundaryChar);
        }
        Centered.append(text);
        for(int i=0;i<secondPadding;i++){
            Centered.append(boundaryChar);
        }
        Centered.append("\n");
        return Centered.toString();
    }
    //StringBuilder sb = new StringBuilder();
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int remainingLines = 5;
        int currentLine = 0;
        int cnt = 0;
        while(currentLine < lines.length) {
            sb.append(generateBoundaryLine()).append(generateBoundaryLine());
            for (int i = 0; i < 5 && currentLine < lines.length; i++) {
                sb.append(generateCenteredLine(lines[currentLine++]));
            }
            for (int i = 0; i < remainingLines - lines.length; i++) {
                sb.append(generateBoundaryLine());
            }
            sb.append(generateBoundaryLine()).append(generateBoundaryLine());
            //break;
            cnt++;
        }
        //sb.append("\n");
        return sb.toString();
    }
}