/************************ Main client *****************************
 *                                                                *
 *      Compilation  :javac Traversal.java                        *
 *                                                                *
 *      Execution    : java Traversal args0 -----> GraphicsMode   *
 *                   : java Traversal args0 args1 -----> TextMode *
 *                      args0 - boardfilename.txt                 *
 *                      args1 - movesfilename.txt                 *
 *      Dependancies : StdDraw libraries                          *
 *                                                                *
 *                                                                *
 *      ***************** Controls ******************             *
 *      h - left movement                                         *
 *      l - right movement                                        *
 *      j - down movement                                         *
 *      k - up movement                                           *
 *                                                                *
 *                                                                *
 *                                                                *
 *                                                                *
 *                                                                *
 ******************************************************************
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Traversal {
  public static void main(String[] args) throws FileNotFoundException, InterruptedException {  
    if (args.length == 1) {
      GameBoard board = Middleware.parseArgs(args[0]);  // Construct board
      Middleware.validateBoard(board);                  // Check for bad input.
      GraphicsMode.play(board);                         // Start GraphicsMode.

    } else if (args.length == 2) {
      GameBoard board = Middleware.parseArgs(args[0]); // Construct board.
      Middleware.validateBoard(board);                 // Check for any invalid input in board.
      Scanner in = new Scanner(new File(args[1]));     // parse input within file to a scanner object.
      String moves = in.nextLine();                    // Yank line 
      TextMode.play(board, moves);                     // Start TextMode.
    }
    exit();
  }

  // Exits the game.

  public static void exit() throws InterruptedException {
    Thread.sleep(4000);
    System.exit(0);
  }
}
