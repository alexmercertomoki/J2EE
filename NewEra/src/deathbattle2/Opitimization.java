package deathbattle2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import deathbattle2.ScheduleObject;


public class Opitimization {
	
	public ArrayList<ScheduleObject> readSchedule(String fileName){

		ReadInFile readInFile = new ReadInFile(); 
		
		ArrayList<ScheduleObject> commerceArrayList = readInFile.getSchedule(fileName);
		return commerceArrayList; 
	}
	
	
	public ArrayList<InsertObject> readInsertObject(String fileName){

		ReadInFile readInFile = new ReadInFile(); 
		ArrayList<InsertObject> insertArrayList = readInFile.getInsertObject(fileName);
		return insertArrayList; 
		
	}
	
	
	public void InsertSchedule(){
		
		ArrayList<ScheduleObject> arraylistOfSchedule = this.readSchedule("adfile.txt");
		
		HashMap<String, ArrayList<ScheduleObject>> hm = new HashMap<String, ArrayList<ScheduleObject>>();
		
		this.splitListByArea(arraylistOfSchedule, hm);
		
		HashMap<String, ArrayList<ArrayList<Interval>>>  allAreaInterval = this.findIntervalAllArea(hm);
		ArrayList<InsertObject> arrInsertCandidate = this.readInsertObject("inserted.txt");
		
		// sort the candidates by value and put higher value in the better area 
		// try using smaller pieces at first 
		// try putting 
		
		
		
	}
	
	public void splitListByArea(ArrayList<ScheduleObject> arraylistOfSchedule, HashMap<String, ArrayList<ScheduleObject>> hm){
		
		for(int i = 0; i < arraylistOfSchedule.size(); i ++){
			ScheduleObject tempObjToAdd = arraylistOfSchedule.get(i);
			if(hm.get(tempObjToAdd.getAreaId()) != null){
				ArrayList<ScheduleObject> tempArrAdding = hm.get(tempObjToAdd.getAreaId());
				tempArrAdding.add(tempObjToAdd);
				hm.put(tempObjToAdd.getAreaId(), tempArrAdding);
			} else{
				ArrayList<ScheduleObject> tempArrAdding = new ArrayList<ScheduleObject>();
				tempArrAdding.add(tempObjToAdd);
				hm.put(tempObjToAdd.getAreaId(), tempArrAdding);
				
			}

		}
		
	}
	
	
	
	public HashMap<String, ArrayList<ArrayList<Interval>>> findIntervalAllArea(HashMap<String, ArrayList<ScheduleObject>> hm){

		HashMap<String, ArrayList<ArrayList<Interval>>> areaIntervalMap = new HashMap<String, ArrayList<ArrayList<Interval>>>();
		
		Iterator<Map.Entry<String, ArrayList<ScheduleObject>>> scheduleMapItr = hm.entrySet().iterator();
		
		while(scheduleMapItr.hasNext()){
			
			Map.Entry<String, ArrayList<ScheduleObject>> scheAreaObjPair = scheduleMapItr.next();
			ArrayList<ScheduleObject> areaTempScheduleList = scheAreaObjPair.getValue(); 
			Collections.sort(areaTempScheduleList,new ScheduleStartTimeComparator());
			
			ArrayList<ArrayList<Interval>>  areaInterval = this.findIntervalEachArea(areaTempScheduleList);
			areaIntervalMap.put(scheAreaObjPair.getKey(), areaInterval);
		}
		
		return areaIntervalMap;
	}
	
	
	public ArrayList<ArrayList<Interval>> findIntervalEachArea(ArrayList<ScheduleObject> areaTempScheduleList){
		
		
		ArrayList<ArrayList<Interval>> areaIntervalList = new ArrayList<ArrayList<Interval>>();
		
		ArrayList<Interval> temp1 = new ArrayList<Interval>();
		ArrayList<Interval> temp2 = new ArrayList<Interval>();
		ArrayList<Interval> temp3 = new ArrayList<Interval>();
		
		int temp1EndTime = 0; 
		int temp2EndTime = 0; 
		int temp3EndTime = 0; 
		
		
		for(int i = 0; i < areaTempScheduleList.size(); i ++ ){

			ScheduleObject tempScheduleObject = areaTempScheduleList.get(i);
			Interval interval;
			
			if(temp1EndTime < tempScheduleObject.getStartTime()){
				interval = new Interval(temp1EndTime, tempScheduleObject.getStartTime());
				temp1.add(interval);
				temp1EndTime = tempScheduleObject.getEndTime();
				
			} else if(temp2EndTime < tempScheduleObject.getStartTime()) {
				interval = new Interval(temp2EndTime, tempScheduleObject.getStartTime());
				temp2.add(interval);
				temp2EndTime = tempScheduleObject.getEndTime();
			} else if(temp3EndTime < tempScheduleObject.getStartTime()) {
				
				interval = new Interval(temp3EndTime, tempScheduleObject.getStartTime());
				temp3.add(interval);
				temp3EndTime = tempScheduleObject.getEndTime();
			}
			
		}
		
		areaIntervalList.add(temp1);
		areaIntervalList.add(temp2);
		areaIntervalList.add(temp3);
		
		return areaIntervalList;
		
	}
	
	private class ScheduleStartTimeComparator implements Comparator<ScheduleObject>{ // class 
		
		@Override
		public int compare(ScheduleObject o1, ScheduleObject o2) {
			// TODO Auto-generated method stub
			return o1.getStartTime() - o2.getStartTime();
		}
		
	}
	
	
	

}


