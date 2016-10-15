public class Position {
    private int x;
    private int y;

    public Position (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public void incrementX() { x = x + 1; }

    public void incrementY() { y = y + 1; }

    public void decrementX() { x = x - 1; }

    public void decrementY() { y = y - 1; }

    public boolean isEquals(Position p) { return (p.getX() == this.x && p.getY() == this.y); }

}
