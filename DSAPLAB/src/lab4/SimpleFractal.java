package lab4;


/**************************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * 
 * Lab 4 Number of Collisions Comparison and Drawing a simple fractal of N
 * squares with recursion
 * 
 * Andrew ID: Bilei Name: Huang
 * 
 **************************************************************/

public class SimpleFractal {

	public static void main(String[] args) {
		/*
		 * canvas width and height are both 1.0 initial call to create 10
		 * squares please use the following initial call for consistency
		 */
		fractal(10, 0, 0, 0.5);
	}

	/**
	 * recursive method to draw a fractal of n number of squares
	 */
	public static void fractal(int n, double x, double y, double length) {
		/*
		 * use filledSquare method in StdDraw class which draws a filled square
		 * of side length 2r, centered on (x, y).
		 */
		// n or x or y or length all should be greater or equal to 0
		if (n >= 0 && x >= 0 && y >= 0 && length >= 0) {
			// call the recursive method
			fractalHelper(n, x + length / 2, y + length / 2, length / 2, 0);

		}
	}

	// the recursive helper 
	public static void fractalHelper(int times, double x, double y, double r,
			int time) {
		// if the time reaches return 
		if (time == times) {
			return;
		}
		
		else {
			// draw the square
			StdDraw.filledSquare(x, y, r);
			//do recursive 
			fractalHelper(times, x + 1.5 * r, y + 1.5 * r, r / 2, ++time);

		}

	}

}