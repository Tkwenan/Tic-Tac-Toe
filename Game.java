package Tictactoe;
import java.util.Random;

/**
 * Write a description of class Game here.
 *
 * @author Tracy Kwena
 * @version 1.0
 */
public class Game
{
    protected char [] [] board; //2-D array to represent the board
    protected final int boardSize; //integer that determines the dimensions of the board
    APlayer [] players; //represents the game board as matrix of player symbols (why?)

    final char symbolCPU = 'O'; //character that represents a cpu move on the board
    final char symbolHuman = 'X'; //character that represents a human move on the board
    protected final char blank=' '; 
    protected char gameResult;

    /**
     * Constructor for objects of class Game
     * @param boardSize
     */
    public Game(int boardSize)
    {
        this.boardSize=boardSize; 
        this.board= new char [boardSize][boardSize]; 
        this.resetGame();

    }

    /**
     * This method returns the game board size
     *
     * @return    boardSize
     */
    public int getBoardSize(){
        return this.boardSize;

    }

    // /**
     // * This method analyzes the board and returns the current game state as 
     // * a character. A game is over if either player has completed a row, column or diagonal.
     // * A game is also over if the board is full, even if no player completed a row, line or
     // * diagonal. This is a tie.
     // * @return  game state as a character: '?' if the game isn't over yet, T if the game is
     // * over and tied, or the symbol of the winning player
     // */    
    // public char getGameStatus(){

        // return ();

    // }

    // /**
     // * This method checks for a winner in the rows
     // *
     // * @returns the winning player's symbol or '?' if no player has won
     // */
    // public char checkRowsForWin (char [] [] board) {
        // //looping through the rows       
        // int j=0;
        // for (int i=0; i<board.length; i++) {
            // while (j< board.length) {
                // if (board [i][j]== board [i][j+1]) { 
                    // j=j+1;
                // }
                // else {
                    // System.out.println ("?");
                // }
            // }
        // }
        // return (System.out.println(board[i][j]));
    // }

    // /**
     // * This method checks for a winner in the columns
     // *
     // * @returns the winning player's symbol or '?' if no player has won
     // */
    // public char checkColsForWin (char [] [] board) {
        // //looping through the columns       
        // int i=0;
        // for (int j=0; j<board.length; j++) {
            // while (i< board.length) {
                // if (board [i][j]== board [i+1][j]) { 
                    // i=i+1;
                // }
                // else {
                    // System.out.println ("?");
                // }
            // }
        // }
        // return (System.out.println(board[i][j]));
    // }

    // /**
     // * This method checks for a winner in the first diagonal
     // *
     // * @returns the winning player's symbol or '?' if no player has won
     // */
    // public char checkDiagonalsForWin (char [] [] board) {
        // //looping through the rows       
        // int j=0;
        // for (int i=0; i<board.length; i++) {
            // while (j< board.length) {
                // if (board [i][j]== board [i][j+1]) { 
                    // j=j+1;
                // }
                // else {
                    // System.out.println ("?");
                // }
            // }
        // }
        // return (System.out.println(board[i][j]));
    // }
    
    // /**
     // * This method checks for a winner in the opposite diagonal
     // *
     // * @returns the winning player's symbol or '?' if no player has won
     // */
    // public char checkOppDiagonalsForWin (char [] [] board) {
        // //looping through the rows       
        // int j=0;
        // for (int i=0; i<board.length; i++) {
            // while (j< board.length) {
                // if (board [i][j]== board [i][j+1]) { 
                    // j=j+1;
                // }
                // else {
                    // System.out.println ("?");
                // }
            // }
        // }
        // return (System.out.println(board[i][j]));
    // }
    
    
    // /**
     // * This method checks if the board is full
     // *
     // * @returns T if the board id full and there's no winner
     // */
    // public char isBoardFull (char [] [] board) {      
        // int j=0;
        // for (int i=0; i<board.length; i++) {
            // while (j< board.length) {
                // if (board [i][j]== board [i][j+1]) { 
                    // j=j+1;
                // }
                // else {
                    // System.out.println ("?");
                // }
            // }
        // }
        // return (System.out.println(board[i][j]));
    // }
    
    


