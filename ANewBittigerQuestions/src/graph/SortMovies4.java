package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * 训练两个月也许还有戏啊~~~
 * 1. 首先使用static class 在有 main 的inner class ，可以不依赖父类instance建立instance 
 * 1.5 注意，这里没有给出所有的点，使用set判断有没有访问 
 * 2. collections.sort 可以用的 comparator 
 * 3. sublist(0, n) is 0 ---（n-1） 的index
 * 4.   List<Movie> res = new ArrayList<>(set); set as list 
 * 5. constructor 的确不用void   :   public Movie(int id, int score) {}
 * 6.  再说一次：compare ---- comparator 
 * 
 * 
 * e. 每个变量名字最好清晰一些，否则非常容易错 
 * 
 */

public class SortMovies4 {

	public static void main(String[] args) {
		Movie m = new Movie(1, 10);

		Movie m1 = new Movie(2, 9);

		Movie m2 = new Movie(3, 8);

		m.related.add(m1);
		m1.related.add(m2);
		
		//
		List<Movie> res = topNMovies(m, 2);

		for (Movie temp : res) {
			System.out.println(temp.id);
			System.out.println(temp.score);
		}
		//System.out.print("good");

		// A -> B (2)
		// B -> C (3)
		// C -> D (4)
		// n = 2, given A as an entry point
		// Expected: C, D
	}

	public static List<Movie> topNMovies(Movie target, int n) {

		//		List<Movie> res = new ArrayList<>();
		//		List<Movie> realNres = new ArrayList<>();
		// 没给全部的，那么就： 用set 吧。。
		Set<Movie> set = new HashSet<>();
		
		for(int i = 0; i < target.related.size(); i++) {
			Movie temp = target.related.get(i);
			if(!set.contains(temp)) {
				set.add(temp);
			}
			for(int j = 0; j < temp.related.size(); j++) {
				if(!set.contains(temp.related.get(j))) {
					set.add(temp.related.get(j));
				}
			}
		}
		
		// set as list and then sort! 
		List<Movie> res = new ArrayList<>(set);
		Collections.sort(res, new MyComparator());
		
		if (set == null || set.size() == 0) {
			return res;
		}

		if (n > res.size()) {
			return res;
		}
		// sublist 这个方法很常用 ！ 0 - n-1 的位置 
		return res.subList(0, n);
	}

	

	private static class MyComparator implements Comparator<Movie> {
		@Override
		public int compare(Movie m1, Movie m2) {
			if (m2.score - m1.score > 0) {
				return 1;
			} else if (m2.score - m1.score < 0) {
				return -1;
			} else {
				return 0;
			}

		}
	}
	

	static class Movie {
		int id;
		int score;
		ArrayList<Movie> related;
		
		public Movie(int id, int score) {
			this.id = id;
			this.score = score;
			this.related = new ArrayList<>();
		}
		
	}

}






