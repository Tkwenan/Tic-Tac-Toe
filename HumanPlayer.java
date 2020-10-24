package Tictactoe;

 
import java.util.*;

/**
 * This class allows the human player to specify a move.
 *
 * @author Tracy Kwena
 * @version 1.0
 */
public class HumanPlayer extends APlayer
{

    /**
     * Constructor for objects of class HumanPlayer
     * @param game the tic-tac-toe game that's being played
     */
    public HumanPlayer(Game game)
    {
        super(game);
        super.symbol = 'X';

    }

    /**
     * Asks the human player to pick a move
     *  Moves are read from the keyboard and are specified by two 
     *  characters rc, where r is a letter representing the row 
     *  and c is a digit representing the column. For instance a1 
     *  means the 1st column of the first row and c2 means the 2nd
     *  column of the 3rd row. If the user specifies: a position 
     *  that is outside the bound of the game board or, a position 
     *  that is already occupied, an appropriate error message is 
     *  shown and the user is asked for another position. 
     *  If the user writes quit (regardless of case), 
     *  the method returns null, signifying that 
     *  the program should terminate.
     *
     * @return    the move that the user chose or null if the user wants to exit
     */
    public Move pickMove( )
    {
        assert !this.game.isGameOver();

        int boardSize = this.game.getBoardSize();
        Move move = new Move(boardSize + 1, boardSize + 1);
        Scanner scanner = new Scanner(System.in);
        String errMsg = null;
        
        do {
            if (errMsg != null) {
                System.out.printf("Invalid move: %s.\n", errMsg);
                errMsg = null;
            }
            
            System.out.print("Enter your move or enter 'quit' to exit): ");
            String usrInp = scanner.next();
            usrInp = usrInp.toUpperCase();
            if (usrInp.equals("QUIT") || usrInp.equals("EXIT")) {
                move = null;
                break;
            }
            
            if (usrInp.length() != 2) {
                errMsg = "please specify two characters, one for the row and another for the column. E.g. a1";
            } else {
                char rowChar = usrInp.charAt(0);
                int row = rowChar - 65;
                char colChar;
                if (row >= 0 && row < boardSize) {
                    colChar = usrInp.charAt(1);
                    int col = Character.digit(colChar, 10) - 1;
                    if (col >= 0 && col < boardSize) {
                        move.row = row;
                        move.col = col;
                          errMsg = "position already taken";
                    } else {
                        errMsg = "invalid column " + colChar + ". Must be between 1 and " + boardSize;
                    }
                } else {
                    colChar = (char)(65 + boardSize - 1);
                    errMsg = "invalid row " + rowChar + ". Must be between A and " + colChar;
                }
            }
        } while(!this.game.isValidMove(move));

        return move;


       
    }
}
