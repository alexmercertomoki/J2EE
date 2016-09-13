import java.util.HashSet;
import java.util.Set;


public class UniqueAbbr {
    Set<String> set = new HashSet<>();
    
    public UniqueAbbr(String[] dictionary) {
        
        for(String s : dictionary){
            String abbr = getAbbr(s);
            set.add(abbr);
        }
        
    }

    public boolean isUnique(String word) {
    	if(word.length() <= 2) return true;
        return !set.contains(word);
    }
    
    private String getAbbr(String s){
        int len  =  s.length();
        if(len <= 2) return s;
        
        else return s.charAt(0) + Integer.toString(len - 2) + s.charAt(len - 1);
    }
}