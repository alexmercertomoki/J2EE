package enter.web.project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Analyze {

	public static void main(String[] args) {
		// to get a new line in the log
		  String line = new String();
		  
		 // new scanner 
		  Scanner file = null;
		  // scan the file 
	        try {
	        	file = new Scanner(new File("access.log"));
	        } catch (FileNotFoundException f) {
	        	System.out.println("We can not find your file");
	        	System.exit(0);
	        }
	        // the hashmaps: vistor last time visits
	        HashMap<String, Integer> hmVisitor = new HashMap<String, Integer>();
	        // total visits for every visitor 
	        HashMap<String, Integer> hmVisitsPerVisitor = new HashMap<String, Integer>();
	        // visitor and all the requests he / she makes 
	        HashMap<String, LinkedList<String>> hmTotal = new HashMap<String, LinkedList<String>>();
	        // the first requst for this visit
	        HashMap<String, String> hmbeginningVisit = new HashMap<String, String>();
	        
	        // count all the pages he / she requested
	        int countPage = 0;
	        // the number of visits for all users
	        int numberOfVisits = 0;
	        // the total time for all visits adding together
	        double visitTotalTime =0;
	        // the number of bounces in total
	        int bounces = 0;
	        // the number of visitors 
	        int sumOfVisitor = 0;
	        
	    //    ArrayList<Integer> pagesEveryVisit = new ArrayList<Integer>(); 
	        
	        
	        // if the file has next line
	        while(file.hasNextLine() == true){
	        	// read the line and plus one to count page 
	        	 line = file.nextLine();
	        	 countPage ++;
	        	 // get the ip as visitor
	        	 String  visitor =  line.substring(0, line.indexOf("-"));
	        	 	// if contains this visitor
		        	 if(hmVisitor.containsKey(visitor)){
		        		 // req + 1 
		        		 hmVisitor.put(visitor, hmVisitor.get(visitor) + 1);
		        		 
		        		 // add the req to the linkedlist
		        		 LinkedList<String> temp = hmTotal.get(visitor);
		        		 // get the time 
		        		 String toGetTime = temp.peekLast();
		        		 String lastTime = toGetTime.substring(toGetTime.indexOf("[") + 1, toGetTime.indexOf("]"));
		        		 String thisTime = line.substring(toGetTime.indexOf("[") + 1, toGetTime.indexOf("]"));
		        	
		        		 // get the format to parse string
		        		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");
		        		 LocalDateTime lastdateTime = LocalDateTime.parse(lastTime, formatter); 
		        		 LocalDateTime thisdateTime = LocalDateTime.parse(thisTime, formatter); 
		        		 
		        		 // calculate the difference between two times
		        		 double diff = calcTimeDiff(lastdateTime, thisdateTime); 
		        		 // if no req for the visitor add the current one in 
		        		 if(hmbeginningVisit.get(visitor) == null){
		        			 hmbeginningVisit.put(visitor, line);
		        		 }
		        		 
		        		 // visit ends
		        		 if(diff > 30){
		        			 // calculate the visits for each visitor
		        			 if(hmVisitsPerVisitor.get(visitor) == null){
		        				 hmVisitsPerVisitor.put(visitor, 1);
		        			 }else{
		        				 hmVisitsPerVisitor.put(visitor, hmVisitsPerVisitor.get(visitor) + 1);
		        			 }
		        			 //get the difference between the end time and the beginning time of a visit
		        			 String t1 = hmbeginningVisit.get(visitor).substring(toGetTime.indexOf("[") + 1, toGetTime.indexOf("]"));
		        			 LocalDateTime beginVisitTime = LocalDateTime.parse(t1, formatter); 
		        			
		        			 visitTotalTime += calcTimeDiff(beginVisitTime, lastdateTime);
		        			
		        			 //number of visits
		        			 numberOfVisits++;
		        			 
		        			 // calculate the total bounce times
		        			 if(hmVisitor.get(visitor) - 1 == 1){
		        				 bounces ++;
		        			 }
		        			 
		        			 // adding each time of visit to the list 
		        			// pagesEveryVisit.add(hmVisitor.get(visitor) - 1);
		        			 hmVisitor.put(visitor, 0); // set to zero again 
		        			 
		        			 //  calculating average visit duration 
		        			 
		        		 }
		        		 
		        		 //adding the line of request to the total requests for each visitor
		        		 temp.add(line);
		        		 hmTotal.put(visitor, temp);
		        		
		        	 } else{
		        		 // initializing
		        		 hmVisitor.put(visitor, 1);
		        		 LinkedList<String> temp = new LinkedList<String>();
		        		 temp.add(line);
		        		 hmTotal.put(visitor, temp);
		        		 
		        		 if(hmVisitsPerVisitor.get(visitor) == null){
	        				 hmVisitsPerVisitor.put(visitor, 1);
	        			 }
		        		//number of visits
	        			 numberOfVisits++;
		        	 }
		        	 
		        	
		        		
		        }
	        
	        // visitors and visiting times 
	        	for(Map.Entry<String, Integer> entry : hmVisitor.entrySet()){
	        		System.out.println("Unique Visitors: ");
	        		System.out.println(entry.getKey());
	        		sumOfVisitor += 1;
	        		
	        	}
	        	
	        	//sum of unique visitors :
	        	System.out.println("Number of Unique Visitors "  +  sumOfVisitor);
	        	// pages views   
	        	System.out.println("Page Views : "  +  countPage);
	        	
	        	// total number of visits 
	        	System.out.println("Real Number of Visits : " + numberOfVisits);
	        	// calculating avg pages per visit
	        	System.out.println("Average Pages Per visit: " + countPage / numberOfVisits);
	        	// duration per visit
	        	System.out.println("Average Duration Per visit: " + Math.round(visitTotalTime / numberOfVisits) + " minutes");
	        	
	        	// calculating the bounce rate :
	        	System.out.println("Bounce rate : " + Math.round(((double)bounces / (double)numberOfVisits) * 100) +"%");
	        	// percentage of newVisit
	        	double percentage = (double)sumOfVisitor / (double)numberOfVisits;
	        	
	        	System.out.println("Percentage of New Visits: "  + Math.round(percentage * 100) +"%");
	        	
	        	
	        }
	
	
	// calculating the time difference 
	private static double calcTimeDiff(LocalDateTime t1, LocalDateTime t2){
		double ttime = t2.getYear() * 525600 +  
				t2.getMonthValue() * 43800 +
				t2.getDayOfMonth() * 1440 + 
				t2.getHour() * 60 + t2.getMinute();
		
		double ltime = t1.getYear() * 525600 +  
				t1.getMonthValue() * 43800 +
				t1.getDayOfMonth() * 1440 + 
				t1.getHour() * 60 + t1.getMinute();
		
		
		return ttime - ltime;
	}
	
	
}
