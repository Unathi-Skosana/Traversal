/* second mode of the traversal game,
 * in this mode the user interacts with
 * the game by key strokes.
 *
 */

public class GraphicsMode {
  
  /* animates gameplay by listening for
   * for key strokes from the user and
   * animates the board
   *
   * Writes final board to the console.
   *
   * @args GameBoard
   * */
  
  public static void play(GameBoard board) {
    GamePiecesGui.initialiseCanvas(board.getBoardWidth(), board.getBoardHeight());
    while (!board.isPlayerDead()
          && !board.hasPlayerWon()) {   // Read key and animate.
      board.move(Middleware.readKeys());
      board.drawBoard();
    }
    
    if (board.hasPlayerWon()) {
      EventSounds.wonGameSound();
      board.writeToConsole();
      StdOut.println("You won !");

    } else {
      EventSounds.lostGameSound();
      board.writeToConsole();
      StdOut.println("You lost !");
    }
  }
}