    // /**
     // * Plays a single game by having players pick moves in turn. First player is chosen at 
     // * random
     // *
     // * @return  a character representing the result of the game: 'H' if the human player won,
     // * 'C' if the CPU won, 'T' if it was a tie, 'Q' if the human quit the game
     // */

    // public char playSingleGame(){

    // }

    /**
     * This method resets the game state so that the player can play again
     *
     * 
     */
    protected void resetGame(){

        for (int i=0; i<board.length; i++) {
            for (int j=0; j< board[i].length; j++) {
                board [i][j]= blank;

            } 
        }
        
        this.gameResult= ' ';
    }

    /**
     * This method prints the board at every step of the game
     * @return    a String representing the game board
     */
    public String toString(){
        String s=" ";
        
      for(int col = 0; col < this.boardSize; ++col) {
            s = s + " " + (col + 1);
            if (col < this.boardSize - 1) {
                s = s + "  ";
            }
        }

        s = s + "\n";
        char rowId = 'A';

        for(int row = 0; row < this.boardSize; ++row) {
            s = s + " " + rowId++ + " ";
            int col;
            for(col = 0; col < this.boardSize; ++col) {
                s = s + " " + this.board[row][col];
                if (col < this.boardSize - 1) {
                    s = s + " |";
                }
            }

            s = s + "\n";
            if (row < this.boardSize - 1) {
                s = s + "   ";

                for(col = 0; col < this.boardSize; ++col) {
                    s = s + "---";
                    if (col < this.boardSize - 1) {
                        s = s + "|";
                    }
                }
                s = s + "\n";
            }
        }

        return s;
    }
                        
                

    /**
     * This method runs consecutive games until the user quits. When user quits, the
     * win-loss-tie statistics are printed
     * 
     * @param args- the first argument represents the game board size. If the provided board 
     * size does not comply or no board size is given, a default 3x3 board will be used
     * 
     */

    public static void main (String [] args){
        System.out.println("Tic-tac-toe by Tracy Kwena: ");
        int nGamesPlayed = 0;
        int nGamesWon = 0;
        int boardSize;
     
        if (args.length > 0) {
            try {
                 boardSize = Integer.parseInt(args[0]);
            } catch (NumberFormatException var11) {
                boardSize=3;
                System.out.printf("Invalid board size '%s' (not an integer), using default value of %d instead.\n", args[0], boardSize);
            }

            if (boardSize < 3 || boardSize > 9) {
                System.out.printf("Specified board size %d out of range [1,9], using default value of %d instead.\n", boardSize, 3);
                
                boardSize = 3;
                
            }
        }
        else {
            boardSize=3;
        }
        Game tg = new Game(boardSize);
        APlayer[] players = new APlayer[]{new HumanPlayer(tg), new CPUPlayer(tg)};
        boolean userExit = false;

        int winRatio;
        do {
            winRatio = (int)(Math.random() * 2.0D);
            if (nGamesPlayed > 0) {
                tg.resetGame();
            }

            System.out.println("---------- NEW GAME ----------");
            System.out.println(tg);

            do {
                Move move = players[winRatio].pickMove();
                if (move == null) {
                    userExit = true;
                    break;
                }

                boolean moveExecuted = tg.executeMove(move, players[winRatio].getSymbol());

                assert moveExecuted;

                System.out.println(tg);
                ++winRatio;
                winRatio %= 2;
            } while(!tg.isGameOver());

            ++nGamesPlayed;
            char gameResult = tg.getGameResult();
            if (gameResult == players[0].getSymbol()) {
                ++nGamesWon;
                System.out.println("Congratulations, you won! Play again?");
            } else if (gameResult == players[1].getSymbol()) {
                System.out.println("You lost! Try again?");
            } else if (gameResult == 'T') {
                System.out.println("Oh, a tie! Try again?");
            } else {
                assert userExit;

                --nGamesPlayed;
            }
        } while(!userExit);

        if (nGamesPlayed > 0) {
            winRatio = (int)Math.round((double)nGamesWon / (double)nGamesPlayed * 100.0D);
            System.out.printf("You won %d out of %d games (%d%%). ", nGamesWon, nGamesPlayed, winRatio);
        }

        System.out.println("Goodbye!");
    }
    
        
     /**
     * This method checks if a potential move is valid
     *
     * @param  move the move to be validated
     * @return true if move is valid , false if invalid
     */
    public boolean isValidMove(Move move){
        return move.row>=0 && move.row <this.boardSize && move.col>= 0 && move.col< this.boardSize && this.board[move.row][move.col]== ' '; 

    }
    

