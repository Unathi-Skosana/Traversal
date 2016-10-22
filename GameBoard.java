import java.util.ArrayList;

public class GameBoard {
  private final int boardWidth;
  private final int boardHeight;
  public GamePiece player;
  private ArrayList<GamePiece> gamePieces;

  public GameBoard(int boardWidth, int boardHeight) {
    this.boardHeight = boardHeight;
    this.boardWidth  = boardWidth;
    gamePieces = new ArrayList<GamePiece>();
  }

  public int getBoardHeight() {
    return boardHeight;
  }

  public int getBoardWidth() {
    return boardWidth;
  }

  public void addGamePiece(GamePiece piece) {
    if (piece.getSymbol() == 's') {
      player = piece;
    } else {
      gamePieces.add(piece);
    }
  }

  public void move(char keyPressed) {
    switch (keyPressed) {
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
        if (player.getPosition().getY() == boardHeight - 1) {
          player.getPosition().setY(0);
        } else {
          player.getPosition().incrementY();
        }
        break;
      case 's':
        loadEventsFromVertMove();
        if (player.getPosition().getY() == 0) {
          player.getPosition().setY(boardHeight - 1);
        } else {
          player.getPosition().decrementY();
        }
        break;
      default:
        break;
    }
  }

  private void loadEventsFromHorMove() {
    horizontalMovers();
    toggleHorizontalSwitches();
    togglePorts();
  }

  private void loadEventsFromVertMove() {
    verticalMovers();
    toggleVerticalSwitches();
    togglePorts();
  }

  private void horizontalMovers() {        
    for (GamePiece piece: this.gamePieces) {
      switch (piece.getSymbol()) {
        case 'l':
          if (piece.getPosition().getX() == 1) { 
            piece.getPosition().setX(boardWidth - 1);
          } else {
            piece.getPosition().decrementX();
          }
          break;
        case 'r':
          if (piece.getPosition().getX() == boardWidth - 1)  {
            piece.getPosition().setX(0);
          } else {
            piece.getPosition().incrementX();
          }
          break;
        case 'd':
          if (piece.getPosition().getY() == 0) {
            piece.getPosition().setY(boardHeight - 1);
          } else {
            piece.getPosition().decrementY();
          }
          break;
        case 'u':
          if (piece.getPosition().getY() == boardHeight - 1) {
            piece.getPosition().setY(0);
          } else {
            piece.getPosition().incrementY();
          }
          break;
        default:
          break;
      }
    }
  }

  private void verticalMovers() {
    for (GamePiece piece: this.gamePieces) {
      switch (piece.getSymbol()) {
        case 'L':
          if (piece.getPosition().getX() == 0) {
            piece.getPosition().setX(boardWidth - 1);
          } else {
            piece.getPosition().decrementX();
          }
          break;
        case 'R':
          if (piece.getPosition().getX() == boardWidth - 1) { 
            piece.getPosition().setX(0);
          } else {
            piece.getPosition().incrementX();
          }
          break;
        case 'D':
          if (piece.getPosition().getY() == 0) { 
            piece.getPosition().setY(boardHeight - 1);
          } else {
            piece.getPosition().decrementY();
          }
          break;
        case 'U':
          if (piece.getPosition().getY() == boardHeight - 1) { 
            piece.getPosition().setY(0);
          } else {
            piece.getPosition().incrementY();
          }
          break;
        default:
          break;
      }
    }
  }

  private void toggleHorizontalSwitches() {
    for (GamePiece piece: this.gamePieces) {
      if (piece.getSymbol() == 'h') {
        piece.setSymbol('H');
      } else if (piece.getSymbol() == 'H') { 
        piece.setSymbol('h');
      }
    }
  }

  private void toggleVerticalSwitches() {
    for (GamePiece piece: this.gamePieces) {
      if (piece.getSymbol() == 'v') {
        piece.setSymbol('V');
      } else if (piece.getSymbol() == 'V') {
        piece.setSymbol('v');
      }
    } 
  }

