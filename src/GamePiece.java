/**
 * Abstraction of the game pieces for the traversal game,
 * each game piece has an internal property of position and
 * a symbol
 * The methods here are self-explanatory, so again I omit further
 * documentation for this class.
 */

public class GamePiece {
  private char symbol;
  private Position position;

  public GamePiece(char symbol, Position position) {
    this.position = position;
    this.symbol = symbol;
  }

  public char getSymbol() {
    return symbol; 
  }

  public Position getPosition() {
    return position; 
  }

  public void setSymbol(char newSymbol) {
    this.symbol = newSymbol; 
  }
    
}
