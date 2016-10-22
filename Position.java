public class Position {
  private int xvalue;
  private int yvalue;

  public Position(int xvalue, int yvalue) {
    this.xvalue = xvalue;
    this.yvalue = yvalue;
  }
    
  public int getX() {
    return xvalue;
  }
 
  public int getY() {
    return yvalue;
  }

  public void setX(int xvalue)  {
    this.xvalue = xvalue;
  }

  public void setY(int yvalue)  {
    this.yvalue = yvalue;
  }

  public void incrementX() {
    xvalue = xvalue + 1;
  }

  public void incrementY() {
    yvalue = yvalue + 1;
  }

  public void decrementX() {
    xvalue = xvalue - 1;
  }

  public void decrementY() {
    yvalue = yvalue - 1;
  }
  
  public boolean isEquals(Position point) {
    return point.getX() == this.xvalue
        && point.getY() == this.yvalue; 
  }

}
