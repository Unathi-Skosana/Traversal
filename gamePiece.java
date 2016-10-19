public class gamePiece {

    private char symbol;
    private Position position;

    public gamePiece(char symbol, Position position) {
        this.position = position;
        this.symbol = symbol;
    }

    public char getSymbol() { return symbol; }

    public Position getPosition() { return position; }

    public void setSymbol(char newSymbol) { this.symbol = newSymbol; }

}
