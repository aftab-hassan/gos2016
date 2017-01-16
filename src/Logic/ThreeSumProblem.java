package Logic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/*
 * README Aftab : 
 * 1. j = i+1 thinking, since if j  starts from 0, then it should've been covered by i==0
 * 2. a.length-1 or a.length-2 
 */
/*
 * ThreeSum.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

/**
 * @author aftabhassan
 *
 */
public class ThreeSumProblem {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        int[] a = {-2, -1, 0, 0, 0, 1, 1, 1, 1, 2};
//        int[] a = {-1, 0, 1, 2, -1, -4};
//        int[] a = {0, 0, 0};
//        int[] a = {0, 0};
        
        ThreeSumProblem obj = new ThreeSumProblem();
        System.out.println( obj.threeSumn3( a ) );
        System.out.println( obj.threeSumn2Hashtable( a ) );
        System.out.println( obj.threeSumn2logn( a ) );
    }
    
    /* O(n^2 logn) */
    public List<List<Integer>> threeSumn2logn(int[] a) {
//        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        
        Arrays.sort( a );
        int i = 0;
        while (i<a.length-1)
        {
            int starti = i;
            int l = i+1;
            int r = a.length-1;
            while( l < r )
            {
                if(a[i] + a[l] + a[r] == 0)
                {
//                    ArrayList<Integer> tuple = new ArrayList<>();
                    List<Integer> tuple = new ArrayList<Integer>();
                    tuple.add( a[i] );tuple.add( a[l] );tuple.add( a[r] );
                    output.add( tuple );
                    
                    int startl = l;
                    while( a[startl] == a[l] && l < r)
                        l++;
                    
                    int startr = r;
                    while( a[startr]==a[r] && r > l)
                        r--;
                }
                
                else if(a[i] + a[l] + a[r] < 0)
                    l++;
                else
                    r--;
            }
            
            i = starti;
            while(a[i] == a[starti] && i < a.length-1)
                i++;
        }
        
        return output;
    }
    
    /* O(n^2) with Hashtable */
    public ArrayList<ArrayList<Integer>> threeSumn2Hashtable(int[] a) {
        
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        
        Hashtable<Integer, Integer> myHashtable = new Hashtable<>();
        for(int i = 0;i<a.length;i++)
            myHashtable.put(a[i], i);
        
        /* O(n^2) with extra space */
        for( int i = 0;i<a.length-1;i++)
        {
            if(i == 0 || a[i] > a[i+1])
                findTriplet(a, -a[i], myHashtable, output, i );
        }
        
        return output;
    }
    
    public void findTriplet(int[] a, int sum, Hashtable<Integer, Integer> myHashtable, ArrayList<ArrayList<Integer>> output, int firstIndex)
    {
        for(int i = firstIndex+1;i<a.length;i++)
        {
            int secondIndex = i;
            if(myHashtable.containsKey(sum-a[i]) && myHashtable.get(sum-a[i]) != firstIndex && myHashtable.get(sum-a[i]) != secondIndex )
            {
                ArrayList<Integer> tuple = new ArrayList<Integer>();
                tuple.add(a[firstIndex]);
                tuple.add(a[secondIndex]);
                tuple.add(sum-a[i]);
                
                output.add(tuple);
            }
        }
    }
    
    /* O(n^3) */
    public ArrayList<ArrayList<Integer>> threeSumn3(int[] a) {    
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        
        /* O(n^2) with extra space */
        for( int i = 0;i<a.length;i++)
        {
            for(int j = i+1;j<a.length;j++)
            {
                for(int k = j+1;k<a.length;k++)
                {
                    if(a[i] + a[j] + a[k] == 0)
                    {
                        ArrayList<Integer> tuple = new ArrayList<Integer>();
                        tuple.add(a[i]);tuple.add(a[j]);tuple.add(a[k]);
                        output.add(tuple);
                    }
                }
            }
        }
        
        return output;
    }
    
    public List<List<Integer>> threeSumProgramCreek(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
     
        if(nums == null || nums.length<3)
            return result;
     
        Arrays.sort(nums);
     
        for(int i=0; i<nums.length-2; i++){
            if(i==0 || nums[i] > nums[i-1]){
                int j=i+1;
                int k=nums.length-1;
     
                while(j<k){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);
     
                        j++;
                        k--;
     
                        //handle duplicate here
                        while(j<k && nums[j]==nums[j-1])
                            j++;
                        while(j<k && nums[k]==nums[k+1])
                            k--;
     
                    }else if(nums[i]+nums[j]+nums[k]<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }
     
        }
     
        return result;
    }

}
