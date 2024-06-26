package edu.realemj.exercises18;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Scene;

public class LaserFX extends Application {
    private int laserPower = 0;

    public int getLaserPower() {
        return laserPower;
    }

    public void setLaserPower(int power) {
        laserPower = power;
    }

    private class InnerLaserPowerButtonHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent e) {
            if(e.getSource() instanceof Button b) {
                String text = b.getText();
                int score = Integer.parseInt(text);
                laserPower += score;
                System.out.println("New laser power: " + laserPower);
            }
        }
    }

    public void start(Stage primaryStage) {
        Button myButton = new Button("FIRE THE LASERS");
        /*
        myButton.setOnAction(new EventHandler<ActionEvent> () {
            public void handle(ActionEvent e) {
                myButton.setText("FIRE THE LASERS");
                laserPower = 0;
            }
        });
        */
        myButton.setOnAction(e -> {
            myButton.setText("FIRE THE LASERS");
            laserPower = 0;
        });

        myButton.setOnMouseEntered(m -> {
           myButton.setText("READY TO FIRE???");
        });

        myButton.setOnMouseExited(m -> {
            myButton.setText("FIRE THE LASERS");
        });

        Button [] gridButtons = new Button[8];
        for(int i = 0; i < gridButtons.length; i++) {
            gridButtons[i] = new Button("" + (i+1));
        }

        //LaserPowerButtonHandler buttonHandler = new LaserPowerButtonHandler(this);
        //InnerLaserPowerButtonHandler buttonHandler = new InnerLaserPowerButtonHandler();
        /*EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (e.getSource() instanceof Button b) {
                    String text = b.getText();
                    int score = Integer.parseInt(text);
                    laserPower += score;
                    System.out.println("New laser power: " + laserPower);
                    myButton.setText("FIRE THE LASERS\n" + "Power: " + laserPower);
                }
            }
        };*/
        EventHandler<ActionEvent> buttonHandler = e -> {
            if (e.getSource() instanceof Button b) {
                String text = b.getText();
                int score = Integer.parseInt(text);
                laserPower += score;
                System.out.println("New laser power: " + laserPower);
                myButton.setText("FIRE THE LASERS\n" + "Power: " + laserPower);
            }
        };

        for(Button b : gridButtons) {
            b.setOnAction(buttonHandler);
        }

        /*
        StackPane pane = new StackPane();
        Pos [] allPos = { Pos.TOP_LEFT, Pos.TOP_RIGHT, Pos.BOTTOM_LEFT,
                            Pos.BOTTOM_RIGHT, Pos.CENTER };
        for(int i = 0; i < gridButtons.length; i++) {
            pane.getChildren().add(gridButtons[i]);
            StackPane.setAlignment(gridButtons[i], allPos[i]);
        }
        */

        /*
        FlowPane pane = new FlowPane();
        for(int i = 0; i < gridButtons.length; i++) {
            pane.getChildren().add(gridButtons[i]);
        }
         */

        /*
        VBox pane = new VBox();
        for(int i = 0; i < gridButtons.length; i++) {
            pane.getChildren().add(gridButtons[i]);
        }
         */

        GridPane pane = new GridPane();
        for(int i = 0; i < gridButtons.length; i++) {
            int x = (2*i)%3;
            int y = (2*i)/3;
            pane.add(gridButtons[i], x, y);
        }

        BorderPane bigPane = new BorderPane();
        bigPane.setCenter(myButton);
        bigPane.setRight(pane);

        Scene scene = new Scene(bigPane, 800, 600);

        scene.setOnKeyPressed(k -> {
            //System.out.println("KEY: " + k.getCode());
            if(k.getCode() == KeyCode.W) {
                laserPower++;
                myButton.setText("FIRE THE LASERS\n" + "Power: " + laserPower);
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("My Glorious Window");
        primaryStage.show();
    }

    public static void main(String [] args) {
        launch(args);
    }
}
