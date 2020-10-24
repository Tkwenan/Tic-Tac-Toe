package Tictactoe;


/**
 * A computer-controlled Tic-tac-toe player that implements a random playing strategy
 *
 * @author Tracy Kwena
 * @version 1.0
 */
public class CPUPlayer extends APlayer
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class CPUPlayer
     * @param  game
     */
    public CPUPlayer(Game game)
    {
        super (game);
        super.symbol= 'O';
       
    }

    /**
     * Picks a move uniformly at random by generating random moves within the game board 
     * boundaries until it finds an unoccupied position
     *
     * @return  the chosen move
     */
    public Move pickMove()
    {
        assert !this.game.isGameOver();
        
        int boardSize = this.game.getBoardSize();
        Move move = new Move (0,0);
        
        do {
            move.row = (int)(Math.random() * (double)boardSize);
            move.col = (int)(Math.random() * (double)boardSize);
        } while(!this.game.isValidMove(move));

        char rowChar = (char)(65 + move.row);
        int col = move.col + 1;
        System.out.printf("CPU's move: %c%d\n", rowChar, col);
        return move;
        
    }
}
