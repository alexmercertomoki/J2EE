package part1OA;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestJobFirst {
	public float sjf(int[] req, int[] dur){
		if(req == null || dur == null || req.length != dur.length) return 0; 
		MyComparator comp = new MyComparator();
		PriorityQueue<Process> pqprocess = new PriorityQueue<Process>(req.length, comp);
		int len = req.length, index = 0, curTime = 0, waittime = 0; 
		
		while(!pqprocess.isEmpty() || index < len){
			if(!pqprocess.isEmpty()){
				Process cur = pqprocess.poll(); 
				waittime += curTime - cur.arrTime;
				curTime += cur.exeTime;
				
				for(; index < len && curTime >= req[index]; index ++ ){
					pqprocess.offer(new Process(req[index], dur[index]));
				}
				
			} else {
				pqprocess.offer(new Process(req[index], dur[index]));
				curTime = req[index];
				index ++; 
			}
			
		}
		
		return (float) waittime / len; 
 		
	}
	
	private class MyComparator implements Comparator<Process>{
		public int compare(Process p1, Process p2){
			if(p1.exeTime == p2.exeTime) return p1.arrTime - p2.arrTime;
			return  p1.exeTime - p2.exeTime; 
		}
	}

}
