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
            this.lines[i]=lines[i].trim();
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
        text = text.trim();
        if(!text.isEmpty()){
            text = " " + text + " ";
        }else{
            return generateBoundaryLine();
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
            cnt = 0;
            if(currentLine !=0){
                sb.append("\n");
            }
            sb.append(generateBoundaryLine()).append(generateBoundaryLine());
            cnt+=2;
                for (int i = 0; i < 5 && currentLine < lines.length; i++) {
                    sb.append(generateCenteredLine(lines[currentLine++]));
                    cnt++;
                }
                for (int i = 0; i < remainingLines - lines.length; i++) {
                    sb.append(generateBoundaryLine());
                    cnt++;
                }
            sb.append(generateBoundaryLine()).append(generateBoundaryLine());
            cnt++;cnt++;
            //System.out.println("\t" + cnt + " " + currentLine);
            if(cnt != 9 &&currentLine != 0){
                for(int i = cnt; i < 9; i++) {
                    sb.append(generateBoundaryLine());
                }
            }
        }
        //System.out.println(cnt);
        return sb.toString();
    }
}