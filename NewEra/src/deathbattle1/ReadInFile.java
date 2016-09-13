package deathbattle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReadInFile {

    public List<ScheduleObject> getSchedule(String fileName) {
        List<ScheduleObject> list = new ArrayList<ScheduleObject>();
        Scanner file = null;
        try {
            file = new Scanner(new File(fileName));
            while (file.hasNextLine()) {
                String line = file.nextLine();
                list.add(parseLine(line));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        } finally {
            if (file != null) {
                file.close();
            }
        }
        return list;
    }
    
    private ScheduleObject parseLine(String line) {
        String[] str = line.split(" ");
        ScheduleObject soj = new ScheduleObject()
                                 .withContentId(str[0])
                                 .withAreaId(str[1])
                                 .withStartTime(Integer.parseInt(str[2]))
                                 .withEndTime(Integer.parseInt(str[3]));
        return soj;
    }

    public Map<String, List<ScheduleObject>> getScheduleMap(String fileName) {
        Map<String, List<ScheduleObject>> hm = new HashMap<>();
        List<ScheduleObject> scheduleList = getSchedule(fileName);
        for (ScheduleObject scheObj : scheduleList) {
            if (hm.get(scheObj.getAreaId()) != null) {
                hm.get(scheObj.getAreaId()).add(scheObj);
            } else {
                List<ScheduleObject> list = new ArrayList<ScheduleObject>();
                list.add(scheObj);
                hm.put(scheObj.getAreaId(), list);
            }
        }
        return hm;
    }
}
