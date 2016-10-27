/******************************************************************
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
 ******************************************************************
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Traversal {

  /**
  * Main client
  * takes a maximum of two commandline
  * arguments of filenames, and calls 
  * a game mode as decided by number of
  * commandline arguments. 
  */
  public static void main(String[] args) throws FileNotFoundException, InterruptedException {  
    if (args.length == 1) {
      GameBoard board = Middleware.parseArgs(args[0]);
      Middleware.validateBoard(board);                 
      GraphicsMode.play(board);                         

    } else if (args.length == 2) {
      GameBoard board = Middleware.parseArgs(args[0]);
      Middleware.validateBoard(board);               
      Scanner in = new Scanner(new File(args[1]));    
      String moves = in.nextLine();                     
      TextMode.play(board, moves);                    
    }
    exit();
  }

  /**
   * Sleep for 4 microseconds to allow
   * the final event sound to finish
   * playing and then exits. 
   */

  public static void exit() throws InterruptedException {
    Thread.sleep(4000);
    System.exit(0);
  }
}
