//package graph;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//public class ScheduleCourse {
//	
//	public List<Integer> courseSch(int[][] edge) {
//		Map<Integer, Set<Integer>> graph = new HashMap<>();
//		Map<Integer, Integer> indegreeMap = new HashMap<>();
//		
//		for(int[] courses : edge) {
//			if(graph.containsKey(courses[0])) {
//				graph.get(courses[0]).add(courses[1]);
//				indegreeMap.put(courses[0], indegreeMap.get(courses[0]) + 1); 
//			} else {
//				Set<Integer> set = new HashSet<>();
//				set.add(courses[1]);
//				graph.put(courses[0], set); 
//			}
//			if(graph.containsKey(courses[1])) {
//				graph.get(courses[1]).add(courses[0]);
//			} else {
//				Set<Integer> set = new HashSet<>();
//				set.add(courses[0]);
//				graph.put(courses[1], set);
//				indegreeMap.put(courses[1], indegreeMap.get(courses[1]) + 1); 
//			}
//			
//		}
//		
//		
//		
////		for(EntrySet<> : indegree.getEntr) {
////			
////		}
//		
//		
//		
//		
//		
//		
//		
//	}
//
//}
