import java.io.FileNotFoundException;

public class Traversal {

    public static gameBoard traversalBoard;

    public static void constructBoard(String inputfile) throws FileNotFoundException {
        gameBoard traversalBoard = middleware.parseArgs(inputfile);  
    }

    public static void play() {

        while (!traversalBoard.isPlayerDead() && !traversalBoard.hasPlayerWon()) {
           traversalBoard.move(middleware.readKeys());
           traversalBoard.drawBoard();
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
    
       Traversal.constructBoard(args[0]);
       Traversal.play();
    }

}
