package DotAndBoxesGame.GameLogic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TUI for the Dot and Boxes game.
 */
public class DotAndBoxesTUI {
    private static final int gridSize = 5;
    private static int DIM;

    /**
     * The main method that runs the Dot and Boxes TUI game.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Applied a formula to compute the number of unique edges in a square grid
        int numEdges = (2 * (gridSize + 1) * (gridSize + 1)) - 2 * (gridSize + 1);
        //Row, Columns and Edges
        int[][][] cellsArray = new int[gridSize][gridSize][4];
        Board.setupGrid(cellsArray);

        //Empty array to store edge status (False = not filled, True = filled)
        boolean[] edgesArray = new boolean[numEdges];
        //Setting them all to False as the new game begins
        Arrays.fill(edgesArray, Boolean.FALSE);


        Scanner reader = new Scanner(System.in);
        System.out.println("Enter player 1 name: ");
        String player1Name = reader.nextLine();
        System.out.println("Enter player 2 name: ");
        String player2Name = reader.nextLine();
        System.out.println("What dimensions for the board? ");
        DIM = reader.nextInt();
        DotAndBoxesGame game = new DotAndBoxesGame(player1Name, player2Name);

        while (true) {
            System.out.println(game.getTurn() + "'s turn: New move: ");
            System.out.println("Enter move index number (0 to 59): ");
            int moveIdx = reader.nextInt();
            if (moveIdx > 59 || moveIdx < 0) {
                System.out.println("Wrong move index, please enter a valid move: ");
                continue;
            }

            int result = game.makeMove(player1Name, player2Name, moveIdx, cellsArray, edgesArray);
            if (result == 2) {
                System.out.println("Game over");
                reader.close();
                //break to exit the while loop
                break;
            }
        }
    }

    public int getDIM(){
        return DIM;
    }
}
