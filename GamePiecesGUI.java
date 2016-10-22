import java.awt.Color;

public class GamePiecesGUI {

  private static final Color green = new Color(0, 117, 5);
  private static final Color orange = new Color(183, 168, 31);
  private static final Color purple = new Color(182, 0, 255);
  private static final Color darkOrange = new Color(219, 146, 0);
  private static final Color blue = new Color(0, 76, 255);
  private static final Color greenK = new Color(24, 219, 190);


    public static void initialiseCanvas(int R, int C) {
        StdDraw.setCanvasSize(100 * R,100 * C);
        StdDraw.setXscale(0, R);
        StdDraw.setYscale(0, C);
        drawBorder(R, C);
    }

    public static void drawBorder(int R, int C) {
        for (double n = .525; n < R; n++) {
            for (double m = .525; m < C; m++) {
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                StdDraw.filledSquare(n, m, .525);
            }
        }

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.0160);
        StdDraw.line(0,0,0,C);
        StdDraw.line(0,C,R,C);
        StdDraw.line(R,C,R,0);
        StdDraw.line(R,0,0,0);
    }
 
    public static void player(Position p) {    
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.40);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(p.getX() + .52,p.getY() + .72,p.getX() + .52,p.getY() + .32);
        StdDraw.line(p.getX() + .72,p.getY() + .52,p.getX() + .32,p.getY() + .52);
    }

	  public static void target(Position p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(p.getX() + .52, p.getY() + .52, .40);
        StdDraw.setPenColor(greenK);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52, .325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(p.getX() + .335,p.getY() + .49,p.getX() + .431,p.getY() + .37);
        StdDraw.line(p.getX() + .431,p.getY() + .37,p.getX() + .700,p.getY() + .64);
    }

	  public static void wall(Position p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(.52 + p.getX() ,.52 + p.getY() ,.40);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledCircle(.52 + p.getX() ,.52 + p.getY() ,.325);
    }
 
	  public static void hor_UpMover(Position p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52, .40);
        StdDraw.setPenColor(blue);
        StdDraw.filledCircle(p.getX() + .52, p.getY() + .52, .325);
        StdDraw.setPenRadius(0.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(p.getX() + .520,p.getY() + .60,p.getX() + .40,p.getY() + .45);
        StdDraw.line(p.getX() + .520,p.getY() + .60,p.getX() + .64,p.getY() + .45);
        StdDraw.line(p.getX() + .845,p.getY() + .52,p.getX() + .75,p.getY() + .52);
        StdDraw.line(p.getX() + .195,p.getY() + .52,p.getX() + .29,p.getY() + .52);
    }

 	  public static void hor_DownMover(Position p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52, .40);
        StdDraw.setPenColor(darkOrange);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52, .325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(p.getX() + .520,p.getY() + .42,p.getX() + .40,p.getY() + .59);
        StdDraw.line(p.getX() + .520,p.getY() + .42,p.getX() + .62,p.getY() + .59);
        StdDraw.line(p.getX() + .845,p.getY() + .52,p.getX() + .75,p.getY() + .52);
        StdDraw.line(p.getX() + .195,p.getY() + .52,p.getX() + .29,p.getY() + .52);
    }

	  public static void hor_RightMover(Position p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52, .40);
        StdDraw.setPenColor(orange);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52, .325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(p.getX() + .59, p.getY() + .52,p.getX() + .45,p.getY() + .43);
        StdDraw.line(p.getX() + .59, p.getY() + .52,p.getX() + .45,p.getY() + .62);
        StdDraw.line(p.getX() + .845,p.getY() + .52,p.getX() + .75,p.getY() + .52);
        StdDraw.line(p.getX() + .195,p.getY() + .52,p.getX() + .29,p.getY() + .52);
    }

	  public static void hor_LeftMover(Position p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52 ,.40);
        StdDraw.setPenColor(purple);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52, .325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(p.getX() + .450,p.getY() + .52,p.getX() + .59,p.getY() + .43);
        StdDraw.line(p.getX() + .450,p.getY() + .52,p.getX() + .59,p.getY() + .62);
        StdDraw.line(p.getX() + .845,p.getY() + .52,p.getX() + .75,p.getY() + .52);
        StdDraw.line(p.getX() + .195,p.getY() + .52,p.getX() + .29,p.getY() + .52);
    }
	  
  	public static void vert_LeftMover(Position p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.40);
        StdDraw.setPenColor(purple);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(p.getX() + .45,p.getY() + .52,p.getX() + .59,p.getY() + .43);
        StdDraw.line(p.getX() + .45,p.getY() + .52,p.getX() + .59,p.getY() + .62);
        StdDraw.line(p.getX() + .52,p.getY() + .845,p.getX() + .52,p.getY() + .75);
        StdDraw.line(p.getX() + .52,p.getY() + .195,p.getX() + .52,p.getY() + .29);
    }

	  public static void vert_RightMover(Position p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.40);
        StdDraw.setPenColor(orange);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(p.getX() + .59,p.getY() + .52,p.getX() + .45,p.getY() + .43);
        StdDraw.line(p.getX() + .59,p.getY() + .52,p.getX() + .45,p.getY() + .62);
        StdDraw.line(p.getX() + .52,p.getY() + .845,p.getX() + .52,p.getY() + .75);
        StdDraw.line(p.getX() + .52,p.getY() + .195,p.getX() + .52,p.getY() + .29);
    }

    public static void vert_UpMover(Position p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(p.getX() + .52, p.getY() + .52, .40);
        StdDraw.setPenColor(blue);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52, .325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(p.getX() + .52,p.getY() + .845,p.getX() + .52,p.getY() + .75);
        StdDraw.line(p.getX() + .52,p.getY() + .195,p.getX() + .52,p.getY() + .29);
        StdDraw.line(p.getX() + .52,p.getY() + .600,p.getX() + .40,p.getY() + .45);
        StdDraw.line(p.getX() + .52,p.getY() + .600,p.getX() + .64,p.getY() + .45);
    }


	  public static void vert_DownMover(Position p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.40);
        StdDraw.setPenColor(darkOrange);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(p.getX() + .52,p.getY() + .845,p.getX() + .52,p.getY() + .75);
        StdDraw.line(p.getX() + .52,p.getY() + .195,p.getX() + .52,p.getY() + .29);
        StdDraw.line(p.getX() + .52,p.getY() + .450,p.getX() + .40,p.getY() + .59);
        StdDraw.line(p.getX() + .52,p.getY() + .450,p.getX() + .64,p.getY() + .59);
    }

    public static void open_Key(Position p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.40);
        StdDraw.setPenColor(blue);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.325);
        StdDraw.setPenRadius(.0135);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(p.getX() + .40,p.getY() + .52,p.getX() + .75,p.getY() + .52);
        StdDraw.setPenRadius(.010);
        StdDraw.line(p.getX() + .7,p.getY() + .52,p.getX() + .7,p.getY() + .39);
        StdDraw.line(p.getX() + .6,p.getY() + .52,p.getX() + .6,p.getY() + .39);
        StdDraw.filledCircle(p.getX() + .365,p.getY() + .52, .125);
        StdDraw.setPenColor(blue);
        StdDraw.filledCircle(p.getX() + .365,p.getY() + .52, .065);
    }

	  public static void open_Port(Position p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.40);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(p.getX() + .36,p.getY() + .35,p.getX() + .67,p.getY() + .67);
        StdDraw.line(p.getX() + .36,p.getY() + .67,p.getX() + .67,p.getY() + .35);
    }

	  public static void open_VertSwitch(Position p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.40);
        StdDraw.setPenColor(StdDraw.CYAN);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.325);
        StdDraw.setPenRadius(0.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(p.getX() + .52,p.getY() + .845,p.getX() + .52,p.getY() + .75);
        StdDraw.line(p.getX() + .52,p.getY() + .195,p.getX() + .52,p.getY() + .29);
    }

    public static void open_HorSwitch(Position p) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.40);
        StdDraw.setPenColor(StdDraw.CYAN);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(p.getX() + .845,p.getY() + .52,p.getX() + .75,p.getY() + .52);
        StdDraw.line(p.getX() + .195,p.getY() + .52,p.getX() + .29,p.getY() + .52);
    }

    public static void closed_Key(Position p) {
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.40);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.325);
        StdDraw.setPenRadius(.0135);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.line(p.getX() + .40,p.getY() + .52,p.getX() + .75,p.getY() + .52);
        StdDraw.setPenRadius(.010);
        StdDraw.line(p.getX() + .7,p.getY() + .52,p.getX() + .7,p.getY() + .39);
        StdDraw.line(p.getX() + .6,p.getY() + .52,p.getX() + .6,p.getY() + .39);
        StdDraw.filledCircle(p.getX() + .365,p.getY() + .52,.125);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledCircle(p.getX() + .365,p.getY() + .52,.065);
    }


    public static void closed_VertSwitch(Position p) {
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.40);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.line(p.getX() + .52,p.getY() + .845,p.getX() + .52,p.getY() + .75);
        StdDraw.line(p.getX() + .52,p.getY() + .195,p.getX() + .52,p.getY() + .29);
    }

    public static void closed_HorSwitch(Position p) {
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.40);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledCircle(p.getX() + .52,p.getY() + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.line(p.getX() + .845,p.getY() + .52,p.getX() + .75,p.getY() + .52);
        StdDraw.line(p.getX() + .195,p.getY() + .52,p.getX() + .29,p.getY() + .52);
    }

    public static void closed_Port(Position p) {
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledCircle(p.getX() + .52, p.getY() + .52, .40);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledCircle(p.getX() + .52, p.getY() + .52, .325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.line(p.getX() + .36,p.getY() + .35,p.getX() + .67,p.getY() + .67);
        StdDraw.line(p.getX() + .36,p.getY() + .67,p.getX() + .67,p.getY() + .35);
    }

}
