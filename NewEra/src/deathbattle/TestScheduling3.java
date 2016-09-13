package deathbattle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TestScheduling3 {

	public static void main(String[] args) {

		// read the file to an array list
		ReadInFile rif = new ReadInFile();
		rif.getSchedule();
		ArrayList<ScheduleObject> cmArr = rif.getArr();
		// key is area id array list is a list of
		HashMap<String, ArrayList<ScheduleObject>> hm = new HashMap<String, ArrayList<ScheduleObject>>();
		// iterator for array list to iterate all the schedule objects
		Iterator<ScheduleObject> itr = cmArr.iterator();

		// iteration adding all schedule objects to the hashmap
		while (itr.hasNext()) {

			ScheduleObject scheObj = itr.next();
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

		// getting the iterator for the hash map
		Iterator<Map.Entry<String, ArrayList<ScheduleObject>>> itrMap = hm
				.entrySet().iterator();
		// prority queue to hold only 3 elements representing the schedule
		// capacity at a certain time is 3
		PriorityQueue<ScheduleObject> pq = null;
		// write to file object for further use
		WriteToOutput wto = new WriteToOutput();
		// iterate through the hash map
		while (itrMap.hasNext()) {
			// HashMap area -- array value pair
			Map.Entry<String, ArrayList<ScheduleObject>> pair = (Entry<String, ArrayList<ScheduleObject>>) itrMap
					.next();
			// get the value : array
			ArrayList<ScheduleObject> areaArrayList = pair.getValue();
			// sort the arraylist
			Collections.sort(areaArrayList);
			// new one priority queue
			pq = new PriorityQueue<ScheduleObject>(3,new MyComparator());
			// the list for each area
			Iterator<ScheduleObject> itrForEachArea = areaArrayList.iterator();
			// going through the list
			traverseArea:
			while (itrForEachArea.hasNext()) {
				// getting the object from the list
				ScheduleObject sobj = itrForEachArea.next();
				// initiate the priority queue
				ScheduleObject scheObjPq = null;

				// iterate through the prority queue
				Iterator<ScheduleObject> itrPq = pq.iterator();
				// go through the queue
				while (itrPq.hasNext()) {
					// object in the queue
					scheObjPq = itrPq.next();
					// if the content that is going to be added in has the same
					// id with one in the queue
					if (sobj.getContentId().equals(scheObjPq.getContentId()) && sobj.getStartTime() <= scheObjPq.getEndTime()) {
						// write to reject
						wto.writeTo(sobj, "rejectfile.txt");
						continue traverseArea;
					}
				}
				// if the size of queue is less than 3 then just add the obj
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
						wto.writeTo(temp, "outputfile.txt");
						// then add the new object in
						System.out.println("get the minEndTime one out");
						pq.poll();
						pq.offer(sobj);

					} else {
						// if it is not (the fourth one at a time) write to the
						// rejectfile
						wto.writeTo(sobj, "rejectfile.txt");
					}
				}
				

			}
			// adding the last three elements in the heap to the output file
			Iterator<ScheduleObject> itrPqout = pq.iterator();

			while (itrPqout.hasNext()) {
				ScheduleObject lastout = itrPqout.next();
				wto.writeTo(lastout, "outputfile.txt");
			}
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

}
