package deathbattle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TestScheduling4 {

	public static final String rejectfile = "rejectfile.txt";
	public static final String outputfile = "outputfile.txt";

	public static void main(String[] args) {

		// read the file to an array list
		ReadInFile rif = new ReadInFile();
		rif.getSchedule();
		ArrayList<ScheduleObject> cmArr = rif.getArr();
		// key is area id array list is a list of
		HashMap<String, ArrayList<ScheduleObject>> hm = new HashMap<String, ArrayList<ScheduleObject>>();
		
		putObjToHm(hm, cmArr);

		// prority queue to hold only 3 elements representing the schedule
		// capacity at a certain time is 3
		PriorityQueue<ScheduleObject> pq = null;
		// write to file object for further use
		WriteToOutput wto = new WriteToOutput();
		// iterate through the hash map
		processAllArea(hm, pq, wto);
	

	}

	private static void putObjToHm(
			HashMap<String, ArrayList<ScheduleObject>> hm,
			ArrayList<ScheduleObject> cmArr) {

		// iteration adding all schedule objects to the hashmap
		for(int i = 0; i < cmArr.size(); i ++){
			
			ScheduleObject scheObj = cmArr.get(i);
			
			ArrayList<ScheduleObject> list;
			// if the list belongs to the area exists we get the list
			if (hm.get(scheObj.getAreaId()) != null) {
				list = hm.get(scheObj.getAreaId());
			} else {
				// if not exists make a new one and then add
				list = new ArrayList<ScheduleObject>();
			}
			// adding the schedule object
			list.add(scheObj);
			// push it to hash map
			hm.put(scheObj.getAreaId(), list);
			
		}

	}
	
	private static void processAllArea(HashMap<String, ArrayList<ScheduleObject>> hm,PriorityQueue<ScheduleObject> pq, WriteToOutput wto){
		// getting the iterator for the hash map
		Iterator<Map.Entry<String, ArrayList<ScheduleObject>>> itrMap = hm
				.entrySet().iterator();
		while (itrMap.hasNext()) {
			// HashMap area -- array value pair
			Map.Entry<String, ArrayList<ScheduleObject>> pair = (Entry<String, ArrayList<ScheduleObject>>) itrMap
					.next();
			// get the value : array
			ArrayList<ScheduleObject> areaArrayList = pair.getValue();
			// sort the arraylist
			processArea(areaArrayList, pq, wto);
		}
		
	}

	private static void processArea(ArrayList<ScheduleObject> areaArrayList,
			PriorityQueue<ScheduleObject> pq, WriteToOutput wto) {
		// sort the arraylist
		Collections.sort(areaArrayList);
		// new one priority queue
		pq = new PriorityQueue<ScheduleObject>(3, new MyComparator());
		// the list for each area
		for(int i = 0; i < areaArrayList.size(); i ++){
			// getting the object from the list
			ScheduleObject sobj =  areaArrayList.get(i);
			// iterate through the prority queue and find the same content id then judge whether to reject 
			boolean flag = writeSameIdToRej(pq, wto, sobj);
			// if rejected continue
			if (flag) {
				continue;
			}
			// if the size of queue is less than 3 then just add the obj and write the one with the least end time to output
			processDifferentContent(pq, sobj, wto);
		}
		// the last 3 elements to output in the area 
		writeHeapToFile(pq, wto);
	}

	private static void writeHeapToFile(PriorityQueue<ScheduleObject> pq,
			WriteToOutput wto) {
		// adding the last three elements in the heap to the output file
		Iterator<ScheduleObject> itrPqout = pq.iterator();

		while (itrPqout.hasNext()) {
			ScheduleObject lastout = itrPqout.next();
			wto.writeTo(lastout, outputfile);
		}

	}

	// comparator for the heap(min) by end time
	private static class MyComparator implements Comparator<ScheduleObject> {

		@Override
		public int compare(ScheduleObject o1, ScheduleObject o2) {
			// TODO Auto-generated method stub
			return o1.getEndTime() - o2.getEndTime();
		}

	}

	// same id overlap write to reject file
	private static boolean writeSameIdToRej(PriorityQueue<ScheduleObject> pq,
			WriteToOutput wto, ScheduleObject sobj) {

		// iterate through the prority queue
		ScheduleObject scheObjPq;
		Iterator<ScheduleObject> itrPq = pq.iterator();
		// go through the queue
		while (itrPq.hasNext()) {
			// object in the queue
			scheObjPq = itrPq.next();
			// if the content that is going to be added in has the same
			// id with one in the queue
			if (sobj.getContentId().equals(scheObjPq.getContentId())
					&& sobj.getStartTime() <= scheObjPq.getEndTime()) {
				// write to reject
				wto.writeTo(sobj, rejectfile);
				return true;
			}
		}
		return false;
	}

	private static void processDifferentContent(
			PriorityQueue<ScheduleObject> pq, ScheduleObject sobj,
			WriteToOutput wto) {
		if (pq.size() < 3) {
			pq.offer(sobj);
		} else {
			// peek the temp and get the min time
			ScheduleObject temp = pq.peek();
			int minEndTime = temp.getEndTime();
			// if the object's start time is less than the min end time
			if (sobj.getStartTime() > minEndTime) {
				// write the temp(the top on the heap with the min end
				// time) to the out put
				wto.writeTo(temp, outputfile);
				// then add the new object in
				System.out.println("get the minEndTime one out");
				pq.poll();
				pq.offer(sobj);

			} else {
				// if it is not (the fourth one at a time) write to the rejectfile
				wto.writeTo(sobj, rejectfile);
			}
		}
	}

}
