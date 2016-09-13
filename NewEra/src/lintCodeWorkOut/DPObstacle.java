package lintCodeWorkOut;

public class DPObstacle {
	    /**
	     * @param obstacleGrid: A list of lists of integers
	     * @return: An integer
	     */
	    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        // write your code here
	        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
	            return 0;
	        }
	        int m = obstacleGrid.length;
	        int n = obstacleGrid[0].length;
	        
	        int[][] path = new int[m][n];
	        
	        for(int i = 0; i < m; i++) {
	            if(obstacleGrid[i][0] != 1) {
	                path[i][0] = 1;
	            } else {
	                break;
	            }
	        }
	        
	        for(int j = 0; j < n; j++) {
	            if(obstacleGrid[0][j] != 1) {
	                path[0][j] = 1;
	            } else {
	               break;
	            }
	        }
	        
	        for(int i = 1; i < m; i++) {
	            for(int j = 1; j < n; j++) {
	                if(obstacleGrid[i][j] != 1) {
	                    path[i][j] = path[i - 1][j] + path[i][j - 1]; 
	                } else {
	                    path[i][j] = 0;
	                }
	            }
	        }
	        
	        return path[m - 1][n - 1];
	    }
}
