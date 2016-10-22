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
      
      int boardWidth  = in.nextInt();
                        in.hasNext(" "); 
      int boardHeight = in.nextInt();
                        in.nextLine();

      gameBoard traversalBoard = new gameBoard(boardWidth, boardHeight);

      for (int i = 0; i < boardHeight; i++) {

          String currentLine = in.nextLine();

          for (int j = 0; j < boardWidth; j++) {

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

    public static void writeToConsole(ArrayList<gamePiece> gamepieces) {
    
      for (gamePiece : gamepieces) {
           
      }
    
    } 

   
}
