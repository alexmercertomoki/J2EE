package strings;

import java.util.List;

public class Test {
	public static void main(String[] args) {
//		BasicCalcs bc = new BasicCalcs();
//		int ret = bc.calculate("2 + 3");
//		System.out.println(ret);
		
//		System.out.println('A' - '1');
//		SimplifyPath s = new SimplifyPath();
//		s.simplifyPath("/.../");
		
//		RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
//		List<String> list = rip.removeInvalidParentheses("())");
		
//		DecodeString dcs = new DecodeString();
//		dcs.decodeString("3[a2[c]]");
		
		
//		String s = "sbc";
//		s += ']'; // string + char is OK!!!!
//		System.out.println(s);
		
//		DecodeString ds = new DecodeString();
//		ds.decodeString3("3[a2[c]]");
		
		LongestSubStringWithoutRepeating lsswr = new LongestSubStringWithoutRepeating();
		int max = lsswr.lengthOfLongestSubstring("abcadef");
		System.out.println(max);
		
	}
}
