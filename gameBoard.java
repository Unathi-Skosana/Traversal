import java.util.ArrayList;

public class gameBoard {


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

    public void move(char KeyPressed) {
        switch(KeyPressed) {
          case 'a':
            loadEventsFromHorMove();
            player.getPosition().decrementX();
            break;
          case 'd':
            loadEventsFromHorMove();
            player.getPosition().incrementX();
            break;
          case 'w':
            loadEventsFromVertMove();
            player.getPosition().incrementY();
            break;
          case 's':
            loadEventsFromVertMove();
            player.getPosition().decrementY();
            break;
        }
    
    }

    private void loadEventsFromHorMove() {
        HorMovers();
        toggleHorSwitches();
    }

    private void loadEventsFromVertMove() {
        VertMovers();
        toggleVertSwitches();
    }

    private void HorMovers() {        
       for (gamePiece piece: this.gamePieces) {
           switch(piece.getSymbol()) {
                case "l":
                  piece.getPosition().decrementX();
                  break;
                case "r":
                  piece.getPosition().incrementX();
                  break;
                case "d":
                  piece.getPosition().decrementY();
                  break;
                case "u":
                  piece.getPosition().incrementY();
                  break;
                default:
                  break;
             }
        }
    }

    private void VertMovers() {
       for (gamePiece piece: this.gamePieces) {
           switch(piece.getSymbol()) {
                case "l":
                  piece.getPosition().decrementX();
                  break;
                case "r":
                  piece.getPosition().incrementX();
                  break;
                case "d":
                  piece.getPosition().decrementY();
                  break;
                case "u":
                  piece.getPosition().incrementY();
                  break;
                default:
                  break;          
             }
       }
    }

    private void toggleHorSwitches() {
        for (gamePiece piece: this.gamePieces) {
            if(piece.getSymbol().equals("h")) {
                piece.setSymbol("H");
            }  
            else if (piece.getSymbol().equals("H")) {    
                piece.setSymbol("h");
            }
        }
    }

    private void toggleVertSwitches() {
        for (gamePiece piece: this.gamePieces) {
            if(piece.getSymbol().equals("v")) {
                piece.setSymbol("V");
            }  
            else if (piece.getSymbol().equals("V")) {    
                piece.setSymbol("v");
            }
        } 
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

      for (gamePiece piece : board) {
          String symbol = piece.getSymbol();
          Position p = piece.getPosition();
          draw_gamePiece(p, symbol);
      }
    }

    public boolean isPlayerOnKey() {
        
        for (gamePiece piece : this.gamePieces) {
        
            if(piece.getSymbol().equals("k")) {   
                  return (player.getPosition()).isEquals(piece.getPosition());
            }
        }

        return false;
    }

      private gamePiece getPieceByPosition() {

      }
}
