package com.game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    //make window

    public void start(Stage theStage) {
        System.out.println("image = " +
                getClass().getResource("earth.png").toString());
        theStage.setTitle("Timeline Example");

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(512, 512);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();


        Image earth = new Image(getClass().getResource("earth.png").toString(), true);
        Image sun = new Image(getClass().getResource("sun.png").toString(), true);
        Image space = new Image(getClass().getResource("space.png").toString(), true);


        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

                // background image clears canvas
                gc.drawImage(space, 0, 0);
                gc.drawImage(earth, x, y);
                gc.drawImage(sun, 196, 196);
            }
        }.start();

        theStage.show();
    }

    public static void main(String[] args) {
        System.out.println("Starting...");
        launch(new String[0]);
        while(true){
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {

                System.out.println("!");
            }
        }
    }
}