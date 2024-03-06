package be.kuleuven.candycrush;
import java.util.ArrayList;
import java.util.List;

public class CheckNeighboursInGrid {

    public static Iterable<Integer> getSameNeighboursIds(Iterable<Integer> grid, int width, int height, int indexToCheck) {
        List<Integer> gridList = new ArrayList<>(); // make list for the grid
        grid.forEach(gridList::add); // add the items

        int valueToCheck = gridList.get(indexToCheck);
        List<Integer> result = new ArrayList<>(); // result array list

        int row = indexToCheck / width; // get the row amount
        int col = indexToCheck % width; // get the col amountt

        // Bepaal de mogelijke richtingen inclusief diagonaal
        int[][] directions = {
                {-1, 0}, // Boven
                {1, 0},  // Onder
                {0, -1}, // Links
                {0, 1},  // Rechts
                {-1, -1},// D-links-boven
                {-1, 1}, // D-rechts-boven
                {1, -1}, // D-links-onder
                {1, 1}   // D-rechts-onder
        };

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < height && newCol >= 0 && newCol < width) {
                int newIndex = newRow * width + newCol;
                if (gridList.get(newIndex) == valueToCheck) {
                    result.add(newIndex);
                }
            }
        }

        return result;
    }
}
