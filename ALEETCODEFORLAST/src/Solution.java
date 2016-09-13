import java.util.HashSet;
import java.util.Set;


public class Solution {
    public boolean isHappy(int n) {
        if(n <= 0) {
            return false;
        }
        Set<Integer> s = new HashSet<Integer>();
        while(n != 1) {
            int sum = 0;
            while(n != 0) {
                int mod = n % 10;
                sum += mod * mod;
                n /= 10;
            }
            if(s.contains(sum))
                return false;
            n = sum;
            s.add(sum);
        }
        return true;
    }
}

