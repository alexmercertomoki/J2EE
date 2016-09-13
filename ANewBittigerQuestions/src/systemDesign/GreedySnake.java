package systemDesign;

public class GreedySnake {
	
	public class Point {
		int i;
		int j;
		
		int points; 
	}
	public class GameBoard {
		int[][] board; 
		public GameBoard(int n, int[][] points) {
			board = new int[n][n];
			for(int[] point : points) {
				board[point[0]][point[1]] = 1;
			}
		}
		
	}
	
	
	public class Snake {
		int length; 
		boolean state;
		int[][] pos; 
		public Snake(int length, boolean state) {
			this.length = length;
			this.state = state;
			
		}
	}
	
	
	public static void main(String args[]) {
		
		
	}
	
//	public static init() {
//		
//		
//	}
	
	
	
}
