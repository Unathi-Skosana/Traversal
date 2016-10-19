import java.io.FileNotFoundException;

public class Traversal {

    public gameBoard traversalBoard;

    public Traversal(String inputfile) throws FileNotFoundException {
        this.traversalBoard = middleware.parseArgs(inputfile);     
    }

    public void play() {
    
      gamepiecesGUI.initialiseCanvas(3, 3);

      while (true) {
      
          traversalBoard.move(middleware.readKeys());
          traversalBoard.drawBoard();
      }
    
    }

    public static void main(String[] args) throws FileNotFoundException {
    
       Traversal traversal = new Traversal(args[0]);
       traversal.play();
    }

}
