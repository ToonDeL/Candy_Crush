package be.kuleuven.candycrush2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CandycrushModelTests {

    @Test
    public void wanneerNaamIngegevenControleerWerking(){
        int width = 4;
        int height = 4;


        List<Integer> grid = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < width * height; i++) {
            int randomValue = random.nextInt(5) + 1; // Generates a random number between 1 and 5
            grid.add(randomValue);
        }

        GameModel model = new GameModel(grid, width, height, "toon");
        String result = model.getSpeler();
        assert (result.equals("toon")); // een mogelijkheid van assert, ik hou meer van de methode hieronder
    }


    @Test // counts as multiple tests
    public void testGridGetter() {
        List<Integer> grid = Arrays.asList(1, 2, 3, 4);
        int width = 2;
        int height = 2;
        String playerName = "jos";

        GameModel gameModel = new GameModel(grid, width, height, playerName);

        assertEquals(grid, gameModel.getGrid());

    }
    @Test // counts as multiple tests
    public void testWidthgetter() {
        List<Integer> grid = Arrays.asList(1, 2, 3, 4);
        int width = 2;
        int height = 2;
        String playerName = "jos";

        GameModel gameModel = new GameModel(grid, width, height, playerName);


        assertEquals(width, gameModel.getWidth());

    }
    @Test // counts as multiple tests
    public void testHeightGetter() {
        List<Integer> grid = Arrays.asList(1, 2, 3, 4);
        int width = 2;
        int height = 2;
        String playerName = "jos";

        GameModel gameModel = new GameModel(grid, width, height, playerName);



        assertEquals(height, gameModel.getheight());

    }
    @Test // counts as multiple tests
    public void testNameIsJos() {
        List<Integer> grid = Arrays.asList(1, 2, 3, 4);
        int width = 2;
        int height = 2;
        String playerName = "jos";

        GameModel gameModel = new GameModel(grid, width, height, playerName);

        assertEquals(playerName, gameModel.getSpeler());
    }

    @Test
    public void testSetIndexGridAndGetIndexGrid() {
        List<Integer> grid = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int index = 2;
        int value = 99;

        GameModel gameModel = new GameModel(grid, 2, 2, "joset");
        gameModel.setIndexGrid(index, value);

        assertEquals(value, gameModel.getIndexGrid(index));
    }

    @Test
    public void testGetNeighboursAmount() {
        List<Integer> grid = Arrays.asList(2, 2, 2, 4);
        int width = 2;
        int height = 2;
        int index = 0;

        GameModel gameModel = new GameModel(grid, width, height, "joske");
        Iterable<Integer> neighbours = gameModel.getNeighbours(index);

        int count = 0;
        for (Integer neighbour : neighbours) {
            count++;

        }
        assertEquals(2,count); // should get 2 neighbors

    }

    @Test   // werkt de score wel?
    public void testScoreIncrement() {
        // Create a new GameModel instance
        List<Integer> grid = new ArrayList<>();
        int width = 10;
        int height = 10;
        int initialScore =0;
        int scoreToAdd = 50; // test 50 points extra

        GameModel gameModel = new GameModel(grid, width, height, "josemieke");
        initialScore = gameModel.getScore(); // get start score
        gameModel.addScore(scoreToAdd);
        int expectedScore = initialScore + scoreToAdd;
        assertEquals(expectedScore, gameModel.getScore());
    }
    @Test   // werkt de scoreset wel?
    public void testScoreSet() {
        // Create a new GameModel instance
        List<Integer> grid = new ArrayList<>();
        int width = 10;
        int height = 10;

        int scoreToSet = 999; // test 50 points extra

        GameModel gameModel = new GameModel(grid, width, height, "josemieke");

        gameModel.setScore(scoreToSet);

        assertEquals(scoreToSet, gameModel.getScore());
    }
    @Test
    public void testNeighbourIndex() {
        List<Integer> grid = Arrays.asList(2, 2, 0, 4);
        int width = 2;
        int height = 2;
        int index = 0;

        GameModel gameModel = new GameModel(grid, width, height, "joske");
        Iterable<Integer> neighbours = gameModel.getNeighbours(index);
        List<Integer> expected = Arrays.asList(1);

        assertEquals(expected,neighbours); // should get 2 neighbors

    }



}