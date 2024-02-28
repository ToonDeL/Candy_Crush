module be.kuleuven.candycrush {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.kuleuven.candycrush to javafx.fxml;
    exports be.kuleuven.candycrush;
}