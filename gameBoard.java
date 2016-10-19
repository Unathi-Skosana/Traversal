import java.util.ArrayList;

public class gameBoard {

    public final int boardWidth;
    public final int boardHeight;
    public gamePiece player;
    public ArrayList<gamePiece> gamePieces;

    public gameBoard(int boardWidth, int boardHeight) {
        
        this.boardHeight = boardHeight;
        this.boardWidth  = boardWidth;
        gamePieces = new ArrayList<gamePiece>();
    }

    public void add_gamePiece(gamePiece piece) {

      if (piece.getSymbol() == 's') { player = piece; }
          
          gamePieces.add(piece);
    }

    public void move(char KeyPressed) {
        switch(KeyPressed) {
          case 'a':
            player.getPosition().decrementX();
            loadEventsFromHorMove();
            break;
          case 'd':
            player.getPosition().incrementX();
            loadEventsFromHorMove();
            break;
          case 'w':
            player.getPosition().incrementY();
            loadEventsFromVertMove();
            break;
          case 's':
            player.getPosition().decrementY();
            loadEventsFromVertMove();
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
                case 'R':
                  piece.getPosition().decrementX();
                  break;
                case 'L':
                  piece.getPosition().incrementX();
                  break;
                case 'D':
                  piece.getPosition().decrementY();
                  break;
                case 'U':
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
            else if (piece.getSymbol() == 'V') {    
                piece.setSymbol('v');
            }
        } 
    }

   private void draw_gamePiece(Position p, char symbol) { 
      switch(symbol) {
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
        case 's':
          gamepiecesGUI.player(p);
          break;

        default:
          // throw an error
          break;
      }

    }

    public void drawBoard() { // Move to main client Traversal
        StdDraw.clear();
      for (gamePiece piece : this.gamePieces) {
          char symbol = piece.getSymbol();
          Position p = piece.getPosition();
          draw_gamePiece(p, symbol);
      }
      StdDraw.show(30);
    }

    private void togglePorts() {
    
      if(isPlayerOnKey()) {
          
         for (gamePiece piece : this.gamePieces) {
         
              if (piece.getSymbol() == 'p')      { piece.setSymbol('P'); }  
              
              else if (piece.getSymbol() == 'P') { piece.setSymbol('p'); }
         }

         drawBoard();

      }
    
    }
    
    private boolean isPlayerOnKey() {
        gamePiece possibleKey = gamePieceAt(player.getPosition());

        
        if (possibleKey == null) { 
            return false;
        }
        
        else if(possibleKey.getSymbol() == 'k') {
            possibleKey.setSymbol('K');
            return true;
        } else {
            return false;
        }
    }

    private gamePiece gamePieceAt(Position p) {
          for (gamePiece piece : this.gamePieces) {      
              if(piece.getPosition().isEquals(p) && !(piece.getSymbol() == 's')) {
                  return piece;
              }
          }
          return null;
    }

    public boolean isPlayerDead() {

        gamePiece currentPiece = gamePieceAt(player.getPosition());

        if (currentPiece.getSymbol() == 'D' || currentPiece.getSymbol() == 'd')      { return false; }
        else if (currentPiece.getSymbol() == 'U' || currentPiece.getSymbol() == 'u') { return false; }
        else if (currentPiece.getSymbol() == 'L' || currentPiece.getSymbol() == 'l') { return false; }
        else if (currentPiece.getSymbol() == 'R' || currentPiece.getSymbol() == 'r') { return false; }
        else if (currentPiece.getSymbol() == 'P' || currentPiece.getSymbol() == 'x') { return false; }
        else if (currentPiece.getSymbol() == 'H' || currentPiece.getSymbol() == 'V') { return false; }
        else                                                                         { return  true; }

    }

    public boolean hasPlayerWon() {
      
      gamePiece possibleTarget = gamePieceAt(player.getPosition());

      return possibleTarget.getSymbol() == 't';
    
    }

}
