package part1OA;

public class RotateARect2 {
	int row,col;
	public int[][] rar2(int[][] matrix,boolean flag){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
		row = matrix.length;
		col = matrix[0].length;
		int[][] currentMatrix = transpose(matrix);
		flip(currentMatrix, true);
		
		return currentMatrix;
	}
	private int[][] transpose(int[][] matrix){
		int[][] cm = new int[row][col];
		for(int i = 0; i < row; i ++){
			for(int j = 0; j < col; j ++){
				cm[i][j] = matrix[j][i];
			}
		}
		return cm;
	}
	private void flip(int[][] cm, boolean flag){
		if(flag){
			for(int i = 0; i < row; i ++){
				for(int j = 0; j < col / 2; j ++){
					cm[i][j] ^= cm[i][col - j - 1];
					cm[i][col - j - 1] ^= cm[i][j];
					cm[i][j] ^= cm[i][col - j - 1];
				}
			}
		} else {
			for(int i = 0; i < row / 2; i ++){
				for(int j = 0; j < col; j ++){
					cm[i][j] ^= cm[row - i - 1][j];
					cm[row - i - 1][j] ^= cm[i][j];
					cm[i][j] ^= cm[row - i - 1][j];
				}
			}
			
		}
		
	}

}
