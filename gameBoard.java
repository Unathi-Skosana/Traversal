import java.util.HashMap;

public class gameBoard {

  // Use a HashMap to represent the gameBoard object.

    public final int boardWidth;
    public final int boardHeight;
    public gamePiece player;
    public HashMap<String, gamePiece> gamePieces;

    public gameBoard(int boardWidth, int boardHeight) {
    
        this.boardHeight = boardHeight;
        this.boardWidth  = boardWidth;
    }

    public void add_gamePiece(gamePiece piece) {
        
        // add the game piece to whatever implementation,
        //  you are using to represent gameBoard
    }

    public void draw_gamePiece(String symbol) { // Move to the GUI object that represents the gameBoard object.
    
      // draw gamePiece by using the graphics library.
     
    }





}
