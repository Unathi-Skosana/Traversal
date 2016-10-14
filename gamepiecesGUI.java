import java.awt.Color;

public class gamepiecesGUI {

  private static final Color green = new Color(0, 117, 5);
  private static final Color orange = new Color(183, 168, 31);
  private static final Color purple = new Color(182, 0, 255);
  private static final Color darkOrange = new Color(219, 146, 0);
  private static final Color blue = new Color(0, 76, 255);
  private static final Color greenK = new Color(24, 219, 190);

    public static void player(int i, int j) {    
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(i + .52,j + .52,.40);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(i + .52,j + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(i + .52,j + .72,i + .52,j + .32);
        StdDraw.line(i + .72,j + .52,i + .32,j + .52);
    }

    public static void closed_Port(int i, int j) {
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledCircle(i + .52, j + .52, .40);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledCircle(i + .52, j + .52, .325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.line(i + .36,j + .35,i + .67,j + .67);
        StdDraw.line(i + .36,j + .67,i + .67,j + .35);
    }

	  public static void target(int i, int j) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(i + .52, j + .52, .40);
        StdDraw.setPenColor(greenK);
        StdDraw.filledCircle(i + .52,j + .52, .325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(i + .335,j + .49,i + .431,j + .37);
        StdDraw.line(i + .431,j + .37,i + .700,j + .64);
    }

	  public static void vert_UpMover(int i, int j) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(i + .52, j + .52, .40);
        StdDraw.setPenColor(blue);
        StdDraw.filledCircle(i + .52,j + .52, .325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(i + .52,j + .845,i + .52,j + .75);
        StdDraw.line(i + .52,j + .195,i + .52,j + .29);
        StdDraw.line(i + .52,j + .600,i + .40,j + .45);
        StdDraw.line(i + .52,j + .600,i + .64,j + .45);
    }

	  public static void hor_UpMover(int i,int j) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(i + .52,j + .52, .40);
        StdDraw.setPenColor(blue);
        StdDraw.filledCircle(i + .52, j + .52, .325);
        StdDraw.setPenRadius(0.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(i + .520,j + .60,i + .40,j + .45);
        StdDraw.line(i + .520,j + .60,i + .64,j + .45);
        StdDraw.line(i + .845,j + .52,i + .75,j + .52);
        StdDraw.line(i + .195,j + .52,i + .29,j + .52);
    }

 	  public static void hor_DownMover(int i,int j) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(i + .52,j + .52, .40);
        StdDraw.setPenColor(darkOrange);
        StdDraw.filledCircle(i + .52,j + .52, .325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(i + .520,j + .42,i + .40,j + .59);
        StdDraw.line(i + .520,j + .42,i + .62,j + .59);
        StdDraw.line(i + .845,j + .52,i + .75,j + .52);
        StdDraw.line(i + .195,j + .52,i + .29,j + .52);
    }

	  public static void hor_RightMover(int i, int j) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(i + .52, j + .52, .40);
        StdDraw.setPenColor(orange);
        StdDraw.filledCircle(i + .52,j + .52, .325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(i + .59, j + .52,i + .45,j + .43);
        StdDraw.line(i + .59, j + .52,i + .45,j + .62);
        StdDraw.line(i + .845,j + .52,i + .75,j + .52);
        StdDraw.line(i + .195,j + .52,i + .29,j + .52);
    }

	  public static void hor_LeftMover(int i, int j) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(i + .52,j + .52 ,.40);
        StdDraw.setPenColor(purple);
        StdDraw.filledCircle(i + .52,j + .52, .325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(i + .450,j + .52,i + .59,j + .43);
        StdDraw.line(i + .450,j + .52,i + .59,j + .62);
        StdDraw.line(i + .845,j + .52,i + .75,j + .52);
        StdDraw.line(i + .195,j + .52,i + .29,j + .52);
    }

	  public static void open_Key(int i,int j) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(i + .52,j + .52,.40);
        StdDraw.setPenColor(blue);
        StdDraw.filledCircle(i + .52,j + .52,.325);
        StdDraw.setPenRadius(.0135);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(i + .40,j + .52,i + .75,j + .52);
        StdDraw.setPenRadius(.010);
        StdDraw.line(i + .7,j + .52,i + .7,j + .39);
        StdDraw.line(i + .6,j + .52,i + .6,j + .39);
        StdDraw.filledCircle(i + .365,j + .52, .125);
        StdDraw.setPenColor(blue);
        StdDraw.filledCircle(i + .365,j + .52, .065);
    }

	  public static void open_Port(int i, int j) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(i + .52,j + .52,.40);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(i + .52,j + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(i + .36,j + .35,i + .67,j + .67);
        StdDraw.line(i + .36,j + .67,i + .67,j + .35);
    }

	  public static void open_VertSwitch(int i, int j) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(i + .52,j + .52,.40);
        StdDraw.setPenColor(StdDraw.CYAN);
        StdDraw.filledCircle(i + .52,j + .52,.325);
        StdDraw.setPenRadius(0.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(i + .52,j + .845,i + .52,j + .75);
        StdDraw.line(i + .52,j + .195,i + .52,j + .29);
    }

    public static void open_HorSwitch(int i,int j) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(i + .52,j + .52,.40);
        StdDraw.setPenColor(StdDraw.CYAN);
        StdDraw.filledCircle(i + .52,j + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(i + .845,j + .52,i + .75,j + .52);
        StdDraw.line(i + .195,j + .52,i + .29,j + .52);
    }

	  public static void closed_HorSwitch(int i,int j) {
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledCircle(i + .52,j + .52,.40);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledCircle(i + .52,j + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.line(i + .845,j + .52,i + .75,j + .52);
        StdDraw.line(i + .195,j + .52,i + .29,j + .52);
    }

	  public static void closed_VertSwitch(int i, int j) {
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledCircle(i + .52,j + .52,.40);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledCircle(i + .52,j + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.line(i + .52,j + .845,i + .52,j + .75);
        StdDraw.line(i + .52,j + .195,i + .52,j + .29);
    }

	  public static void closed_Key(int i,int j) {
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledCircle(i + .52,j + .52,.40);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledCircle(i + .52,j + .52,.325);
        StdDraw.setPenRadius(.0135);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.line(i + .40,j + .52,i + .75,j + .52);
        StdDraw.setPenRadius(.010);
        StdDraw.line(i + .7,j + .52,i + .7,j + .39);
        StdDraw.line(i + .6,j + .52,i + .6,j + .39);
        StdDraw.filledCircle(i + .365,j + .52,.125);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledCircle(i + .365,j + .52,.065);
    }

	  public static void wall(int i, int j) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(.52 + i,.52 + j,.40);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledCircle(.52 + i,.52 + j,.325);
    }

  	public static void vert_LeftMover(int i, int j) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(i + .52,j + .52,.40);
        StdDraw.setPenColor(purple);
        StdDraw.filledCircle(i + .52,j + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(i + .45,j + .52,i + .59,j + .43);
        StdDraw.line(i + .45,j + .52,i + .59,j + .62);
        StdDraw.line(i + .52,j + .845,i + .52,j + .75);
        StdDraw.line(i + .52,j + .195,i + .52,j + .29);
    }

	  public static void vert_RightMover(int i, int j) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(i + .52,j + .52,.40);
        StdDraw.setPenColor(orange);
        StdDraw.filledCircle(i + .52,j + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(i + .59,j + .52,i + .45,j + .43);
        StdDraw.line(i + .59,j + .52,i + .45,j + .62);
        StdDraw.line(i + .52,j + .845,i + .52,j + .75);
        StdDraw.line(i + .52,j + .195,i + .52,j + .29);
    }

	  public static void vert_DownMover(int i, int j) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(i + .52,j + .52,.40);
        StdDraw.setPenColor(darkOrange);
        StdDraw.filledCircle(i + .52,j  + .52,.325);
        StdDraw.setPenRadius(.0145);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(i + .52,j + .845,i + .52,j + .75);
        StdDraw.line(i + .52,j + .195,i + .52,j + .29);
        StdDraw.line(i + .52,j + .450,i + .40,j + .59);
        StdDraw.line(i + .52,j + .450,i + .64,j + .59);
    }

	  public static void initialiseBoard(int R, int C) {
        StdDraw.setCanvasSize(100 * R,100 * C);
        StdDraw.setXscale(0, R);
        StdDraw.setYscale(0, C);
    }

    public static void drawborder(int R,int C) {
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
}
