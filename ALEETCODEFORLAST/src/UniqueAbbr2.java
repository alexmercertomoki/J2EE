import java.util.HashMap;
import java.util.Map;




public class UniqueAbbr2 {
    Map<String, String> map = new HashMap<>();

    public UniqueAbbr2(String[] dictionary) {
        
        for(String s : dictionary){
            String abbr = getAbbr(s);
            // ??????????? 
            if(map.containsKey(abbr)){
                if(!map.get(abbr).equals(s)){
                    map.put(abbr, "");
                }
            } else {
                map.put(abbr, s);
            }
            
        }
        
    }

    public boolean isUnique(String word) {
        return !map.containsKey(getAbbr(word)) || map.get(getAbbr(word)).equals(word);
    }
    
    private String getAbbr(String word){
        int len = word.length();
        if(len <= 2) return word;
        else return word.charAt(0) + Integer.toString(len - 2) + word.charAt(len - 1);
                
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");