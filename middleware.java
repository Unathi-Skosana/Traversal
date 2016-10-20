import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class middleware {    

    public static char readKeys() {
        char pressedKey = '0';

        if(StdDraw.hasNextKeyTyped()) {
                pressedKey = StdDraw.nextKeyTyped();
          
        }

        return pressedKey;
    }

    public static gameBoard parseArgs(String inputfile) throws FileNotFoundException { // move to main client Traversal.java
    
      Scanner in = new Scanner(new File(inputfile));
      
      /* Fill code here */
      
      int boardHeight = in.nextInt();
                        in.hasNext(" "); 
      int boardWidth  = in.nextInt();
                        in.nextLine();

      gameBoard traversalBoard = new gameBoard(boardWidth, boardHeight);

      for (int i = 0; i < boardWidth; i++) {

          String currentLine = in.nextLine();

          for (int j = 0; j < boardHeight; j++) {

              if (!(currentLine.charAt(j) == '.')) {
                 char symbol   = currentLine.charAt(j);
                 Position p      = new Position(j, boardHeight - i - 1);
                 gamePiece piece = new gamePiece(symbol, p);
                 traversalBoard.add_gamePiece(piece);
              }
          }
      }

       return traversalBoard;
    }

    public static void writeToConsole() {
    
      /* Fill code here */
    
    } 

    public static void sound() {
    
      /* Fill code here */ 

    }

}

