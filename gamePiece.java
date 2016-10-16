public class gamePiece {

    private Char symbol;
    private Position position;

    public gamePiece(Char symbol, Position position) {
        this.position = position;
        this.symbol = symbol;
    }

    public String getSymbol() { return symbol; }

    public Position getPosition() { return position; }

    public void setSymbol(Char newSymbol) { this.symbol = newSymbol; }

}
