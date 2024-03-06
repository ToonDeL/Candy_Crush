package be.kuleuven.candycrush2;

import be.kuleuven.candycrush.CheckNeighboursInGrid;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        List<Integer> grid = List.of(
                0, 0, 1, 0,
                1, 1, 0, 2,
                2, 0, 1, 3,
                0, 1, 1, 1
        );

        int width = 4;
        int height = 4;
        int indexToCheck = 5;
        launch();
        Iterable<Integer> sameNeighbours = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);
        System.out.println("Indices van buren met dezelfde waarde: ");
        sameNeighbours.forEach(System.out::println);


    }
}