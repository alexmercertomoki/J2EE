// ======================= WordCount.java ==========================================


import java.io.IOException;
import java.util.StringTokenizer;

import javax.naming.Context;
import javax.tools.Tool;
import javax.xml.soap.Text;


public class TotalWords{

       public static void main(String[] args) {
    	  
//    	   String line = "X	         Y      	Time	Street	        Offense	Date     	Tract";
    	   String line ="1354326.897	411447	32875	900 WHITESIDE RD	AGGRAVATED ASSAULT	1/2/1990	50900";
           String[] strarray = line.split("\t");
//           for(String v:strarray){
//        	   System.out.println(v);
//           }
           
           
//           System.out.println(strarray[4].trim());
           double distance=0.00;
           if(!strarray[0].equals("X")&&strarray.length>4){
        	   	double x=Double.parseDouble(strarray[0]);
        	   	double y=Double.parseDouble(strarray[1]);
        	   	
        	   	distance= Math.sqrt((x-1354326.897)*(x-1354326.897)+(y-411447.7828)*(y-411447.7828));
        	   	System.out.println(distance);
        	   	if(distance<=3000){
        	   		System.out.println(strarray[4]);
        	   	}
                
           }

	   }
       
} 
