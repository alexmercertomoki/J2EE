package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewHashingFunctions {
	public static void main(String[] args) {
//		Map<Integer, String> map = new HashMap<>();
//		
//		// 如果空则加入， putIfAbsent避免我们将null写入
//		for(int i = 0; i < 10; i++) {
//			map.putIfAbsent(i, "val" + i);
//		}
//		
//		//对于key，val 输出key val  forEach接受一个消费者对象
//		map.forEach((key, val) -> System.out.println(key + "  " + val));
//		 int[] arr = new int[3];
//		 Map<String, PriorityQueue<String>> targets = new HashMap<>();  
//		 targets.computeIfAbsent(arr[0], k -> new PriorityQueue()).add(arr[1]);  
		 
		Map<Integer, List<Integer>> map = new HashMap<>();
		map.put(1, new ArrayList<>());
		map.get(1).add(2);
		
		System.out.println(map.toString());
		
	}

}
