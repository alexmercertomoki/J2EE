package quiz4;

public class Rotation {
	public int search(int[] data, int key){
		return recSearch(data,0,data.length-1,key);
	}
	private int recSearch(int[] data, int low, int high, int key) {
		if(low>high) return -1;
		int mid= low+ (high-low)/2;
		
		if(data[mid]==key) return mid;
		if(data[mid]>=data[low]){
			if(data[low]<=key&&key<data[mid]){
				return recSearch(data, low, mid-1, key);
			}
			else{
				return recSearch(data, mid+1, high, key);
			}
		}
		else{
			if(data[mid]<key&&key<=data[high])
				return recSearch(data, mid+1, high, key);
			else
				return recSearch(data, low, mid-1, key);
		}
		
	}
	
	public static void main(String[] args) {
		Rotation r=new Rotation();
		int[] data={1,2,3,4,5};
		int i = r.search(data, 5);
		System.out.println(i);
		
	}
}
