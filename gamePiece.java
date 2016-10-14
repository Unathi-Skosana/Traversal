public class gamePiece {

    private final String symbol;
    private Position position;

    public gamePiece(String symbol, Position position) {

        this.position = position;
        this.symbol = symbol;
    }

    public String getSymbol() {
    
        return symbol;
    }

    public Position getPosititon() {
    
        return position;
    }

}
