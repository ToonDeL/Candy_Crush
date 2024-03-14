package be.kuleuven.candycrush2;
import be.kuleuven.candycrush.CheckNeighboursInGrid;
import javafx.scene.control.Button;

import java.util.List;
public class GameModel {



    private List<Integer> grid;
    private int width;
    private int height;
    public  Button[][] buttons;
    private String speler;


    private int score;

    public void addScore(int score) {
        this.score += score;
    }
    public void setScore(int score) {
        this.score += score;
    }
    public List<Integer> getGrid() {
        return grid;
    }

    public int getScore() {
        return score;
    }

    public String getSpeler() {
        return speler;
    }

    public GameModel(List<Integer> grid, int width, int height, String speler) {
        this.grid = grid;
        this.width = width;
        this.height = height;
        this.speler = speler;
    }
    public int getWidth() {

        return this.width;
    }
    public int getheight() {

        return this.height;
    }
    public void setIndexGrid(int index, int value) {
        this.grid.set(index,value);
    }
    public int getIndexGrid(int index) {

        return this.grid.get(index);
    }

    // Methode om de buren van een bepaalde index te krijgen
    public Iterable<Integer> getNeighbours(int index) {


        return  CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, index);
    }

}
