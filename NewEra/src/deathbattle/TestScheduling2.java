package deathbattle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;


//illegal input like: end time < start time 
public class TestScheduling2 {
	
	static ArrayList<ScheduleObject> output = new ArrayList<ScheduleObject>();
	static ArrayList<ScheduleObject> rej = new ArrayList<ScheduleObject>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReadInFile rif = new ReadInFile();
		rif.getSchedule();
		ArrayList<ScheduleObject> cmArr = rif.getArr();
		HashMap<String,ArrayList<ScheduleObject>>   hm = new HashMap<String,ArrayList<ScheduleObject>> ();
		
		Iterator<ScheduleObject> itr = cmArr.iterator();
		  
		while(itr.hasNext()){
			ScheduleObject scheObj = itr.next();
			ArrayList<ScheduleObject> list;
			if(hm.get(scheObj.getAreaId()) != null){
				list =  hm.get(scheObj.getAreaId());
			} else{
				list = new ArrayList<ScheduleObject>();
			}
			
			list.add(scheObj);
			hm.put(scheObj.getAreaId(), list);
			
		}
		
		Iterator itrMap = hm.entrySet().iterator(); 
			
		WriteToOutput wto = new WriteToOutput();
			while(itrMap.hasNext()){
				Map.Entry<String, ArrayList<ScheduleObject>> pair = (Entry<String, ArrayList<ScheduleObject>>) itrMap.next();
				ArrayList<ScheduleObject> areaArrayList = pair.getValue();
				Collections.sort(areaArrayList);
				
				
				PriorityQueue<ScheduleObject> pq = new PriorityQueue<ScheduleObject>();
				
				Iterator<ScheduleObject>  itrForEachArea = areaArrayList.iterator();
				
				while(itrForEachArea.hasNext()){
					
					ScheduleObject sobj = itrForEachArea.next();
					ScheduleObject scheObjPq = null;
					
					
					Iterator<ScheduleObject>  itrPq = pq.iterator();
					
					while(itrPq.hasNext()){
						
						scheObjPq = itrPq.next();
						
						if(sobj.getContentId().equals(scheObjPq.getContentId())){
							wto.writeTo(sobj, "rejectfile.txt");
						} 
						
					}
						
					if(pq.size() < 3){
						pq.offer(sobj);
					} else{

						ScheduleObject  temp = pq.peek();
						int minEndTime = temp.getEndTime();
						
						if(scheObjPq.getStartTime() > minEndTime){
							output.add(temp);
							
							System.out.println("get the minEndTime one out");
							pq.poll();
							pq.offer(scheObjPq);
							
						} else{
							rej.add(scheObjPq);
						}
						
					}
					
				}
				
			}
			
		
			for(int i = 0; i < output.size(); i ++){
				wto.writeTo(output.get(i), "outputfile.txt");
			}
			
			for(int i = 0; i < rej.size(); i ++){
				wto.writeTo(rej.get(i), "rejectfile.txt");
			}
		
	}
	
	public class MyComparator implements Comparator<ScheduleObject>{
		
		@Override
		public int compare(ScheduleObject o1, ScheduleObject o2) {
			// TODO Auto-generated method stub
			return o1.getEndTime() - o2.getEndTime();
		}
		
		
	}
	
	
	

}
