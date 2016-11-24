/**
  * One of the two modes of the traversal
  * game, in TextMode a board file and
  * moves file is parsed instead of the
  * user interacting with the game with
  * key strokes, the moves can be carried
  * out from the moves file and animated on
  * the canvas character by character.
  */

public class TextMode {

    /**
      * animates the game play by processing
      * the moves specified in moves,a character
      * a time and writes the final state of the
      * board to the console.
      * @param board - An instance of GameBoard object.
      * @param moves - Moves to be carried out on board.
      */

    public static void play(GameBoard board, String moves) {
        GamePiecesGui.initialiseCanvas(board.getBoardWidth(), board.getBoardHeight());
        int stringIndex = 0;
        board.drawBoard();
        StdDraw.show(500); // 500 micro seconds sleep for animation.

        while (!board.isPlayerDead()
                && !board.hasPlayerWon() && stringIndex < moves.length()) {
            board.move(moves.charAt(stringIndex));
            board.drawBoard();
            StdDraw.show(500);
            stringIndex++;
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
