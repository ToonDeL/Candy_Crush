package be.kuleuven.candycrush2;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class GameController {

    @FXML
    private Label welcomeText;

    @FXML
    private Label ScoreText;

    @FXML
    private TextField usernameField;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button button;

    @FXML
    private Button resetButton;

    public GameModel model;


    @FXML
    public void resetGame(){

        gridPane.getChildren().clear();
        button.setVisible(true);
        usernameField.clear();
        usernameField.setVisible(true);
        resetButton.setVisible(false);
        ScoreText.setVisible(false);
        welcomeText.setVisible(false);






    }
    @FXML
    public void createNewGame(){

        String username = usernameField.getText(); // Get the entered username
        welcomeText.setText("Welcome, " + username + "!");
        ScoreText.setText("Score: 0");
        ScoreText.setVisible(true);
        welcomeText.setVisible(true);
        resetButton.setVisible(true);

        gridPane.getChildren().clear();
        gridPane.setVisible(true);
        button.setVisible(false);
        usernameField.setVisible(false);

        int width = 4;
        int height = 4;


        List<Integer> grid = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < width * height; i++) {
            int randomValue = random.nextInt(5) + 1; // Generates a random number between 1 and 5
            grid.add(randomValue);
        }

        model = new GameModel(grid, width, height, username);

        model.buttons = new Button[height][width];

        int index = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int value = model.getIndexGrid(index++);
                Button button = new Button(Integer.toString(value));
                button.setOnAction(event -> updateButtonValue(button, model));
                gridPane.add(button, j, i);
                model.buttons[i][j]= button;

            }
        }




    }
    private void updateButtonValue(Button button, GameModel model) {

        // index calculations...
        int ClickedRow = GridPane.getRowIndex(button) + 1;
        int ClickedColumn = GridPane.getColumnIndex(button) + 1;
        int ClickedIndex = (((ClickedRow-1)*model.getWidth()) + ClickedColumn)-1;
        int count = 0;
        Iterable<Integer> sameNeighbours = model.getNeighbours(ClickedIndex);
        System.out.println("Indices van buren met dezelfde waarde: ");
        sameNeighbours.forEach(System.out::println);
        // button = model.buttons[0][0]; WERKT met index
        // itereer en loop om de values van de button/grid te veranderen


        for (Integer neighbour : sameNeighbours) {
            count++;

        }
        if (count >= 2) {

            Random random = new Random();
            int newValue = random.nextInt(5) + 1; // Generates a random number between 0 and 5
            button.setText(Integer.toString(newValue));
            model.setIndexGrid(ClickedIndex,newValue);
            model.addScore(count+1);
            ScoreText.setText("Score: " + model.getScore());
            for (int neighbourIndex: sameNeighbours){
                // index calculations other way around
                int row2 = neighbourIndex / model.getWidth();
                int col2 = neighbourIndex % model.getWidth();
                button = model.buttons[row2][col2];
                newValue = random.nextInt(5) + 1; // Generates a random number between 0 and 5
                button.setText(Integer.toString(newValue));
                model.setIndexGrid(neighbourIndex,newValue);




            }
        }
    }
}

