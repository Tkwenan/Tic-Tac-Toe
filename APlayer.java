package Tictactoe;

/**
 * Represents a generic tic-tac-toe game player
 *
 * @author Tracy Kwena
 * @version 1.0
 */
public abstract class APlayer
{
    protected Game game; //the game the player is playing
    protected char symbol; //character to represent the player's moves on the board

    /**
     * Empty constructor for objects of class APlayer
     */
    protected APlayer()
    {

    }
    
    /**
     * Constructor for objects of class APlayer
     * @param game the tic-tac-toe game that's to be played
     */
    protected APlayer(Game game)
    {
        this.game=game;

    }
    
    /**
     * Returns the symbol that represents this player. 
     *
     * @return symbol
     */
    public char getSymbol()
    {
        return this.symbol;
    }

    /**
     * Makes the player pick their next move
     *
     * @return the move picked by the player
     */
    public abstract Move pickMove();
    
}
