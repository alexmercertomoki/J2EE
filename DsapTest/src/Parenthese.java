import java.util.Stack;

public class Parenthese {

	static public boolean isValid(String s) {

		if (s == null || s.length() == 0)
			return true;
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			if (stack.empty())
				stack.push(s.charAt(i));
			else if (s.charAt(i) - stack.peek() == 1
					|| s.charAt(i) - stack.peek() == 2) {
				System.out.println(s.charAt(i) - stack.peek());
				stack.pop();
			}

			else
				stack.push(s.charAt(i));
		}

		return stack.empty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isValid("ab");

	}

}
