package deathbattle;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class WriteToOutput {
	
	public void writeTo(ScheduleObject soj, String fileName){
		try {
			
			PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(fileName,true)));
			
			pr.print(soj.getContentId() + " ");
			pr.print(soj.getAreaId() + " ");
			pr.print(soj.getStartTime() + " ");
			pr.print(soj.getEndTime());
			pr.println("");
			
			pr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
