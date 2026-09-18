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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import java.awt.Color;

public class HelloApplication extends Application {
    static final int NUM_BARS = 12;
    List<Rectangle> bars = new ArrayList<>();
    Pane base;
    Random rand;

    Color[] colors = { Color.BLUE, Color.PURPLE, Color.HOTPINK, Color.GREEN, Color.ORANGE,
            Color.RED, Color.CYAN, Color.GRAY};

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        base = new Pane(); //fxmlloader.load();
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
      base.getChildren().removeAll(bars);
      bars.clear();

      int spacing = 20;
      int barWidth = 10;
      int windowWidth = 420;

      int groupWidth = (NUM_BARS - 1) * spacing + barWidth;

      int startX = (windowWidth - groupWidth) / 2;

    for (int i = 0; i< NUM_BARS; i++) {
        bars.add(createBar(startX + i * spacing));
        }
    base.getChildren().addAll(bars);
    }

    Rectangle createBar(int xPosition) {
        Rectangle bar = new Rectangle(10, randHeight.nextDouble(350)+1);
        bar.setFill(colors[random.nextInt(colors.length)]);
        bar.setLayoutX(xPosition);
                return bar;
    }

    public static void main(String[] args) {

        launch();
    }
}