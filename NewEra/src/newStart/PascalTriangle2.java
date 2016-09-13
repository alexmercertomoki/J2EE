package newStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {
	    public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> listOfList = new ArrayList<List<Integer>>(numRows);
	        
	        for(int i = 1; i <= numRows; i ++){
	            List<Integer> tempList = new ArrayList<Integer>();
	            
	            if(!listOfList.isEmpty()){
	                tempList = listOfList.get(i - 2);
	            }
	            
//	            List<Integer> listRow = new ArrayList<Integer>(i);
//	            listRow.add(0, 1);
//	            listRow.add(i - 1, 1); // list size() is the total number of  elements in the list // one more thing:
	            //  you can't get you can't set.. so you can't set the third element skipping the second one 
	            
	            Integer[] arrayRow = new Integer[i];
	            arrayRow[0] = 1;
	            arrayRow[i - 1] = 1;
	            
	            for(int j = 1; j < i - 1; j ++){
//	                listRow.add(j, tempList.get(j - 1) + tempList.get(j));
	            	arrayRow[j] = tempList.get(j - 1) + tempList.get(j) ;
	            }
	            
	            listOfList.add(Arrays.asList(arrayRow)); // addAll is concatenating 
	            
	        }
	        return listOfList;
	    }
	    
}
