package edu.realemj.exercises18;

import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.geometry.*;
public class MyJavaFX extends Application {
    public void start(Stage primaryStage) {
        Button myButton = new Button("FIRE THE LASERS");

        Button [] gridButtons = new Button[8];
        for(int i = 0; i < gridButtons.length; i++) {
            gridButtons[i] = new Button("" + (i+1));
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

        primaryStage.setScene(scene);
        primaryStage.setTitle("My Glorious Window");
        primaryStage.show();
    }

    public static void main(String [] args) {
        launch(args);
    }
}
