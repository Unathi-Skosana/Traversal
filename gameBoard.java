import java.util.ArrayList;

public class gameBoard {

  // Use a HashMap to represent the gameBoard object.

    public final int boardWidth;
    public final int boardHeight;
    public gamePiece player;
    public ArrayList<gamePiece> gamePieces = new ArrayList<gamePiece>();

    public gameBoard(int boardWidth, int boardHeight) {
        
        this.boardHeight = boardHeight;
        this.boardWidth  = boardWidth;
    }

    public void add_gamePiece(gamePiece piece) {
        
        gamePieces.add(piece);
        
        // add the game piece to whatever implementation,
        //  you are using to represent gameBoard
    }


    public void draw_gamePiece(Position p, String symbol) { // Move to the GUI object that represents the gameBoard object.

      switch(symbol) {
        case "s":
          gamepiecesGUI.player(p);
          break;
        case "t":
          gamepiecesGUI.target(p);
          break;
        case "x":
          gamepiecesGUI.wall(p);
          break;
        case "u":
          gamepiecesGUI.hormov(p);
          break;
        case "d":
          gamepiecesGUI.hormov(p);
          break;
        case "l":
          gamepiecesGUI.hormovp(p);
          break;
        case "r":
          gamepiecesGUI.hormov(p);
          break;
        case "U":
          gamepiecesGUI.hormov(p);
          break;
         case "D":
          gamepiecesGUI.hormov(p);
          break;
        case "R":
          gamepiecesGUI.hormov(p);
          break;
        case "h":
          gamepiecesGUI.hormov(p);
          break;
        case "H":
          gamepiecesGUI.hormov(p);
          break;
        case "v":
          gamepiecesGUI.hormov(p);
          break;
        case "V":
          gamepiecesGUI.hormov(p);
          break;
        case "k":
          gamepiecesGUI.key(p);
          break;
        case "p":
          gamepiecesGUI.closed_port(p);
          break;
        case "P":
          gamepiecesGUI.open_port(p);
          break;
        default:
          // throw an error
          break;
      }

      // draw gamePiece by using the graphics library.
      
    }

    public void drawBoard(ArrayList<gamePiece> board) {

      // setup board here

      for (gamePiece piece : board) {
          String symbol = piece.getSymbol();
          Position p = piece.getPosition();
          draw_gamePiece(p, symbol);
      }
    
    }

}
