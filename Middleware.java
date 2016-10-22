import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Middleware {    
  public static char readKeys() {
    char pressedKey = '0';
    if (StdDraw.hasNextKeyTyped()) {
      pressedKey = StdDraw.nextKeyTyped();
        
    }
    return pressedKey;
  }

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
        if (!(currentLine.charAt(j) == '.')) {
          char symbol     = currentLine.charAt(j);
          Position point  = new Position(j, boardHeight - i - 1);
          GamePiece piece = new GamePiece(symbol, point);
          traversalBoard.addGamePiece(piece);
        }
      }
    }
    return traversalBoard;
  }

}
