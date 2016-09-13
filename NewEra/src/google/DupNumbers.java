package google;


public class DupNumbers{ 
	public static int[] duplicateNumber(int[] input){
	    int[] result = new int[input.length+1];
	    if(input == null ||input.length == 0) return new int[0];
	    if(input.length == 1) return new int[]{input[0],input[0]};
	    int i = 0; 
	    int j = 0;
	    while(i < input.length - 1){
	            if(input[i] <= input[i+1]) {
	                    result[j++] = input[i++];
	            }
	            else{
	                    result[j++] = input[i];
	                    while(j < result.length)
	                            result[j++] = input[i++];
	                    return result;
	                    
	            }
	            
	    }
	    result[j] = input[input.length - 1];
	    result[j+1] = input[input.length - 1];
	    return result;
	}
}
