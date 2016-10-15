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

      if ((piece.getSymbol()).equals("s")) { player = piece; }
          
          gamePieces.add(piece);
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
          gamepiecesGUI.hor_UpMover(p);
          break;
        case "d":
          gamepiecesGUI.hor_DownMover(p);
          break;
        case "l":
          gamepiecesGUI.hor_LeftMover(p);
          break;
        case "r":
          gamepiecesGUI.hor_RightMover(p);
          break;
        case "U":
          gamepiecesGUI.vert_UpMover(p);
          break;
         case "D":
          gamepiecesGUI.vert_DownMover(p);
          break;
        case "R":
          gamepiecesGUI.vert_RightMover(p);
          break;
        case "h":
          gamepiecesGUI.open_HorSwitch(p);
          break;
        case "H":
          gamepiecesGUI.closed_HorSwitch(p);
          break;
        case "v":
          gamepiecesGUI.open_VertSwitch(p);
          break;
        case "V":
          gamepiecesGUI.closed_VertSwitch(p);
          break;
        case "k":
          gamepiecesGUI.open_Key(p);
          break;
        case "K":
          gamepiecesGUI.closed_Key(p);
          break;
        case "p":
          gamepiecesGUI.closed_Port(p);
          break;
        case "P":
          gamepiecesGUI.open_Port(p);
          break;
        default:
          // throw an error
          break;
      }

    }

    public void drawBoard(ArrayList<gamePiece> board) { // Move to main client Traversal

      // setup board here

      for (gamePiece piece : board) {
          String symbol = piece.getSymbol();
          Position p = piece.getPosition();
          draw_gamePiece(p, symbol);
      }
    }

}
