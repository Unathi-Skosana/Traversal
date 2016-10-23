/* The GameBoard class represents the abstraction of the
 * traversal board. It includes most of the functionality of
 * the entire game such as moving the player piece around, and 
 * loading the correspinding events.
 *
 */

import java.lang.RuntimeException;
import java.util.ArrayList;

public class GameBoard {
  private final int boardWidth;
  private final int boardHeight;
  public GamePiece player;
  public GamePiece target;
  private ArrayList<GamePiece> gamePieces;

  /* Constructor, initialises gamePieces.
   *
   * @args int width, height;
   */

  public GameBoard(int boardWidth, int boardHeight) {
    this.boardHeight = boardHeight;
    this.boardWidth  = boardWidth;
    gamePieces = new ArrayList<GamePiece>();
  }

  /* self-explanatory getter
   * methods
   *
   * return dimensions of the board.
   */

  public int getBoardHeight() {
    return boardHeight;
  }

  public int getBoardWidth() {
    return boardWidth;
  }

  /* adds game pieces to an ArrayList, 
   * only if they are not player piece or
   * target piece.
   *
   * @args GamePiece to be added.
   */

  public void addGamePiece(GamePiece piece) {
    if (piece.getSymbol() == 's') {
      this.player = piece;
    } else if (piece.getSymbol() == 't') {
      this.target = piece;
    } else {
      gamePieces.add(piece);
    }
  }

  public void move(char keyPressed) {
    switch (keyPressed) {
      case 'h':                                     // Key stroke for right move
        if (!(player.getPosition().getX() == 0)) {
          loadEventsFromHorMove();
          player.getPosition().decrementX();
        } else {
          EventSounds.wallSound();
        }
        break;

      case 'l':                                    // Key stroke for left move
        if (!(player.getPosition().getX() == boardWidth - 1)) {
          loadEventsFromHorMove();
          player.getPosition().incrementX();
        } else {
          EventSounds.wallSound();
        }
        break;
      
      case 'k':                                   // Key stroke for upward move
        loadEventsFromVertMove();
        if (player.getPosition().getY() == boardHeight - 1) {
          player.getPosition().setY(0);           // Wrap around
        } else {
          player.getPosition().incrementY();
        }
        break;
      
      case 'j':                                  // Key stroke for downward move
        loadEventsFromVertMove();
        if (player.getPosition().getY() == 0) {
          player.getPosition().setY(boardHeight - 1); // Wrap around
        } else {
          player.getPosition().decrementY();
        }
        break;
      
      default:
        break;
    }
  }

  /* loads events that should occur following
   * movement of the player piece in the horizontal
   * plane.
   *
   */

  private void loadEventsFromHorMove() {
    horizontalMovers();
    toggleHorizontalSwitches();
    togglePorts();
    EventSounds.moveSound();
  }

  /* loads events that should occur following
   * movement of the player piece in the vertical
   * plane.
   *
   */

  private void loadEventsFromVertMove() {
    verticalMovers();
    toggleVerticalSwitches();
    togglePorts();
    EventSounds.moveSound();
  }

  /* moves horizontal every mover in it's direction
   * motion for whenever a horizontal keystroke
   * is pressed.
   * 
   * It does so, by iterating over all the game pieces
   * in the ArrayList checking if the current piece has
   * a symbol that represents a horizontal mover.
   *
   */

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

  /* Counterpart of the above method follows the same procedure, but
   * for vertical movers.
   *
   * */

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

  /* Toggles switches from an on state to
   * an off state, by switching it the symbol
   * of the switch game piece whenever there is,
   * horizontal movement.
   *
   * 
   */

  private void toggleHorizontalSwitches() {
    for (GamePiece piece: this.gamePieces) {
      if (piece.getSymbol() == 'h') {
        piece.setSymbol('H');
      } else if (piece.getSymbol() == 'H') { 
        piece.setSymbol('h');
      }
    }
  }

  /* Toggles switches from it's current state
   * to opposite of the current state, by switching it the symbol
   * of the switch game piece whenever there is,
   * vertical movement.
   *
   * 
   */


  private void toggleVerticalSwitches() {
    for (GamePiece piece: this.gamePieces) {
      if (piece.getSymbol() == 'v') {
        piece.setSymbol('V');
      } else if (piece.getSymbol() == 'V') {
        piece.setSymbol('v');
      }
    } 
  }

  /* Draws game pieces using the GamePiecesGui class.
   *
   * @args point - where to draw the pieces on the StdDraw canvas.
   * @args symbol - symbol of the game piece to be drawn.
   */