  private void drawGamePiece(Position point, char symbol) { 
    switch (symbol) {
      case 't':
        GamePiecesGUI.target(point);
        break;
      case 'x':
        GamePiecesGUI.wall(point);
        break;
      case 'u':
        GamePiecesGUI.hor_UpMover(point);
        break;
      case 'd':
        GamePiecesGUI.hor_DownMover(point);
        break;
      case 'l':
        GamePiecesGUI.hor_LeftMover(point);
        break;
      case 'r':
        GamePiecesGUI.hor_RightMover(point);
        break;
      case 'U':
        GamePiecesGUI.vert_UpMover(point);
        break;
      case 'D':
        GamePiecesGUI.vert_DownMover(point);
        break;
      case 'R':
        GamePiecesGUI.vert_RightMover(point);
        break;
      case 'h':
        GamePiecesGUI.open_HorSwitch(point);
        break;
      case 'H':
        GamePiecesGUI.closed_HorSwitch(point);
        break;
      case 'v':
        GamePiecesGUI.open_VertSwitch(point);
        break;
      case 'V':
        GamePiecesGUI.closed_VertSwitch(point);
        break;
      case 'k':
        GamePiecesGUI.open_Key(point);
        break;
      case 'K':
        GamePiecesGUI.closed_Key(point);
        break;
      case 'p':
        GamePiecesGUI.closed_Port(point);
        break;
      case 'P':
        GamePiecesGUI.open_Port(point);
        break;
      case 's':
        GamePiecesGUI.player(point);
        break;
      default:
        break;
    }
  }

  public void drawBoard() { 
    StdDraw.clear();
    GamePiecesGUI.drawBorder(boardWidth, boardHeight);
    for (GamePiece piece : this.gamePieces) {
      char symbol = piece.getSymbol();
      Position point = piece.getPosition();
      drawGamePiece(point, symbol);
    }
    drawGamePiece(player.getPosition(), 's');
    StdDraw.show(30);
  }

  private void togglePorts() {
    if (isPlayerOnKey()) {
      for (GamePiece piece : this.gamePieces) {
        if (piece.getSymbol() == 'p') {
          piece.setSymbol('P');
        } else if (piece.getSymbol() == 'P') {
          piece.setSymbol('p');
        }
      }
      drawBoard();
    }
  }
  
  private boolean isPlayerOnKey() {
    GamePiece possibleKey = gamePieceAt(player.getPosition());
    if (possibleKey == null) {
      return false;
    } else if (possibleKey.getSymbol() == 'k') {
      possibleKey.setSymbol('K');
      return true;
    } else {
      return false;
    }
  }

  private GamePiece gamePieceAt(Position point) {
    for (GamePiece piece : this.gamePieces) {      
      if (piece.getPosition().isEquals(point) && !(piece.getSymbol() == 's')) {
        return piece;
      }
    } 
    return null;
  }

  public boolean isPlayerDead() {
    GamePiece currentPiece = gamePieceAt(player.getPosition());
    if (currentPiece == null) {
      return false;
    } else if (currentPiece.getSymbol() == 'D'
          || currentPiece.getSymbol() == 'd') {
      return true;
    } else if (currentPiece.getSymbol() == 'U' 
          || currentPiece.getSymbol() == 'u') {
      return true;
    } else if (currentPiece.getSymbol() == 'L' 
          || currentPiece.getSymbol() == 'l') {
      return true;
    } else if (currentPiece.getSymbol() == 'R' 
          || currentPiece.getSymbol() == 'r') {
      return true;
    } else if (currentPiece.getSymbol() == 'P' 
          || currentPiece.getSymbol() == 'x') {
      return true;
    } else if (currentPiece.getSymbol() == 'H' 
          || currentPiece.getSymbol() == 'V') {
      return true;
    } else {
      return false;
    }
  }

  public ArrayList<GamePiece> getgamePiecesList() {
    return gamePieces;
  }
  
  public boolean hasPlayerWon() {
    GamePiece possibleTarget = gamePieceAt(player.getPosition());
    if (possibleTarget == null) {
      return false;
    } else {
      return possibleTarget.getSymbol() == 't';
    }
  }

}
