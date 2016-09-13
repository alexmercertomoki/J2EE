package deathbattle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadInFile {
	// a1 - a6 six areas
	// each has a value of being clicked
	//


	private Scanner file;

	public ArrayList<ScheduleObject> getSchedule(String fileName) {

		ArrayList<ScheduleObject>  arr = new ArrayList<ScheduleObject>();
		
		
		try {

			file = new Scanner(new File(fileName));
			while (file.hasNextLine()) {

				String line = file.nextLine();
				// System.out.println(line);
				String[] str = line.split(" ");
				ScheduleObject soj = new ScheduleObject();
				soj.setContentId(str[0]);
				soj.setAreaId(str[1]);
				soj.setStartTime(Integer.parseInt(str[2]));
				soj.setEndTime(Integer.parseInt(str[3]));
				arr.add(soj);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found sorry. ");
		}

		return arr;

	}

	public ArrayList<InsertObject> getInsertObject(String fileName) {
		
		ArrayList<InsertObject>  arr = new ArrayList<InsertObject>();
		
		try {

			file = new Scanner(new File(fileName));
			while (file.hasNextLine()) {

				String line = file.nextLine();
				// System.out.println(line);
				String[] str = line.split(" ");
				InsertObject insertObj = new InsertObject();
				insertObj.setContentId(str[0]);
				insertObj.setLength(Integer.parseInt(str[1]));
				insertObj.setValue(Integer.parseInt(str[2]));
				arr.add(insertObj);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found sorry. ");
		}
		return arr;

	}

}