     /**
     * Executes the move passed to it
     *
     * @param  the move to be executed, the symbol of the player who is making the move
     * @return  true if the move was successfully executed
     */
    protected boolean executeMove (Move move, char symbol){
        boolean re = false;
        if (this.isValidMove(move)) {
            this.board[move.row][move.col] = symbol;
            re = true;
        }
        return re;
    }
    /**
     * Returns true if the game is over. That is if a player 
     * wins,loses, or ties a game.
     * @return A boolean indicating wether the game is over or not
     */
    public boolean isGameOver(){
        boolean isGameOver= false;
        boolean isBoardFull = true;
        char cl;
        boolean isCompCol;
        char cn;
        for(int col=0; col< this.boardSize; col++){
            cl= this.board[col][0];
            if (cl == ' '){
                isBoardFull = false;
            }
            else {
                isCompCol =true;
                
                for (int row =1; row <this.boardSize; row++){
                    cn= this.board[col][row];
                    if (cn!= cl){
                        isCompCol =false;
                    }
                    
                    if (cn == ' '){
                        isBoardFull =false;
                        break;
                    }
                }
                
                if(isCompCol){
                    isGameOver = true;
                    this.gameResult =cl;
                    return true;
                }
            }
        }
        
        for(int row = 0; row <this.boardSize; row++){
            cl = this.board [0][row];
            isCompCol = true;
            if (cl == ' '){
                isCompCol = false;
            }
                
                for(int col=1; col<this.boardSize; col++){
                cn= this.board[col][row];
                if (cn != cl){
                    isCompCol =false;
                    break;
                }
            }
            if(isCompCol){
                isGameOver = true;
                this.gameResult = cl;
                return true;
            }
        
    }
    
    cl = this.board[0][0];
    boolean isCompDiag;
    
    if(!isGameOver&& cl != ' '){
        isCompDiag = true;
        
        
        for(int col =1; col< this.boardSize ; col++){
           if (this.board[col][col] != cl) {
               isCompDiag= false;
               break;
            }
            
            }
        
        if (isCompDiag) {
            isGameOver = true;
            this.gameResult =cl;
            return true;
        }
    }
    
    cl =this.board[0][this.boardSize - 1];
    if (!isGameOver && cl != ' '){
        isCompDiag = true;
        
        
        for (int col=0; col< this.boardSize; col++){
           if (this.board[col][this.boardSize-1-col] !=cl){
               isCompDiag =false;
               break;
            }
            }
        
        if (isCompDiag==true){
            isGameOver =true;
            this.gameResult =cl;
            return true;
        }
    }
    
    if(isBoardFull){
        isGameOver= true;
        this.gameResult = 'T';
        return true;
    }
    return isGameOver;
}

/**
 * Returns the game result as a character.
 * @return a character representing the game's result.
 */
 public char getGameResult() {
        if (this.gameResult != '?') {
            this.isGameOver();
        }

        return this.gameResult;
    }
}        
    


