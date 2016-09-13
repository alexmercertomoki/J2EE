package array;

import java.util.HashMap;

public class IslandsNumbers {
	public int[] islandNumber(int[][] islands, int[] sizes) {
		
		if(islands == null || islands.length == 0 || sizes == null || sizes.length == 0) {
			return null;
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < sizes.length; i++) {
			map.put(sizes[i], 0);
		}
	
		for(int i = 0; i < islands.length;i++) {
			for(int j = 0; j < islands[0].length; j++) {
				int count  = -1;
				if(islands[i][j] == 1) {
					 count = findAllIslands(islands, i, j, 0);
				}
				if(map.get(count) != null) {
					map.put(count, map.get(count) + 1);
				}
				
			}
		}
		
//		Iterator itr = map.entrySet().iterator()
		
		for(int i = 0; i < sizes.length; i++) {
			sizes[i] = map.get(sizes[i]);
		}
		return sizes;
		
	}
	
	public int findAllIslands(int[][] islands, int i, int j, int count) {
		
		islands[i][j] = 0;
		count++;
		
		if(i + 1 < islands.length && islands[i + 1][j] == 1) {
			count = findAllIslands(islands, i + 1, j, count);
		}
		if(i - 1 >= 0 && islands[i - 1][j] ==  1) {
			count = findAllIslands(islands, i - 1, j, count);
		}
		if(j + 1 < islands[0].length && islands[i][j + 1] == 1) {
			count = findAllIslands(islands, i, j + 1, count);
		}
		if(j - 1 >= 0 && islands[i][j - 1] == 1) {
			count = findAllIslands(islands, i, j - 1, count);
		}
		
		return count;
		
	}
}
