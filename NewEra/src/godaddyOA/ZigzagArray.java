package godaddyOA;

import java.util.Arrays;

public class ZigzagArray {
	
	static int[] wiggleArrangeArray(int[] intArr) {
        if(intArr == null || intArr.length == 0) {
            return intArr;
        }
        
        Arrays.sort(intArr);
        int[] result = new int[intArr.length];
        
        int i = 0, j = intArr.length - 1;
        for(int index = 0; index < intArr.length; index++) {
            if(index % 2 == 0) {
                result[index] = intArr[j--];
            } else {
                result[index] = intArr[i++];
            }
        } 
        return result;
    }

}
