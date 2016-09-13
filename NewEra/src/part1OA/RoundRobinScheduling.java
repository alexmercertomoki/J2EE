package part1OA;

import java.util.LinkedList;
import java.util.Queue;

public class RoundRobinScheduling {
	
	public float rrs(int[] artime, int[] extime, int q){
		if(artime == null || extime == null || artime.length != extime.length) return 0;
		
		Queue<Process> processQueue = new LinkedList<Process>();
		int curTime = 0, waittime = 0, index = 0;
		int len = artime.length; 
		
		while(!processQueue.isEmpty() || index < len){
			if(!processQueue.isEmpty()){
				Process cur = processQueue.poll();
				waittime += curTime - cur.arrTime;
				curTime += Math.min(cur.exeTime, q);
				for(;index < len && artime[index] < curTime ;index ++){
					processQueue.offer(new Process(artime[index], extime[index]));
				}
				if(cur.exeTime > q){
					processQueue.offer(new Process(curTime, cur.exeTime - q));
				}
				
				
			} else {
				processQueue.offer(new Process(artime[index], extime[index]));
				curTime = artime[index ++];
			}
			
		}
		
		return (float) waittime / len; 
		
	}

}
