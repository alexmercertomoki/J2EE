package deathbattle;

import java.util.ArrayList;
import java.util.Iterator;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadInFile  rif = new ReadInFile();
		rif.getSchedule();
		
		ArrayList<ScheduleObject> arr = rif.getArr();
		Iterator<ScheduleObject> itr = arr.iterator();
		WriteToOutput wto = new WriteToOutput();
		
		while(itr.hasNext()){
			
			ScheduleObject soj = itr.next();
			System.out.println("content: " + soj.getContentId()+" area: "+ soj.getAreaId()+" starttime: "+ soj.getStartTime()+" endtime: "+soj.getEndTime());
			wto.writeTo(soj,"outputfile.txt");
			System.out.println("success");
			
		}
	}

}
