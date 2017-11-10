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
        System.out.print("What size grid do you want to make (r c)? ");
        int numRows = sc.nextInt();
        int numCols = sc.nextInt();
        char[][] grid = new char[numRows][numCols];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                grid[i][j] = '-';
            }
        }
        grid[0][0] = '*';
        return grid;
    }

    //Ask the user for a change in row and column, and adjust the location of * accordingly
    //If an edge is reached, assume it wraps around to the other side
    public static char[][] changeLoc(char[][] grid, Scanner sc){
        System.out.print("How much do you want to move the row and col? ");
        int numRowsToMove = sc.nextInt();
        int numColsToMove = sc.nextInt();
        int[] currLoc = getCurrLoc(grid);
        grid[currLoc[0]][currLoc[1]] = '-';
        int newRow = (currLoc[0] + numRowsToMove) % grid.length;
        int newCol = (currLoc[1] + numColsToMove) % grid[0].length;
        if (newRow < 0)
            newRow = grid.length + newRow;
        if (newCol < 0)
            newCol = grid[0].length + newCol;
        grid[newRow][newCol] = '*';
        return grid;
    }

    public static int[] getCurrLoc(char[][] grid){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '*'){
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    //Displays the array representing the grid with a single space between each column
    public static void displayGrid(char[][] grid){
        for (char[] row : grid){
            for (char curr : row){
                System.out.print(curr);
            }
            System.out.println();
        }
    }
}
