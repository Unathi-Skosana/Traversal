import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class middleware {    

    public static char readKeys() {
        char pressedKey;

        while(true) {     
            if(StdDraw.hasNextKeyTyped()) {
                pressedKey = StdDraw.nextKeyTyped();
                return pressedKey;
            }
        }
    }

    public static void parseArgs(String inputfile) throws FileNotFoundException { // move to main client Traversal.java
    
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
              String symbol   = currentLine.substring(j,j + 1);
              Position p      = new Position(i, j);
              gamePiece piece = new gamePiece(symbol, p);
              traversalBoard.add_gamePiece(piece);
          }
      }
    }

    public static void writeToFile() {
    
      /* Fill code here */
    
    } 

    public static void sound() {
    
      /* Fill code here */ 

    }

}

