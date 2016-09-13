package deathbattle1;

import java.util.List;
import java.util.Map;

public class Maindriver {
    
    private static final String INPUTFILE = "outputfile";
    
    public static void main(String[] args) {
        ReadInFile rif = new ReadInFile();
        Map<String, List<ScheduleObject>> hm = rif.getScheduleMap(INPUTFILE);
        
        ScheduleHandler handler = new ScheduleHandler();
        List<Map<String, List<ScheduleObject>>> validSchedule = handler.getValidSchedule(hm);
        
        System.out.println(validSchedule);
    }
}
