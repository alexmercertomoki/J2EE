package google;

public class DuplicateNumberMine {
	
	public int[] dupNum(int[] input) {
		if(input == null || input.length == 0) {
			return new int[0];
		}
		
		int[] result = new int[input.length + 1];
		
		if(input.length == 1) {
			result[0] = input[0];
			result[1] = input[0];
			return result;
		}
		
		int j = 0;
		for(int i = 0; i < input.length - 1; i++) {
			if(input[i] > input[i + 1]) {
				result[j++] = input[i];
				while(i < input.length) {
					result[j++] = input[i++];
				}
				return result;
						
			} else {
				result[j++] = input[i];
			}
			
		}
		
		result[input.length - 1] = input[input.length - 1];
		result[input.length] = input[input.length - 1];
		
		return result;
	}

}
