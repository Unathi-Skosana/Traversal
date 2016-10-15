public class gamePiece {

    private String symbol;
    private Position position;

    public gamePiece(String symbol, Position position) {
        this.position = position;
        this.symbol = symbol;
    }

    public String getSymbol() { return symbol; }

    public Position getPosition() { return position; }

    public void setSymbol(String newSymbol) { this.symbol = newSymbol; }

}
