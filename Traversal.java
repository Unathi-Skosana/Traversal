import java.io.FileNotFoundException;

public class Traversal {
  public GameBoard traversalBoard;

  public Traversal(String inputFile) throws FileNotFoundException {
    this.traversalBoard = Middleware.parseArgs(inputFile);     
  }

  public void play() {
    int boardWidth  = traversalBoard.getBoardWidth();
    int boardHeight = traversalBoard.getBoardHeight();
    GamePiecesGUI.initialiseCanvas(boardWidth, boardHeight);

    while (!traversalBoard.isPlayerDead()
        && !traversalBoard.hasPlayerWon()) {
      traversalBoard.move(Middleware.readKeys());
      traversalBoard.drawBoard();
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    Traversal traversal = new Traversal(args[0]);
    traversal.play();
  }

}
