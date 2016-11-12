/**
 * A static class responsible for drawing the game
 * pieces of the traversal game using the Std* librabies
 * from princeton university java booksite and the java Color class
 * The game pieces were hard coded, so you will encounter
 * alot of ghost values within the methods, which i'm not proud of
 * The methods of this class are self-explanatory, so
 * I omitted further documentation
 */

import java.awt.Color;

public class GamePiecesGui {
  private static final Color green = new Color(0, 117, 5);
  private static final Color orange = new Color(183, 168, 31);
  private static final Color purple = new Color(182, 0, 255);
  private static final Color darkOrange = new Color(219, 146, 0);
  private static final Color blue = new Color(0, 76, 255);
  private static final Color greenK = new Color(24, 219, 190);

  /**
   * Initialises StdDraw canvas and draws
   * board around the canvas.
   */

  public static void initialiseCanvas(int rows, int columns) {
    StdDraw.setCanvasSize(100 * rows,100 * columns);
    StdDraw.setXscale(0, rows);
    StdDraw.setYscale(0, columns);
    drawBorder(rows, columns);
  }
  /**
   * Divides StdDraw canvas into squares,
   * and paints them light gray and draws
   * border around the canvas.
   */

  public static void drawBorder(int rows, int columns) {
    for (double n = .525; n < rows; n++) {
      for (double m = .525; m < columns; m++) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(n, m, .525);
      }
    }
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setPenRadius(.0160);
    StdDraw.line(0,0,0,columns);
    StdDraw.line(0,columns,rows,columns);
    StdDraw.line(rows,columns,rows,0);
    StdDraw.line(rows,0,0,0);
  }

  /**
   * player game piece.
   */

  public static void player(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.40);
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.325);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(point.getX() + .52,point.getY() + .72,point.getX() + .52,point.getY() + .32);
    StdDraw.line(point.getX() + .72,point.getY() + .52,point.getX() + .32,point.getY() + .52);
  }

  /**
   * target game piece.
   */

  public static void target(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(point.getX() + .52, point.getY() + .52, .40);
    StdDraw.setPenColor(greenK);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52, .325);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(point.getX() + .335,point.getY() + .49,point.getX() + .431,point.getY() + .37);
    StdDraw.line(point.getX() + .431,point.getY() + .37,point.getX() + .700,point.getY() + .64);
  }

  /**
   * wall game piece.
   */

  public static void wall(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(.52 + point.getX() ,.52 + point.getY() ,.40);
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.filledCircle(.52 + point.getX() ,.52 + point.getY() ,.325);
  }

  /**
   * horizontal up mover game piece.
   */

  public static void horizontalUpMover(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52, .40);
    StdDraw.setPenColor(blue);
    StdDraw.filledCircle(point.getX() + .52, point.getY() + .52, .325);
    StdDraw.setPenRadius(0.0145);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(point.getX() + .520,point.getY() + .60,point.getX() + .40,point.getY() + .45);
    StdDraw.line(point.getX() + .520,point.getY() + .60,point.getX() + .64,point.getY() + .45);
    StdDraw.line(point.getX() + .845,point.getY() + .52,point.getX() + .75,point.getY() + .52);
    StdDraw.line(point.getX() + .195,point.getY() + .52,point.getX() + .29,point.getY() + .52);
  }

  /**
   * horizontal down mover game piece.
   */

  public static void horizontalDownMover(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52, .40);
    StdDraw.setPenColor(darkOrange);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52, .325);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(point.getX() + .520,point.getY() + .42,point.getX() + .40,point.getY() + .59);
    StdDraw.line(point.getX() + .520,point.getY() + .42,point.getX() + .62,point.getY() + .59);
    StdDraw.line(point.getX() + .845,point.getY() + .52,point.getX() + .75,point.getY() + .52);
    StdDraw.line(point.getX() + .195,point.getY() + .52,point.getX() + .29,point.getY() + .52);
  }

  /**
   * horizontal right mover game piece.
   */

  public static void horizontalRightMover(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52, .40);
    StdDraw.setPenColor(orange);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52, .325);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(point.getX() + .59, point.getY() + .52,point.getX() + .45,point.getY() + .43);
    StdDraw.line(point.getX() + .59, point.getY() + .52,point.getX() + .45,point.getY() + .62);
    StdDraw.line(point.getX() + .845,point.getY() + .52,point.getX() + .75,point.getY() + .52);
    StdDraw.line(point.getX() + .195,point.getY() + .52,point.getX() + .29,point.getY() + .52);
  }

  /**
   * horizontal left mover game piece.
   */

  public static void horizontalLeftMover(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52 ,.40);
    StdDraw.setPenColor(purple);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52, .325);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(point.getX() + .450,point.getY() + .52,point.getX() + .59,point.getY() + .43);
    StdDraw.line(point.getX() + .450,point.getY() + .52,point.getX() + .59,point.getY() + .62);
    StdDraw.line(point.getX() + .845,point.getY() + .52,point.getX() + .75,point.getY() + .52);
    StdDraw.line(point.getX() + .195,point.getY() + .52,point.getX() + .29,point.getY() + .52);
  }

  /**
   * vertical left mover game piece.
   */

  public static void verticalLeftMover(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.40);
    StdDraw.setPenColor(purple);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.325);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(point.getX() + .45,point.getY() + .52,point.getX() + .59,point.getY() + .43);
    StdDraw.line(point.getX() + .45,point.getY() + .52,point.getX() + .59,point.getY() + .62);
    StdDraw.line(point.getX() + .52,point.getY() + .845,point.getX() + .52,point.getY() + .75);
    StdDraw.line(point.getX() + .52,point.getY() + .195,point.getX() + .52,point.getY() + .29);
  }

  /**
   * vertical right mover game piece.
   */

  public static void verticalRightMover(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.40);
    StdDraw.setPenColor(orange);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.325);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(point.getX() + .59,point.getY() + .52,point.getX() + .45,point.getY() + .43);
    StdDraw.line(point.getX() + .59,point.getY() + .52,point.getX() + .45,point.getY() + .62);
    StdDraw.line(point.getX() + .52,point.getY() + .845,point.getX() + .52,point.getY() + .75);
    StdDraw.line(point.getX() + .52,point.getY() + .195,point.getX() + .52,point.getY() + .29);
  }

  /**
   * vertical up mover game piece.
   */

  public static void verticalUpMover(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(point.getX() + .52, point.getY() + .52, .40);
    StdDraw.setPenColor(blue);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52, .325);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(point.getX() + .52,point.getY() + .845,point.getX() + .52,point.getY() + .75);
    StdDraw.line(point.getX() + .52,point.getY() + .195,point.getX() + .52,point.getY() + .29);
    StdDraw.line(point.getX() + .52,point.getY() + .600,point.getX() + .40,point.getY() + .45);
    StdDraw.line(point.getX() + .52,point.getY() + .600,point.getX() + .64,point.getY() + .45);
  }

  /**
   * vertical down mover game piece.
   */

  public static void verticalDownMover(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.40);
    StdDraw.setPenColor(darkOrange);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.325);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(point.getX() + .52,point.getY() + .845,point.getX() + .52,point.getY() + .75);
    StdDraw.line(point.getX() + .52,point.getY() + .195,point.getX() + .52,point.getY() + .29);
    StdDraw.line(point.getX() + .52,point.getY() + .450,point.getX() + .40,point.getY() + .59);
    StdDraw.line(point.getX() + .52,point.getY() + .450,point.getX() + .64,point.getY() + .59);
  }

  /**
   * open key game piece.
   */

  public static void openKey(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.40);
    StdDraw.setPenColor(blue);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.325);
    StdDraw.setPenRadius(.0135);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(point.getX() + .40,point.getY() + .52,point.getX() + .75,point.getY() + .52);
    StdDraw.setPenRadius(.010);
    StdDraw.line(point.getX() + .7,point.getY() + .52,point.getX() + .7,point.getY() + .39);
    StdDraw.line(point.getX() + .6,point.getY() + .52,point.getX() + .6,point.getY() + .39);
    StdDraw.filledCircle(point.getX() + .365,point.getY() + .52, .125);
    StdDraw.setPenColor(blue);
    StdDraw.filledCircle(point.getX() + .365,point.getY() + .52, .065);
  }

  /**
   * closed port game piece.
   */

  public static void closedPort(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.40);
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.325);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(point.getX() + .36,point.getY() + .35,point.getX() + .67,point.getY() + .67);
    StdDraw.line(point.getX() + .36,point.getY() + .67,point.getX() + .67,point.getY() + .35);
  }

  /**
   * closed vertical switch game piece.
   */

  public static void closedVerticalSwitch(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.40);
    StdDraw.setPenColor(StdDraw.CYAN);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.325);
    StdDraw.setPenRadius(0.0145);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(point.getX() + .52,point.getY() + .845,point.getX() + .52,point.getY() + .75);
    StdDraw.line(point.getX() + .52,point.getY() + .195,point.getX() + .52,point.getY() + .29);
  }

  /**
   * closed horizontal switch gane piece.
   */

  public static void closedHorizontalSwitch(Position point) {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.40);
    StdDraw.setPenColor(StdDraw.CYAN);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.325);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(point.getX() + .845,point.getY() + .52,point.getX() + .75,point.getY() + .52);
    StdDraw.line(point.getX() + .195,point.getY() + .52,point.getX() + .29,point.getY() + .52);
  }

  /**
   * closed key game piece.
   */

  public static void closedKey(Position point) {
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.40);
    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.325);
    StdDraw.setPenRadius(.0135);
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.line(point.getX() + .40,point.getY() + .52,point.getX() + .75,point.getY() + .52);
    StdDraw.setPenRadius(.010);
    StdDraw.line(point.getX() + .7,point.getY() + .52,point.getX() + .7,point.getY() + .39);
    StdDraw.line(point.getX() + .6,point.getY() + .52,point.getX() + .6,point.getY() + .39);
    StdDraw.filledCircle(point.getX() + .365,point.getY() + .52,.125);
    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
    StdDraw.filledCircle(point.getX() + .365,point.getY() + .52,.065);
  }

  /**
   * open vertical switch game piece.
   */

  public static void openVerticalSwitch(Position point) {
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.40);
    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.325);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.line(point.getX() + .52,point.getY() + .845,point.getX() + .52,point.getY() + .75);
    StdDraw.line(point.getX() + .52,point.getY() + .195,point.getX() + .52,point.getY() + .29);
  }

  /**
   * open horizontal switch game piece.
   */

  public static void openHorizontalSwitch(Position point) {
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.40);
    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
    StdDraw.filledCircle(point.getX() + .52,point.getY() + .52,.325);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.line(point.getX() + .845,point.getY() + .52,point.getX() + .75,point.getY() + .52);
    StdDraw.line(point.getX() + .195,point.getY() + .52,point.getX() + .29,point.getY() + .52);
  }

  /**
   * openPort game piece.
   */

  public static void openPort(Position point) {
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.filledCircle(point.getX() + .52, point.getY() + .52, .40);
    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
    StdDraw.filledCircle(point.getX() + .52, point.getY() + .52, .325);
    StdDraw.setPenRadius(.0145);
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.line(point.getX() + .36,point.getY() + .35,point.getX() + .67,point.getY() + .67);
    StdDraw.line(point.getX() + .36,point.getY() + .67,point.getX() + .67,point.getY() + .35);
  }

}
