package DotAndBoxesGame.GameLogic;

import java.util.Objects;

/**
 * Represents a Dot and Boxes game.
 */
public class DotAndBoxesGame {
    private static String name1;
    private static String name2;
    private static String currentPlayer;

    /**
     * Initializes a new DotAndBoxesGame with two player names.
     *
     * @param name1 The name of the first player.
     * @param name2 The name of the second player.
     */
    public DotAndBoxesGame(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
        currentPlayer = name1;
    }

    /**
     * Makes a move in the game.
     *
     * @param player1Name The name of the first player.
     * @param player2Name The name of the second player.
     * @param moveIdx     The index of the move.
     * @param cellsArray  The array representing the game board.
     * @param edgesArray  The array representing the filled edges.
     * @return 0 if the move is valid, non-box-filling move;
     * 1 if the move filled a box;
     * 2 if the move finished the game (all boxes are filled);
     * 3 if the move is not valid (edge already filled).
     */
    public int makeMove(String player1Name, String player2Name, int moveIdx, int[][][] cellsArray, boolean[] edgesArray) {
        //Check if the edge had already been filled
        if (edgesArray[moveIdx]) {
            System.out.println("Move not registered, this edge has already been filled ");
            return 3;
        }

        int preMoveBoxCount = Board.getNumberFilledBoxes(cellsArray, edgesArray);
        //Else mark the move
        edgesArray[moveIdx] = true;

        //TODO: place code to indicate in GUI the move(with player color)

        int postMoveBoxCount = Board.getNumberFilledBoxes(cellsArray, edgesArray);

        //If the number of boxes has changed since this move then a player filled a box
        if (postMoveBoxCount != preMoveBoxCount) {
            if (Objects.equals(player1Name, currentPlayer)) {
                System.out.println("New box filled in by " + currentPlayer);
                Board.playerOneBoxes++;
                System.out.println(player1Name + " box count: " + Board.playerOneBoxes);
            } else {
                System.out.println("New box filled in by " + currentPlayer);
                Board.playerTwoBoxes++;
                System.out.println(player2Name + " box count: " + Board.playerTwoBoxes);
            }
            System.out.println("Total filled-in box count: " + postMoveBoxCount);

            //Check if the game is over after this move
            if (postMoveBoxCount == Board.totalBoxesNumber) {
                if (Board.playerTwoBoxes > Board.playerOneBoxes) {
                    System.out.println("Game over, " + player2Name + " won!");
                } else {
                    System.out.println("Game over, " + player1Name + " won!");
                }
                return 2;
                //TODO: code to indicate that the game is over and who won
            } else {
                return 1;
                //TODO: code to indicate box is filled
                //Need to find a row index and column index for box
            }
            //Else return 0, to indicate that the move was valid
        } else {
            if (Objects.equals(name1, currentPlayer)) {
                currentPlayer = name2;
            } else {
                currentPlayer = name1;
            }
            return 0;

        }
    }

    /**
     * Gets the current player's turn.
     *
     * @return The name of the current player.
     */
    public String getTurn() {
        return currentPlayer;
    }
}
