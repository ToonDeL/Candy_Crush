module be.kuleuven.candycrush2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires be.kuleuven.Crush.checkNeighbour;

    opens be.kuleuven.candycrush2 to javafx.fxml;
    exports be.kuleuven.candycrush2;
}