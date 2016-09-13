package lintCodeWorkOut;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedArrays {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
     
    private class Ele{
        int row;
        int col; 
        int val; 
        public Ele(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        } 
            
    }
    class MyComparator implements Comparator<Ele> {
        @Override
        public int compare(Ele e1, Ele e2) {
            if(e1.val - e2.val > 0) {
                return 1;
            } else if(e1.val - e2.val == 0) {
                return 0;
            } else {
                return -1;
            }
        }
        
    }
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        
        List<Integer> result = new ArrayList<Integer>();
        //edge 
        if(arrays == null || arrays.length == 0) {
            return result;
        }
        // Write your code here
        PriorityQueue<Ele> pq = new PriorityQueue<Ele>(arrays.length, new MyComparator());

        for(int i = 0; i < arrays.length; i++) {
            if(arrays[i].length != 0) {
                pq.offer(new Ele(i, 0, arrays[i][0]));
            }
        }
        
        while(!pq.isEmpty()) {
            Ele e = pq.poll();
            result.add(e.val);

            if(++e.col < arrays[e.row].length) { // + 1 
                e.val = arrays[e.row][e.col];
                pq.offer(e);
            }
        }
        
        return result;
        
    }
}