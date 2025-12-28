/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function. Uncomment the
		/// second code block to test the snowflake function. Uncomment only one block in
		/// each test, and remember to compile the class whenever you change the test.

		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		// curve(Integer.parseInt(args[0]),
		// Double.parseDouble(args[1]), Double.parseDouble(args[2]),
		// Double.parseDouble(args[3]), Double.parseDouble(args[4]));

		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));

	}

	/**
	 * Gets n, x1, y1, x2, y2,
	 * and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
	 */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}
		double x12 = x1 + (x2 - x1) / 3.0;
		double y12 = y1 + (y2 - y1) / 3.0;

		double x21 = x2 - (x2 - x1) / 3.0;
		double y21 = y2 - (y2 - y1) / 3.0;

		double x3 = 0.5 * (x12 + x21) + Math.sqrt(3) / 2 * (y12 - y21);
		double y3 = 0.5 * (y12 + y21) + Math.sqrt(3) / 2 * (x21 - x12);

		curve(n - 1, x1, y1, x12, y12);
		curve(n - 1, x12, y12, x3, y3);
		curve(n - 1, x3, y3, x21, y21);
		curve(n - 1, x21, y21, x2, y2);

	}

	/** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);

		curve(n, 0.200, 0.650, 0.800, 0.650);

		curve(n, 0.800, 0.650, 0.500, 0.130);

		curve(n, 0.500, 0.130, 0.200, 0.650);

	}
}
