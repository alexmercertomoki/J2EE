package amazon_future;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        StringBuilder  sb = new StringBuilder();
        
        while(sc.hasNextLine()){
            arr.add(Integer.parseInt(sc.nextLine()));
        }
        int curFar = -1, curEnd = 0, index =- 1;
        boolean flag = false;       
        for(int i = 0; i < arr.size(); i ++ ){
            if(curFar < i + arr.get(i)){
                index = i;
                curFar = i + arr.get(i);
                
            }
            if(i == curEnd){
                if(curEnd == curFar){
                    flag = true; 
                    break;
                }
                sb.append(i + ", ");
                curEnd = curFar;
                if (curEnd > arr.size() - 1) {
                    break;
                }
            }
            
        }
        sb.append("out");     
        if(flag){
            System.out.println("failure");
        } else{
            System.out.println(sb.toString());
        } 
                    
    }
}