  private void drawGamePiece(Position point, char symbol) { 
    switch (symbol) {
      case 't':
        GamePiecesGui.target(point);
        break;
      case 'x':
        GamePiecesGui.wall(point);
        break;
      case 'u':
        GamePiecesGui.horizontalUpMover(point);
        break;
      case 'd':
        GamePiecesGui.horizontalDownMover(point);
        break;
      case 'l':
        GamePiecesGui.horizontalLeftMover(point);
        break;
      case 'r':
        GamePiecesGui.horizontalRightMover(point);
        break;
      case 'U':
        GamePiecesGui.verticalUpMover(point);
        break;
      case 'D':
        GamePiecesGui.verticalDownMover(point);
        break;
      case 'R':
        GamePiecesGui.verticalRightMover(point);
        break;
      case 'H':
        GamePiecesGui.openHorizontalSwitch(point);
        break;
      case 'h':
        GamePiecesGui.closedHorizontalSwitch(point);
        break;
      case 'V':
        GamePiecesGui.openVerticalSwitch(point);
        break;
      case 'v':
        GamePiecesGui.closedVerticalSwitch(point);
        break;
      case 'k':
        GamePiecesGui.openKey(point);
        break;
      case 'K':
        GamePiecesGui.closedKey(point);
        break;
      case 'P':
        GamePiecesGui.openPort(point);
        break;
      case 'p':
        GamePiecesGui.closedPort(point);
        break;
      case 's':
        GamePiecesGui.player(point);
        break;
      default:
        break;
    }
  }

  public void drawBoard() { 
    StdDraw.clear();
    GamePiecesGui.drawBorder(boardWidth, boardHeight);
    for (GamePiece piece : this.gamePieces) {
      char symbol = piece.getSymbol();
      Position point = piece.getPosition();
      drawGamePiece(point, symbol);
    }
    drawGamePiece(target.getPosition(), 't'); // target and the player are native to class.
    drawGamePiece(player.getPosition(), 's'); // overlays the player piece over every other piece.
    StdDraw.show(30); // Animation speed 30 microseconds.
  }

  /* Toggles closed ports to open ports and vice versa,
   * whenever the player piece consumes a unsed key and draws the
   * board immediately.
   * 
   */

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

  /* checks if the player piece is has eaten a
   * key game piece. By testing the if the player's
   * current position corresponds to the position of
   * the key game piece.
   *
   * returns boolean value.
   */

  
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

  /* fetchs game piece at the position specified as 
   * it's argument. By iterating the ArrayList and stopping
   * as soon as the piece is found.
   *
   * @args point - Position to fetch the piece from.
   * returns piece at point if found, if not it returns
   * a null value.
   */

  private GamePiece gamePieceAt(Position point) {
    for (GamePiece piece : this.gamePieces) {      
      if (piece.getPosition().isEquals(point) && !(piece.getSymbol() == 's')) {
        return piece;
      }
    } 
    return null;
  }

  /* checks if player is deemed as dead, by checking if it's current
   * position corresponds to the position of another game piece that would
   * cause it's death.
   *
   * returns boolean value.
   */

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
    } else if (currentPiece.getSymbol() == 'p' 
          || currentPiece.getSymbol() == 'x') {
      return true;
    } else if (currentPiece.getSymbol() == 'h' 
          || currentPiece.getSymbol() == 'v') {
      return true;
    } else {
      return false;
    }
  }
  
  /* checks if the player, by checking it's current position
   * corresponds to that of the target game piece.
   *
   * return boolean value.
   */

  public boolean hasPlayerWon() {
    return target.getPosition().isEquals(player.getPosition());
  }

  /*
   * Prints the symbols of the game pieces of this board
   * on the console.
   *
   */

  public void writeToConsole() {
    char[][] board = new char[this.boardWidth][this.boardHeight];
    for (int row = 0; row < boardHeight; row++) {
      for (int col = 0; col < boardWidth; col++) {
        GamePiece piece = gamePieceAt(new Position(col, boardHeight - row - 1));
        if (piece == null) {
          board[col][boardHeight - row - 1] = '.';
        } else if (piece != null) {
          board[col][boardHeight - row - 1] = piece.getSymbol();
        }
        if (target.getPosition().isEquals(new Position(col, boardHeight - row - 1))) {
          board[col][boardHeight - row - 1] = 't';
        }
        if (player.getPosition().isEquals(new Position(col, boardHeight - row - 1))) {
          board[col][boardHeight - row - 1] = 's';
        }
      }
    }
    for (int row = 0; row < boardHeight; row++) {
      for (int col = 0; col < boardWidth; col++) {
        StdOut.print(board[col][boardHeight - row - 1]);
      }
      StdOut.println();
    }
  }
}
