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

      if (piece.getSymbol() == 's') { player = piece; }
          
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
        togglePorts();
    }

    private void loadEventsFromVertMove() {
        VertMovers();
        toggleVertSwitches();
        togglePorts();
    }

    private void HorMovers() {        
       for (gamePiece piece: this.gamePieces) {
           switch(piece.getSymbol()) {
                case 'l':
                  piece.getPosition().decrementX();
                  break;
                case 'r':
                  piece.getPosition().incrementX();
                  break;
                case 'd':
                  piece.getPosition().decrementY();
                  break;
                case 'u':
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
                case 'l':
                  piece.getPosition().decrementX();
                  break;
                case 'r':
                  piece.getPosition().incrementX();
                  break;
                case 'd':
                  piece.getPosition().decrementY();
                  break;
                case 'u':
                  piece.getPosition().incrementY();
                  break;
                default:
                  break;          
             }
       }
    }

    private void toggleHorSwitches() {
        for (gamePiece piece: this.gamePieces) {
            if(piece.getSymbol() == 'h') {
                piece.setSymbol('H');
            }  
            else if (piece.getSymbol() == 'h') {    
                piece.setSymbol('h');
            }
        }
    }

    private void toggleVertSwitches() {
        for (gamePiece piece: this.gamePieces) {
            if(piece.getSymbol() == 'v') {
                piece.setSymbol('V');
            }  
            else if (piece.getSymbol() == equals('V')) {    
                piece.setSymbol('v');
            }
        } 
    }

   private void draw_gamePiece(Position p, String symbol) { 
      switch(symbol) {
        case 's':
          gamepiecesGUI.player(p);
          break;
        case 't':
          gamepiecesGUI.target(p);
          break;
        case 'x':
          gamepiecesGUI.wall(p);
          break;
        case 'u':
          gamepiecesGUI.hor_UpMover(p);
          break;
        case 'd':
          gamepiecesGUI.hor_DownMover(p);
          break;
        case 'l':
          gamepiecesGUI.hor_LeftMover(p);
          break;
        case 'r':
          gamepiecesGUI.hor_RightMover(p);
          break;
        case 'U':
          gamepiecesGUI.vert_UpMover(p);
          break;
         case 'D':
          gamepiecesGUI.vert_DownMover(p);
          break;
        case 'R':
          gamepiecesGUI.vert_RightMover(p);
          break;
        case 'h':
          gamepiecesGUI.open_HorSwitch(p);
          break;
        case 'H':
          gamepiecesGUI.closed_HorSwitch(p);
          break;
        case 'v':
          gamepiecesGUI.open_VertSwitch(p);
          break;
        case 'V':
          gamepiecesGUI.closed_VertSwitch(p);
          break;
        case 'k':
          gamepiecesGUI.open_Key(p);
          break;
        case 'K':
          gamepiecesGUI.closed_Key(p);
          break;
        case 'p':
          gamepiecesGUI.closed_Port(p);
          break;
        case 'P':
          gamepiecesGUI.open_Port(p);
          break;
        default:
          // throw an error
          break;
      }

    }

    public void drawBoard() { // Move to main client Traversal

      for (gamePiece piece : this.gamePieces) {
          Char symbol = piece.getSymbol();
          Position p = piece.getPosition();
          draw_gamePiece(p, symbol);
      }
    }

    private void togglePorts() {
    
      if(isPlayerOnKey()) {
          
         for (gamePiece piece : this.gamePieces) {
         
              if (piece.getSymbol() == 'p')      { piece.setSymbol('P'); }  
              
              else if (piece.getSymbol() == equals('P')) { piece.setSymbol('p'); }
         }

      }
    
    }
    
    private boolean isPlayerOnKey() {
        gamePiece possibleKey = gamePieceAt(player.getPosition());

        if(possibleKey.getSymbol() == 'k') {
            possibleKey.setSymbol('K');
            return true;
        } else {
            return false;
        }
    }

    private gamePiece gamePieceAt(Position p) {
          for (gamePiece piece : this.gamePieces) {      
              if(piece.getPosition().isEquals(p) && !piece.getSymbol() == 's') {
                  return piece;
              }
          }
          return null;
    }

    public boolean isPlayerDead() {

        gamePiece currentPiece = gamePieceAt(player.getPosition());

        if (currentPiece.getSymbol().equals("D") || currentPiece.getSymbol().equals("d"))      { return false; }
        else if (currentPiece.getSymbol().equals("U") || currentPiece.getSymbol().equals("u")) { return false; }
        else if (currentPiece.getSymbol().equals("L") || currentPiece.getSymbol().equals("l")) { return false; }
        else if (currentPiece.getSymbol().equals("R") || currentPiece.getSymbol().equals("r")) { return false; }
        else if (currentPiece.getSymbol().equals("P") || currentPiece.getSymbol().equals("x")) { return false; }
        else if (currentPiece.getSymbol().equals("H") || currentPiece.getSymbol().equals("V")) { return false; }
        else                                                                                   { return  true; }

    }

    public boolean hasPlayerWon() {
      
      gamePiece possibleTarget = gamePieceAt(player.getPosition());

      return possibleTarget.getSymbol() == 't';
    
    }

}
