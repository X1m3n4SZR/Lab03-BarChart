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

public class HelloApplication extends Application {
    Rectangle bar1, bar2, bar3;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Pane base = new Pane(); //fxmlloader.load();
        Scene scene = new Scene(base, 420, 440);

        bar1 = new Rectangle(20, 350, Color.BLUE);
        base.getChildren().add(bar1);

        bar2 = new Rectangle(20, 350, Color.PURPLE);
        base.getChildren().add(bar2);

        bar3 = new Rectangle(20, 350, Color.HOTPINK);
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
    void onRedraw(){
        bar1.setLayoutX(random.nextDouble()*350);
        bar1.setLayoutY(20);

        bar2.setLayoutX(random.nextDouble()*350);
        bar2.setLayoutY(20);

        bar3.setLayoutX(random.nextDouble()*350);
        bar3.setLayoutY(20);
    }

    public static void main(String[] args) {
        launch();
    }
}