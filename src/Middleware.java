/**
 * Middleware functions class, this class groups together functions
 * that did not fit within the other classes, since this class does
 * not represent any abstraction.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.RuntimeException;
import java.util.ArrayList;
import java.util.Scanner;

public class Middleware {    
  
  /**
   * Listens for the keystroke from the keyboard
   * from the user.
   *
   * @return pressedKey - character pressed.
   */
  
  public static char readKeys() {
    char pressedKey = '0';  // Because I'm bad like that.
    if (StdDraw.hasNextKeyTyped()) {
      pressedKey = StdDraw.nextKeyTyped();
        
    }
    return pressedKey;
  }


  /**
   * processes inputfile containing the board contents and constructs a 
   * GameBoard object from it, throws an FileNotFound Exception if the file
   * is not found.
   * @param inputfile - file name that contains board input.
   * @return traversalBoard - An instance of the GameBoard class.
   */

  public static GameBoard parseArgs(String inputfile) throws FileNotFoundException {
    Scanner in = new Scanner(new File(inputfile));
    int boardHeight  = in.nextInt();
    in.hasNext(" "); 
    int boardWidth   = in.nextInt();
    in.nextLine();
    GameBoard traversalBoard = new GameBoard(boardWidth, boardHeight);

    for (int i = 0; i < boardHeight; i++) {
      String currentLine = in.nextLine();
      for (int j = 0; j < boardWidth; j++) {
        if (!(currentLine.charAt(j) == '.')) { /* '.''s represent empty spaces. */
          char symbol     = currentLine.charAt(j);
          Position point  = new Position(j, boardHeight - i - 1);
          GamePiece piece = new GamePiece(symbol, point);
          traversalBoard.addGamePiece(piece);
        }
      }
    }
    return traversalBoard;
  }

  /**
   * an errorhandler in way, checks if a GameBoard board is valid by
   * checking the following:
   * The boards deminsions are in within the bounds of length 3 and 15
   * If the GameBoard instance has a player game piece
   * If the GameBoard instance has a target game piece
   * if any of these conditions are not met, a Runtime Exception error
   * is thrown to the user.
   * @param board - GameBoard instance to be evaluated.
   */

  public static void validateBoard(GameBoard board) {
    if (board.player == null) {
      throw new RuntimeException("Error: GameBoard must have at most one player game piece");
    } else if (board.target == null) {
      throw new RuntimeException("Error: GameBoard must have at most one target game piece");
    } else if (board.getBoardHeight() > 15 && 3 < board.getBoardHeight()) {
      System.out.println(board.getBoardHeight());
      throw new RuntimeException("Error: GameBoard dimensions out of bounds");
    } else if (board.getBoardWidth() > 15 && 3 < board.getBoardWidth()) { 
      throw new RuntimeException("Error: GameBoard dimensions out of bounds");
    }
  }

}
