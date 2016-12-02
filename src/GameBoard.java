/**
  * The GameBoard class represents the abstraction of the
  * traversal board, it includes most of the functionality of
  * the entire game such as moving the player piece around, and
  * loading the correspinding events.
  */

import java.lang.RuntimeException;
import java.util.ArrayList;

public class GameBoard {
    private final int boardWidth;
    private final int boardHeight;
    private ArrayList<GamePiece> gamePieces; /* List of game pieces on this board */
    private GamePiece player; /* player piece is native to the board */
    private GamePiece target; /* as well as the target piece */

    /**
      * Constructor, initialises gamePieces.
      * @param boardWidth - width of GameBoard
      * @param boardHeight - height of Gameboard
      */

    public GameBoard(int boardWidth, int boardHeight) {
        this.boardHeight = boardHeight;
        this.boardWidth  = boardWidth;
        gamePieces = new ArrayList<GamePiece>();
    }

    /**
      * self-explanatory getter methods
      * return dimensions of the board.
      */

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    /**
      * adds game pieces to an ArrayList,
      * only if they are not player piece or
      * target piece.
      * @param piece - GamePiece instance to added to the board
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

    /**
      * reads key from the user and
      * moves player game piece and loads
      * corresponding events.
      * @param keyPressed - key pressed by user.
      */

    public void move(char keyPressed) {
        switch (keyPressed) {
            case 'h': /*Keystroke for right movement */
                if (!(player.getPosition().getX() == 0)) {
                    player.getPosition().decrementX();
                    loadEventsFromHorMove();
                } else {
                    EventSounds.wallSound();
                }
                break;

            case 'l': /* Keystroke for left movement */
                if (!(player.getPosition().getX() == boardWidth - 1)) {
                    player.getPosition().incrementX();
                    loadEventsFromHorMove();
                } else {
                    EventSounds.wallSound();
                }
                break;

            case 'k': /* Keystroke for upward movement */
                if (player.getPosition().getY() == boardHeight - 1) {
                    player.getPosition().setY(0);           /* Wrap around edge */
                } else {
                    player.getPosition().incrementY();
                }
                loadEventsFromVertMove();
                break;

            case 'j': /* Keystroke for downward movement */
                if (player.getPosition().getY() == 0) {
                    player.getPosition().setY(boardHeight - 1); /* Wrap around edge.*/
                } else {
                    player.getPosition().decrementY();
                }
                loadEventsFromVertMove();
                break;

            default:
                break;
        }
    }

    /**
      * loads events that should occur following
      * movement of the player in the horizontal
      * plane.
      */

    private void loadEventsFromHorMove() {
        togglePorts();
        horizontalMovers();
        toggleHorizontalSwitches();
        EventSounds.moveSound();
    }

    /**
      * loads events that should occur following
      * movement of the player piece in the vertical
      * plane.
      */

    private void loadEventsFromVertMove() {
        togglePorts();
        verticalMovers();
        toggleVerticalSwitches();
        EventSounds.moveSound();
    }

    /**
      * moves every horizontal mover on the this
      * board in it's direction motion whenever
      * a keystroke for movemement in the horizontal
      * plane is pressed, movers wrap around every
      * edge on the board.
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

    /**
      * Counterpart of the above method follows the same procedure, but
      * for vertical movers.
      */

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

    /**
      * Toggles switches between on state and
      * off state whenever there is movement
      * in the horizontal plane.
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

    /**
      * Toggles switches between on state and
      * off state whenever there is movement
      * in the vertical plane.
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

    /**
      * Draws game pieces using the GamePiecesGui class.
      * @param point - where to draw the pieces on the StdDraw canvas.
      * @param symbol - symbol of the game piece to be drawn.
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

    /**
      * Draws graphical representation
      * of the GameBoard instance.
      */

    public void drawBoard() {
        StdDraw.clear();
        GamePiecesGui.drawBorder(boardWidth, boardHeight);
        for (GamePiece piece : this.gamePieces) {
            char symbol = piece.getSymbol();
            Position point = piece.getPosition();
            drawGamePiece(point, symbol);
        }
        drawGamePiece(target.getPosition(), 't'); /* target and the player are native to class */
        drawGamePiece(player.getPosition(), 's'); /* overlays the player over every other game piece */
        StdDraw.show(30); /* Animation speed of 30 microseconds. */
    }

    /**
      * Toggles ports between open and closed state
      * whenever the player piece eats a unsed key.
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
            EventSounds.collectKeySound();
        }
    }

    /**
      * checks if the player piece is has eaten a
      * key game piece, by testing the if the player's
      * current position is the same as the position
      * of a key game piece.
      * @return boolean value - returns true if player is on key,
      *     otherwise it returns false.
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

    /**
      * fetchs game piece at the position specified as
      * it's argument by iterating the ArrayList and
      * returning as soon as the piece is found.
      * @param  point - Position to fetch the piece from
      * @return piece - piece at point if found, otherwise it
      *     returns a null value
      */

    private GamePiece gamePieceAt(Position point) {
        for (GamePiece piece : this.gamePieces) {
            if (piece.getPosition().isEqualTo(point)) {
                return piece;
            }
        }
        return null;
    }

    /**
      * checks if player is dead.
      * @return boolean value - returns true
      *     if the player's position corresponds
      *     to that  of a game piece that would
      *     cause its death, otherwise
      *     it returns false.
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

    /**
      * checks if the player has won,
      * returns true if player is on target game
      * piece, returns false otherwise.
      */

    public boolean hasPlayerWon() {
        return target.getPosition().isEqualTo(player.getPosition());
    }

    /**
      * Prints the symbols of the game pieces of this board
      * on the console.
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
                if (target.getPosition().isEqualTo(new Position(col, boardHeight - row - 1))) {
                    board[col][boardHeight - row - 1] = 't';
                }
                if (player.getPosition().isEqualTo(new Position(col, boardHeight - row - 1))) {
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

    /**
      * self-explanatory getter methods.
      */

    public GamePiece getPlayer() {
        return player;
    }

    public GamePiece getTarget() {
        return target;
    }
}
