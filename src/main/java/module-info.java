module lab03.barchart {
    requires javafx.controls;
    requires javafx.fxml;


    opens lab03.barchart to javafx.fxml;
    exports lab03.barchart;
}