package systemDesign;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Twitter {
	
	HashSet<User> allUsers =  new HashSet<User>();
	class User {
		ArrayList<String> marr;
		Set<User> subset;
		
		public int subscribe(User u) {
			if(allUsers.contains(u)) {
				subset.add(u);
			}
			return subset.size();
		}
		
		public boolean unsubscribe(User u) {
			if(subset.contains(u)) {
				subset.remove(u);
				return true;
			}
			return false;
			
		}
		
		public User() {
			marr = new ArrayList<>();
			subset = new HashSet<User>();
		}
		
		
		
		
		
	}

}
