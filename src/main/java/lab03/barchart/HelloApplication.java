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

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Pane base = new Pane(); //fxmlloader.load();
        Scene scene = new Scene(base, 420, 440);

        Rectangle bar = new Rectangle(30, 20, Color.AZURE);
        base.getChildren().add(bar);

        Button redraw = new Button();
        redraw.setText("Redraw");
        redraw.setOnAction(actionEvent -> {
            System.out.println("Redraw Clicked");
        });
        base.getChildren().add(redraw);

        stage.setTitle("Lab03: Bar Graph");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}