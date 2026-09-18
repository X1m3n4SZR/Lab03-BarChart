package lab03.barchart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
//import java.awt.Color;

public class HelloApplication extends Application {
    Rectangle bar1, bar2, bar3;//, top, bottom, sideR, sideL;
    Random rand;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Pane base = new Pane(); //fxmlloader.load();
        Scene scene = new Scene(base, 420, 440);

        rand = new Random();
        /*
        //Idea for random color, but doesn't work because conflicts with other Color import
        double r = rand.nextDouble(256);
        double g = rand.nextDouble(256);
        double b = rand.nextDouble(256);
        Color randColor = new Color(r,g,b);
        */
        /*
        //Attempted to make the outlined grid

        top = new Rectangle(300,1, Color.BLACK);
        base.getChildren().add(top);
        top.setLayoutX(60);
        top.setLayoutY(50);

        bottom = new Rectangle(300,1, Color.BLACK);
        base.getChildren().add(bottom);
        bottom.setLayoutX(60);
        bottom.setLayoutY(350);

        sideR = new Rectangle(1,285);
        base.getChildren().add(sideR);
        sideR.setLayoutX(360);
        sideR.setLayoutY(355);

        sideL = new Rectangle(1,155);
        base.getChildren().add(sideL);
        sideL.setLayoutX(60);
        sideR.setLayoutY(100);
        */
        bar1 = new Rectangle(10, rand.nextInt(350)+1, Color.BLUE);
        base.getChildren().add(bar1);

        bar2 = new Rectangle(10, rand.nextInt(350)+1, Color.PURPLE);
        base.getChildren().add(bar2);

        bar3 = new Rectangle(10, rand.nextInt(350)+1, Color.HOTPINK);
        base.getChildren().add(bar3);

        Button redraw = new Button();
        redraw.setText("Redraw");
        redraw.setOnAction(actionEvent -> {
            onRedraw();
        });
        redraw.setLayoutX(190);
        redraw.setLayoutY(390);
        base.getChildren().add(redraw);

        onRedraw();

        stage.setTitle("Lab03: Bar Chart");
        stage.setScene(scene);
        stage.show();
    }

    Random random = new Random();
    Random randHeight = new Random();
    void onRedraw(){
        //Set them at least 20 spaces from each other - X Values
        //Blue
        bar1.setLayoutX(150);
        bar1.setHeight(randHeight.nextDouble(350)+1);
        //Purple
        bar2.setLayoutX(170);
        bar2.setHeight(randHeight.nextDouble(350)+1);
        //Pink
        bar3.setLayoutX(190);
        bar3.setHeight(randHeight.nextDouble(350)+1);
    }

    public static void main(String[] args) {
        launch();
    }
}