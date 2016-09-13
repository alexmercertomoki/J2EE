package array;

import java.util.Stack;

public class NextGreaterElement {
	
	
	public int[] nextGreaterElement(int[] numbers) {
		Stack<Integer> monoStack = new Stack<>();
		monoStack.push(numbers[numbers.length - 1]);
		numbers[numbers.length - 1] = -1;
		
		for(int i = numbers.length - 2; i >= 0; i--) {
			if(numbers[i] < monoStack.peek()) {
				int temp = numbers[i];
				numbers[i] = monoStack.peek();
				monoStack.push(temp);
			} else {
				while(!monoStack.isEmpty() && monoStack.peek() < numbers[i]) {
					monoStack.pop();
				}
				if(monoStack.isEmpty()) {
					numbers[i] = -1;
				} else {
					int temp = numbers[i];
					numbers[i] = monoStack.peek();
					monoStack.push(temp);
				}
			}
		}
		return numbers;
	}

}
