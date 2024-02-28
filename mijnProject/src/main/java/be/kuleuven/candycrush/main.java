package be.kuleuven.candycrush;

import java.util.List;
public class main {


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

        Iterable<Integer> sameNeighbours = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        System.out.println("Indices van buren met dezelfde waarde: ");
        sameNeighbours.forEach(System.out::println);
    }
}
