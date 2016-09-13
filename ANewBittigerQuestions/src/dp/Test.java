package dp;

public class Test {
	public static void main(String[] args) {
		WildCard card = new WildCard();
		boolean b = card.isMatch("aa", "a*");
		System.out.println(b);
	}

}
