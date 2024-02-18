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
        StringBuilder sb = new StringBuilder();
        for(String line : lines){
            sb.append(line).append("\n");
        }
        return sb.toString();
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
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 50; i++){
            sb.append(boundaryChar);
        }
        sb.append("\n");
        return sb.toString();
    }
    public String generateCenteredLine(String text){
        if(!text.isEmpty()){
            text = " " + text + " ";
        }
        int totalPadding = 50 -text.length();
        int halfPadding = totalPadding /2;
        int secondPadding = totalPadding - halfPadding;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<halfPadding;i++){
            sb.append(boundaryChar);
        }
        sb.append(text);
        for(int i=0;i<secondPadding;i++){
            sb.append(boundaryChar);
        }
        sb.append("\n");
        return sb.toString();
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int remainingLines = lines.length;
        for(int i = 0; i < lines.length; i +=5){
            if(i < 0){
                sb.append("\n").append(generateBoundaryLine()).append(generateBoundaryLine());
                remainingLines -= 5;
            }
            int lineCnt = Math.min(remainingLines, 5);
            int extraLineCnt = remainingLines < 5 ? 5 - remainingLines : 0;
            for (int j = 0; j < lineCnt; j++){
                sb.append(lines[i+j]).append("\n");
            }
            for (int k =0; k < extraLineCnt; k++){
                sb.append(generateBoundaryLine());
            }
            sb.append(generateBoundaryLine()).append(generateBoundaryLine());
        }
        return sb.toString();
    }
}