module be.kuleuven.candycrushReal {
    requires javafx.controls;
    requires javafx.fxml;

    requires be.kuleuven.Crush.checkNeighbour;
    requires com.google.gson;

    opens be.kuleuven.candycrush2 to javafx.fxml;
    exports be.kuleuven.candycrush2;
}