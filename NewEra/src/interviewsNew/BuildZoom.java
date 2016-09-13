package interviewsNew;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *

 var image = [
 [0, 0, 1, 1, 0, 1, 1],
 [0, 0, 1, 1, 1, 1, 1],
 [1, 1, 0, 0, 0, 0, 1],
 [0, 0, 1, 0, 0, 0, 1],
 [0, 0, 1, 1, 1, 1, 1]
 ];

 1 - white
 0 - black

 * If you need more classes, simply define them inline.
 */

class Solution {

	class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public Coordinate[] blackBox(int[][] pic) {

		ArrayList<Coordinate> arr = new ArrayList<Coordinate>();
		for (int i = 0; i < pic.length; i++) {
			for (int j = 0; j < pic[i].length; j++) {
				if (pic[i][j] == 0) {
					arr.add(new Coordinate(i, j));
				}
			}
		}
		Coordinate[] result = new Coordinate[2];
		result[0] = arr.get(0);
		result[1] = arr.get(arr.size() - 1);

		return result;
	}
	
	
//	public Coordinate[] manyBlackBox(int[][] pic) {
//		Queue<Coordinate> queue = new LinkedList<>();
//		
//		
//		for (int i = 0; i < pic.length; i++) {
//			for (int j = 0; j < pic[i].length; j++) {
//				if (pic[i][j] == 0) {
//					queue.offer(new Coordinate(i, j));
//					
//				}
//			}
//		}
//		
//	}

	public int scan(int[][] pic) {
		int count = 0;
//		for (i=0;i<n;i++)
//			for (j=0;j<m;j++)
//				if (image[i][j] == 0) {
//					explorePoint(i,j);
//					count ++;
//				}
	
		for(int i = 0; i < pic.length; i++) {
			for(int j = 0; j < pic[0].length; j++) {
				if(pic[i][j] == 0) {
					explorePoint((new Coordinate(i, j)), pic);
					count++;
				}
			}
		}
		
		return count;
	}
	
	
	public void explorePoint(Coordinate cd, int[][] pic) {
//		int dx = {1,0,-1,0};
//		int dy = {0,1,0,-1};
//		Queue<> queue;
//		queue.add(x,y);
//		while (!queue.isEmpty()) {
//			x1, y1 = queue.poll();
//			image[x1][y1] = 1;
//			for (i =0 ;i <4;i++) {
//				nx = x1 + dx[i];
//				ny = y1 + dy[i];
//				if isValid(nx,ny) && image[nx][ny] == 0
//						queue.add(nx,ny);
//			}
//		}
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		Queue<Coordinate> q = new LinkedList<>();
		q.add(cd);
		
		while(!q.isEmpty()) {
			Coordinate temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			pic[x][y]  = 1;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if( nx >= 0 && ny >= 0) {
					if(pic[nx][ny] == 0) {
						q.add(new Coordinate(nx, ny));
					}
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] pic = {{1,1,1}, {1,0,1}, {1,1,1}};
		System.out.println();
	}

}

/*
 * Your previous Markdown content is preserved below:
 * 
 * Welcome to the Interview!
 */