package godaddyOA;

import java.util.Arrays;

public class ZigzagArray2 {
	
	static int[] wiggleArrangeArray(int[] intArr) {
        if(intArr == null || intArr.length == 0) {
            return intArr;
        }
        
        Arrays.sort(intArr);
        int[] result = new int[intArr.length];
        
        int index = 0;
        for(int i = 0, j = intArr.length - 1; i <= j; ) {
            if(index % 2 == 0) {
                result[index] = intArr[j--];
            } else {
                result[index] = intArr[i++];
            }
            index++;
        } 
        return result;
    }

}
