import java.util.Scanner;

public class GridMove {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        char[][] grid = createGrid(sc);

        boolean cont = true;

        while (cont){
            grid = changeLoc(grid, sc);
            displayGrid(grid);
        }
    }

    //Create and return an int[][] of user specified size
    //With all "Empty" spaces initialized to - and the top left space initialized to *
    public static char[][] createGrid(Scanner sc){
        return null;
    }

    //Ask the user for a change in row and column, and adjust the location of * accordingly
    //If an edge is reached, assume it wraps around to the other side
    public static char[][] changeLoc(char[][] grid, Scanner sc){
        return null;
    }

    //Displays the array representing the grid with a single space between each column
    public static void displayGrid(char[][] grid){

    }
}
