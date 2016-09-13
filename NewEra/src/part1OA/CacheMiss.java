package part1OA;

import java.util.LinkedList;

public class CacheMiss {
	public int cm(int[] taskarr, int cachesize) {
		if(taskarr == null) return 0; 
		LinkedList<Integer> cache = new LinkedList<Integer>();
		int count = 0;
		for(int i = 0; i < taskarr.length; i ++){
			if(cache.contains(taskarr[i])){
				cache.remove(new Integer[taskarr[i]]);
			} else {
				count ++;
				if(cachesize == cache.size()){
					cache.remove(0);
				}
			}

			cache.add(taskarr[i]);
		}
		return  count; 
		
	}

}
