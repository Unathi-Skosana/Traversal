import java.util.ArrayList;

public class gameBoard {

    private final int boardWidth;
    private final int boardHeight;
    public gamePiece player;
    private ArrayList<gamePiece> gamePieces;

    public gameBoard(int boardWidth, int boardHeight) {
        
        this.boardHeight = boardHeight;
        this.boardWidth  = boardWidth;
        gamePieces = new ArrayList<gamePiece>();
    }

    public int getBoardHeight() {
      return boardHeight;
    }

    public int getBoardWidth() {
      return boardWidth;
    }

    public void add_gamePiece(gamePiece piece) {

      if (piece.getSymbol() == 's') { player = piece; }
        else { gamePieces.add(piece); }
    }

    public void move(char KeyPressed) {
        switch(KeyPressed) {
          case 'a':
            if (!(player.getPosition().getX() == 0)) {
                loadEventsFromHorMove();
                player.getPosition().decrementX();
            }
            break;
          case 'd':
            if (!(player.getPosition().getX() == boardWidth - 1)) {
                loadEventsFromHorMove();
                player.getPosition().incrementX();
            }
            break;
          case 'w':
            loadEventsFromVertMove();
            if (player.getPosition().getY() == boardHeight - 1) { player.getPosition().setY(0); }
            else                                                { player.getPosition().incrementY(); }
            break;
          case 's':
            loadEventsFromVertMove();
            if (player.getPosition().getY() == 0) { player.getPosition().setY(boardHeight - 1); }
            else                                  { player.getPosition().decrementY(); }
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
                if(piece.getPosition().getX() == 0) { piece.getPosition().setX(boardWidth - 1); }
                else                                { piece.getPosition().decrementX();         }
                  break;
                case 'r':
                if(piece.getPosition().getX() == boardWidth - 1) { piece.getPosition().setX(0);      }
                else                                             { piece.getPosition().incrementX(); }
                  break;
                case 'd':
                 if(piece.getPosition().getY() == 0) { piece.getPosition().setY(boardHeight - 1); }
                 else                                { piece.getPosition().decrementY();          }
                  break;
                case 'u':
                if(piece.getPosition().getY() == boardHeight - 1) { piece.getPosition().setY(0);      }
                else                                              { piece.getPosition().incrementY(); }
                  break;
                default:
                  break;
             }
        }
    }

    private void VertMovers() {
       for (gamePiece piece: this.gamePieces) {
           switch(piece.getSymbol()) {
                case 'L':
                if(piece.getPosition().getX() == 0) { piece.getPosition().setX(boardWidth - 1); }
                else                                { piece.getPosition().decrementX();         }
                  break;
                case 'R':
                if(piece.getPosition().getX() == boardWidth - 1) { piece.getPosition().setX(0);      }
                else                                             { piece.getPosition().incrementX(); }
                  break;
                case 'D':
                 if(piece.getPosition().getY() == 0) { piece.getPosition().setY(boardHeight - 1); }
                 else                                { piece.getPosition().decrementY();          }
                  break;
                case 'U':
                if(piece.getPosition().getY() == boardHeight - 1) { piece.getPosition().setY(0);      }
                else                                              { piece.getPosition().incrementY(); }
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
            else if (piece.getSymbol() == 'H') {    
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
                break;
        }
    }

    public void drawBoard() { 
        StdDraw.clear();
      for (gamePiece piece : this.gamePieces) {
          char symbol = piece.getSymbol();
          Position p = piece.getPosition();
          draw_gamePiece(p, symbol);
          
      }
      draw_gamePiece(player.getPosition(), 's'); //  Overlaying the player piece over every icon.
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
        } else if(possibleKey.getSymbol() == 'k') {
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
        if (currentPiece == null)                                                    { return false; }      
        else if (currentPiece.getSymbol() == 'D' || currentPiece.getSymbol() == 'd') { return true;  }
        else if (currentPiece.getSymbol() == 'U' || currentPiece.getSymbol() == 'u') { return true;  }
        else if (currentPiece.getSymbol() == 'L' || currentPiece.getSymbol() == 'l') { return true;  }
        else if (currentPiece.getSymbol() == 'R' || currentPiece.getSymbol() == 'r') { return true;  }
        else if (currentPiece.getSymbol() == 'P' || currentPiece.getSymbol() == 'x') { return true;  }
        else if (currentPiece.getSymbol() == 'H' || currentPiece.getSymbol() == 'V') { return true;  }
        else                                                                         { return false; }

    }

    public ArrayList<gamePiece> getGamePiecesList() {
        return gamePieces;
    }
    public boolean hasPlayerWon() {
      
      gamePiece possibleTarget = gamePieceAt(player.getPosition());

      if (possibleTarget == null) { return false; }
      else { return possibleTarget.getSymbol() == 't'; }
    
    }

}
