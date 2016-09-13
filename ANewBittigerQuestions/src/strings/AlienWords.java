//package strings;
//
//public class AlienWords {
// public String alienOrder(String[] words) {
//	int[][] graph = new int[26][26];
//	int[] status = new int[26];
//
//	public String alienOrder(String[] words) {
//	    buildGraph(words);
//
//	    StringBuilder sb = new StringBuilder();
//	    char v=' ';
//	    
//	    for(int i=0;i<status.length;i++){
//	        if(status[i]==1){
//	            v = (char)(i+'a');
//	            if(!runDFS(v, sb)) return "";
//	        } 
//	    }
//	    return sb.reverse().toString();
//	    
//	}
//	private boolean runDFS(char v, StringBuilder sb){
//	    if(status[v-'a']==2) return false; // detect back edge
//	    if(status[v-'a']==3) return true;  // detect cross edge
//	    
//	    status[v-'a'] = 2; // discoverd
//	    
//	    // check neighbors of vertex v
//	    for(int i=0;i<26;i++){
//	        if(graph[v-'a'][i]==1){
//	            if(!runDFS((char)(i+'a'), sb)) return false;
//	        }
//	    }
//	    status[v-'a']=3; //finished
//	    sb.append(v);
//	    return true;
//	}
//	private void buildGraph(String[] words){
//	    for(int i=0;i<words.length;i++){
//	        for(int j=0;j<words[i].length();j++){
//	            // vertice.
//	            status[words[i].charAt(j)-'a']=1;
//	        }
//	    }
//	    for(int i=0;i<words.length-1;i++){
//	        int min = Math.min(words[i].length(), words[i+1].length());
//	        for(int p=0;p<min;p++){
//	            char c1 = words[i].charAt(p);
//	            char c2 = words[i+1].charAt(p);
//	            
//	            if(c1!=c2){
//	                //build a graph c1->c2
//	                graph[c1-'a'][c2-'a'] = 1;
//	                break;
//	            }
//	        }
//	    }
//	}
//
//
//	
// }
//}
