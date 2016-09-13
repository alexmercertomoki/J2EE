import java.util.HashSet;


public class Testing {

	public static void main(String[] args) {
		
		HashSet hs =new HashSet();
		
		hs.add(2);
		hs.add(3);
		hs.add(0);
		hs.add(4);
		
        boolean stillIn=false;
        
        for(int i =0;i < 5;i++ ){
        	
           if(i!=1&&!hs.contains(i)){
               stillIn=true;
           }
         
        }
        
        if(!stillIn){
        	System.out.println("last");
        }

	}

}
