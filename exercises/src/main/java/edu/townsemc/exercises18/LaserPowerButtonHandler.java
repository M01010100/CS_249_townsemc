package edu.townsemc.exercises18;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

public class LaserPowerButtonHandler implements EventHandler<ActionEvent> {
    private LaserFX boss;
    public LaserPowerButtonHandler(LaserFX boss){
        this.boss = boss;
    }

    public void handle(ActionEvent e){
        if(e.getSource() instanceof Button b){
            String text = b.getText();
            int score = Integer.parseInt(text);
            int oldscore = boss.getLaserPower();
            score += oldscore;
            boss.setLaserPower(score);
            System.out.println("New laser power: "+ boss.getLaserPower());
        }
    }
}
